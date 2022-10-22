package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdministradorImpl implements AdministradorServicio{

    private AdministradorRepo administradorRepo;
    private AdministradorTeatroRepo administradorTeatroRepo;
    private PeliculaRepo peliculaRepo;
    private ConfiteriaRepo confiteriaRepo;
    private CuponRepo cuponRepo;
    private CiudadRepo ciudadRepo;

    public AdministradorImpl(AdministradorRepo administradorRepo) {
    }

    @Override
    public Administrador login(String correo, String password) throws Exception {
        Administrador administrador = administradorRepo.comprobarAutenticacion(correo, password);
        if(administrador == null) throw new Exception("Usuario o contraseña incorrectos");
        return administrador;
    }

    @Override
    public AdministradorTeatro registrarAdminTeatro(AdministradorTeatro administradorTeatro) throws Exception {
        boolean correoExiste = esCorreoRepetido(administradorTeatro.getCorreo());
        if (correoExiste) throw new Exception("Este correo ya está en uso");
        return administradorTeatroRepo.save(administradorTeatro);
    }

    private boolean esCorreoRepetido(String correo) {
        return administradorRepo.findByCorreo(correo).orElse(null) == null;
    }

    @Override
    public void eliminarAdminTeatro(String cedulaAdminTeatro) throws Exception {
        AdministradorTeatro administradorTeatro = administradorTeatroRepo.findAdministradorTeatroByCedula(cedulaAdminTeatro);
        if (administradorTeatro == null) throw new Exception("Administrador de teatro no encontrado");
        administradorTeatroRepo.delete(administradorTeatro);
    }

    @Override
    public List<AdministradorTeatro> listarAdminTeatro(String cedulaAdminTeatro) throws Exception {
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

    private boolean esPeliculaRepetida(String nombre){
        return peliculaRepo.buscarPeliculasNombre(nombre) == null;
    }

    @Override
    public void eliminarPelicula(Integer codigoPelicula) throws Exception {
        Pelicula pelicula = peliculaRepo.findPeliculaByCodigo(codigoPelicula);
        if (pelicula == null) throw new Exception("Esta pelicula no existe");
        peliculaRepo.delete(pelicula);
    }

    @Override
    public Confiteria crearConfiteria(Confiteria confiteria) {
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
    public Cupon crearCupon(Cupon cupon) {
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
    public Ciudad crearCiudad(Ciudad ciudad) throws Exception {
        if (ciudadRepo.findCiudadByNombre(ciudad.getNombre()) != null) {
            throw new Exception("La ciudad ya existe");
        }
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
    public List<Pelicula> listarPeliculas() {
        return peliculaRepo.findAll();
    }
}
