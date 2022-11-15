package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServicioImpl implements ClienteServicio {

    @Autowired
    private ClienteRepo clienteRepo;

    public ClienteServicioImpl(ClienteRepo clienteRepo) {
    }

    @Override
    public Cliente login(String correo, String password) throws Exception {
        Cliente cliente = clienteRepo.findByCorreoAndPassword(correo, password);
        if(cliente == null) throw new Exception("Los datos de autenticación son incorrectos");
        return cliente;
    }

    @Override
    public Cliente registrarCliente(Cliente cliente) throws Exception{
        if (esCorreoRepetido(cliente.getCorreo())){
            throw new Exception("Este correo ya está en uso");
        }
        return clienteRepo.save(cliente);
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
        return null;
    }
}
