package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.AdministradorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorImpl implements AdministradorServicio{

    public AdministradorImpl(AdministradorRepo administradorRepo) {
    }

    @Override
    public Administrador login(String correo, String password) {
        return null;
    }

    @Override
    public AdministradorTeatro registrarAdminTeatro(AdministradorTeatro administradorTeatro) {
        return null;
    }

    @Override
    public void eliminarAdminTeatro(String cedulaAdminTeatro) {

    }

    @Override
    public List<AdministradorTeatro> listarAdminTeatro() {
        return null;
    }

    @Override
    public Pelicula crearPelicula(Pelicula pelicula) {
        return null;
    }

    @Override
    public void eliminarPelicula(Integer codigoPelicula) {

    }

    @Override
    public Confiteria crearConfiteria(Confiteria confiteria) {
        return null;
    }

    @Override
    public void eliminarConfiteria(Integer codigoConfiteria) {

    }

    @Override
    public List<Confiteria> listarConfiteria() {
        return null;
    }

    @Override
    public Cupon crearCupon(Cupon cupon) {
        return null;
    }

    @Override
    public void eliminarCupon(Integer codigoCupon) {

    }

    @Override
    public List<Cupon> listarCupones() {
        return null;
    }

    @Override
    public List<Pelicula> listarPeliculas() {
        return null;
    }
}
