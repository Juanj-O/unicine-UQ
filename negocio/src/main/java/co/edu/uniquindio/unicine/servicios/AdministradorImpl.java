package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorImpl implements AdministradorServicio{

    @Autowired
    private AdministradorRepo administradorRepo;
    @Autowired
    private AdministradorTeatroRepo administradorTeatroRepo;
    @Autowired
    private PeliculaRepo peliculaRepo;
    @Autowired
    private ConfiteriaRepo confiteriaRepo;
    @Autowired
    private CuponRepo cuponRepo;
    @Autowired
    private CiudadRepo ciudadRepo;

    @Override
    public Administrador login(String correo, String password) throws Exception {
        Administrador administrador = administradorRepo.comprobarAutenticacion(correo, password);
        if(administrador == null) throw new Exception("Usuario o contraseña incorrectos");
        return administrador;
    }

    @Override
    public AdministradorTeatro registrarAdminTeatro(AdministradorTeatro administradorTeatro) throws Exception {
        boolean existe = esCorreoRepetido(administradorTeatro.getCorreo());
        if (existe){
            throw new Exception("Este correo ya está en uso");
        }
        return administradorTeatroRepo.save(administradorTeatro);
    }

    private boolean esCorreoRepetido(String correo) {
        return administradorTeatroRepo.obtenerPorCorreo(correo) != null;
    }

    @Override
    public void eliminarAdminTeatro(String cedulaAdminTeatro) throws Exception {
        AdministradorTeatro administradorTeatro = administradorTeatroRepo.findAdministradorTeatroByCedula(cedulaAdminTeatro);
        if (administradorTeatro == null) throw new Exception("Administrador de teatro no encontrado");
        administradorTeatroRepo.delete(administradorTeatro);
    }

    @Override
    public List<AdministradorTeatro> listarAdminTeatro() throws Exception {
        List<AdministradorTeatro> listaAdminTeatros = administradorTeatroRepo.findAll();
        if (listaAdminTeatros.size() == 0) throw new Exception("Lista no encontrada");
        return listaAdminTeatros;
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) throws Exception {
        boolean peliculaExiste = esPeliculaRepetida(pelicula.getNombre());
        if (peliculaExiste) throw new Exception("Esta pelicula ya existe");
        return peliculaRepo.save(pelicula);
    }

    @Override
    public Pelicula actualizarPelicula(Pelicula pelicula) throws Exception {
        verificarPeliculaCodgio(pelicula.getCodigo());
        return peliculaRepo.save(pelicula);
    }

    private boolean esPeliculaRepetida(String nombre){
        return peliculaRepo.buscarPeliculasNombre(nombre).size() > 0;
    }

    @Override
    public void eliminarPelicula(Integer codigoPelicula) throws Exception {
        Pelicula pelicula = peliculaRepo.findPeliculaByCodigo(codigoPelicula);
        if (pelicula == null) throw new Exception("Esta pelicula no existe");
        peliculaRepo.delete(pelicula);
    }

    @Override
    public Pelicula consultarPelicula(Integer codigoPelicula) throws Exception {
        verificarPeliculaCodgio(codigoPelicula);
        return peliculaRepo.findById(codigoPelicula).orElse(null);
    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return peliculaRepo.findAll();
    }

    @Override
    public Confiteria crearConfiteria(Confiteria confiteria) throws Exception {
        Confiteria confiteriaAux = confiteriaRepo.findConfiteriaByNombre(confiteria.getNombre());
        if(confiteriaAux != null)
        {
            throw new Exception("La pelicula ya está registrada");
        }
        return confiteriaRepo.save(confiteria);
    }

    @Override
    public Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception {
        verificarConfiteria(confiteria.getCodigo());
        return confiteriaRepo.save(confiteria);
    }

    @Override
    public void eliminarConfiteria(Integer codigoConfiteria) throws Exception{
        Confiteria confiteria = confiteriaRepo.findConfiteriaByCodigo(codigoConfiteria);
        if (confiteria == null) throw new Exception("Esta confiteria no existe");
        confiteriaRepo.delete(confiteria);
    }

    @Override
    public List<Confiteria> listarConfiteria() {
        return confiteriaRepo.findAll();
    }

    @Override
    public Confiteria consultarConfiteria(Integer codigoConfiteria) throws Exception {
        verificarConfiteria(codigoConfiteria);
        return confiteriaRepo.findById(codigoConfiteria).orElse(null);
    }

    @Override
    public Confiteria consultarConfiteria(String nombre) throws Exception {
        return null;
    }

    @Override
    public Cupon crearCupon(Cupon cupon) throws Exception{
        Cupon cuponAux = cuponRepo.findByDescripcion(cupon.getDescripcion());
        if(cuponAux != null)
        {
            throw new Exception("El cupon ya está registrado en el sistema");
        }
        return cuponRepo.save(cupon);
    }

    @Override
    public Cupon actualizarCupon(Cupon cupon) throws Exception {
        verificarCupon(cupon.getCodigo());
        return cuponRepo.save(cupon);
    }


    @Override
    public void eliminarCupon(Integer codigoCupon) throws Exception {
        Cupon cupon = cuponRepo.findByCodigo(codigoCupon);
        if (cupon == null) throw new Exception("El cupon no existe");
        cuponRepo.delete(cupon);
    }

    @Override
    public List<Cupon> listarCupones() {
        return cuponRepo.findAll();
    }

    @Override
    public Cupon consultarCupon(Integer codigoCupon) throws Exception {
        verificarCupon(codigoCupon);
        return cuponRepo.findById(codigoCupon).orElse(null);
    }

    @Override
    public Ciudad crearCiudad(Ciudad ciudad) throws Exception {
        Ciudad ciudadAux = ciudadRepo.findCiudadByNombre(ciudad.getNombre());

        if(ciudadAux != null) throw new Exception("La ciudad ya está registrado en el sistema");

        return ciudadRepo.save(ciudad);
    }

    @Override
    public Ciudad actualizarCiudad(Ciudad ciudad) throws Exception {
        verificarCiudad(ciudad.getCodigo());
        return ciudadRepo.save(ciudad);
    }

    @Override
    public void eliminarCiudad(Integer codigoCiudad) throws Exception {
        Ciudad ciudad = ciudadRepo.findCiudadByCodigo(codigoCiudad);
        if (ciudad == null) throw new Exception("La ciudad no existe");
        ciudadRepo.delete(ciudad);
    }

    @Override
    public List<Ciudad> listarCiudades() {
        return ciudadRepo.findAll();
    }

    @Override
    public Ciudad consultarCiudad(Integer codigoCiudad) throws Exception {
        verificarCiudad(codigoCiudad);
        return ciudadRepo.findById(codigoCiudad).orElse(null);
    }

    @Override
    public Pelicula registrarPelicula(Pelicula pelicula) throws Exception {
        Pelicula peliculaAux= consultarPelicula(pelicula.getCodigo());

        if(peliculaAux != null) throw new Exception("La pelicula ya está registrada en el sistema");

        return peliculaRepo.save(pelicula);
    }

    private void verificarPeliculaCodgio(Integer codigoPelicula) throws Exception {
        Pelicula pelicula = peliculaRepo.findById(codigoPelicula).orElse(null);
        if (pelicula == null){
            throw new Exception("La pelicula no existe");
        }
    }


    private void verificarConfiteria(Integer codigoConfiteria) throws Exception {
        Confiteria confiteria = confiteriaRepo.findById(codigoConfiteria).orElse(null);
        if (confiteria == null){
            throw new Exception("La confiteria no existe");
        }
    }

    private void verificarCupon(Integer codigoCupon) throws Exception {

        Cupon cupon = cuponRepo.findById(codigoCupon).orElse(null);
        if (cupon == null){
            throw new Exception("El cupón no existe");
        }
    }

    private void verificarCiudad(Integer codigoCiudad) throws Exception {

        Ciudad ciudadAux = ciudadRepo.findById(codigoCiudad).orElse(null);
        if (ciudadAux == null){
            throw new Exception("La ciudad no existe");
        }
    }
}
