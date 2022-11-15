package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.jasypt.util.password.StrongPasswordEncryptor;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private final PeliculaRepo peliculaRepo;
    @Autowired
    private final CompraRepo compraRepo;

    @Autowired
    private final EmailService emailService;
    @Autowired
    private final FuncionRepo funcionRepo;

    private final CuponClienteRepo cuponClienteRepo;

    private final CiudadRepo ciudadRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo, PeliculaRepo peliculaRepo, CompraRepo compraRepo, EmailService emailService, FuncionRepo funcionRepo, CuponClienteRepo cuponClienteRepo, CiudadRepo ciudadRepo) {
        this.clienteRepo = clienteRepo;
        this.peliculaRepo = peliculaRepo;
        this.compraRepo = compraRepo;
        this.emailService = emailService;
        this.funcionRepo = funcionRepo;
        this.cuponClienteRepo = cuponClienteRepo;
        this.ciudadRepo = ciudadRepo;

    }

    @Override
    public Cliente login(String correo, String password) throws Exception {
        Cliente cliente = clienteRepo.findById(correo).orElse(null);

        if (cliente == null) throw new Exception("No existe un usuario con el correo que ingresaste");
        if (cliente.getEstado().equals(false)) throw new Exception("La cuenta del usuario está inactiva; ésta debe ser verificada a través del enlace enviado al correo");

        StrongPasswordEncryptor spe = new StrongPasswordEncryptor();

        if (!spe.checkPassword( password, cliente.getPassword())) throw new Exception("La contraseña ingresada es incorrecta");

        return cliente;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception{
        Optional<Cliente> clienteExiste =  clienteRepo.findById(cliente.getCedula());
        if (clienteExiste.isPresent()) throw new Exception("Ya existe un usuario con la cédula ingresada.");

        boolean correoExiste = esCorreoRepetido(cliente.getCorreo());
        if (correoExiste) throw new Exception("El correo ingresado ya está siendo usado por otro usuario.");

        StrongPasswordEncryptor spe = new StrongPasswordEncryptor();
        cliente.setPassword( spe.encryptPassword(cliente.getPassword()) );

        cliente.setEstado(false);

        Cliente registro = clienteRepo.save(cliente);

        AES256TextEncryptor textEncryptor = new AES256TextEncryptor();
        textEncryptor.setPassword("teclado");
        String parametro1 = textEncryptor.encrypt(registro.getCorreo());

        emailService.enviarEmail("Bienvenido",
                "Te has registrado en nuestra plataforma, Para confirmar tu correo, ingresa al siguiente link: " + ""+parametro1, cliente.getCorreo());
        return registro;
    }

    private boolean esCorreoRepetido(String correo) {
        Cliente cliente =  clienteRepo.findByCorreo(correo);
        if (cliente == null){
            return false;
        }
        return true;
    }

    @Override
    public Cliente actualizarCliente(Cliente cliente) throws Exception {
        Cliente guardado = clienteRepo.findClienteByCedula(cliente.getCedula());
        if (guardado.getCedula().equals("")) throw new Exception("Cliente no encontrado");
        return clienteRepo.save(cliente);
    }

    @Override
    public void eliminarCliente(String cedulaCliente) throws Exception{
        Cliente cliente = clienteRepo.findClienteByCedula(cedulaCliente);
        if (cliente.getCedula().equals("")) throw new Exception("Cliente no encontrado");
        clienteRepo.delete(cliente);
    }

    @Override
    public List<Cliente> listarCliente() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente buscarCliente(String cedula) throws Exception {
        return clienteRepo.findById(cedula).orElse(null);
    }

    @Override
    public Cliente obtenerCliente(String cedula) throws Exception {

        Optional<Cliente> guardado = clienteRepo.findById(cedula);
        if (!guardado.isPresent()) throw new Exception("El cliente no existe.");
        return guardado.get();
    }

    @Override
    public List<Compra> listarHistorial(String cedulaCliente) throws Exception {
        List<Compra> historial = clienteRepo.obtenerListaCompraporCedula(cedulaCliente);
        if (historial.size() == 0) throw new Exception("Cliente no encontrado");
        return historial;
    }

    @Override
    public Compra hacerCompra(Compra compra) throws Exception {
        return null;
    }

    @Override
    public boolean redimirCupon(Integer codigoCuenta) throws Exception {
        return false;
    }

    @Override
    public List<Pelicula> buscarPeliculas(String nombrePelicula) throws Exception {

        List<Pelicula> peliculas = peliculaRepo.buscarPeliculasNombre(nombrePelicula);
        if (peliculas.isEmpty()) throw new Exception("No se encontró ninguna pelicula.");

        return peliculas;
    }



    private boolean verificarExistenciaCliente(String cedula) {
        Optional<Cliente> cliente = clienteRepo.findById(cedula);
        return (cliente.isPresent());
    }

    private boolean verificarExistenciaFuncion(Funcion funcion) {
        Funcion funcionExiste = funcionRepo.verificarFuncion(funcion);
        return (funcionExiste != null);
    }

    private boolean verificarMedioPago(MedioPago medioPago) {
        if (medioPago == null) return false;

        for (MedioPago medioPago1 : MedioPago.values()) {
            if (medioPago.equals(medioPago1)) return true;
        }

        return false;
    }

    private boolean verificarValidezCupon(CuponCliente cupon) {

        if (cupon == null) return true;
        Cupon cuponCliente = cuponClienteRepo.obtenerCupon(cupon.getCodigo());
        return (cuponCliente != null && cupon.getEstado().equals(true));
    }

    @Override
    public Compra obtenerCompra(Integer codigoCompra) throws Exception {
        return compraRepo.findById(codigoCompra).orElseThrow( () -> new Exception("No se encontró la compra"));
    }

}
