package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

public interface AdministradorServicio {

    Administrador login(String correo, String password);

    AdministradorTeatro registrarAdminTeatro(AdministradorTeatro administradorTeatro);

    void eliminarAdminTeatro(String cedulaAdminTeatro);

    List<AdministradorTeatro> listarAdminTeatro();

    Pelicula crearPelicula(Pelicula pelicula);

    void eliminarPelicula(Integer codigoPelicula);

    List<Pelicula> listarPeliculas();

    Confiteria crearConfiteria(Confiteria confiteria);

    void eliminarConfiteria(Integer codigoConfiteria);

    List<Confiteria> listarConfiteria();

    Cupon crearCupon(Cupon cupon);

    void eliminarCupon(Integer codigoCupon);

    List<Cupon> listarCupones();

}
