package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

public interface AdministradorServicio {

    Administrador login(String correo, String password) throws Exception;

    AdministradorTeatro registrarAdminTeatro(AdministradorTeatro administradorTeatro) throws Exception;

    void eliminarAdminTeatro(String cedulaAdminTeatro) throws Exception;

    List<AdministradorTeatro> listarAdminTeatro(String cedulaAdminTeatro) throws Exception;

    Pelicula crearPelicula(Pelicula pelicula) throws Exception;

    Pelicula actualizarPelicula(Pelicula pelicula) throws Exception;

    void eliminarPelicula(Integer codigoPelicula) throws Exception;

    Pelicula consultarPelicula(Integer codigoPelicula) throws Exception;

    List<Pelicula> listarPeliculas();Pelicula registrarPelicula(Pelicula pelicula) throws Exception;

    Confiteria crearConfiteria(Confiteria confiteria) throws Exception;

    Confiteria actualizarConfiteria(Confiteria confiteria) throws Exception;

    void eliminarConfiteria(Integer codigoConfiteria) throws Exception;

    List<Confiteria> listarConfiteria();

    Confiteria consultarConfiteria(Integer codigoConfiteria) throws Exception;

    Cupon crearCupon(Cupon cupon) throws Exception;

    Cupon actualizarCupon(Cupon cupon) throws Exception;

    void eliminarCupon(Integer codigoCupon) throws Exception;

    List<Cupon> listarCupones();

    Cupon consultarCupon(Integer codigoCupon) throws Exception;

    Ciudad crearCiudad(Ciudad ciudad) throws Exception;

    Ciudad actualizarCiudad(Ciudad ciudad) throws Exception;

    void eliminarCiudad(Integer codigoCiudad) throws Exception;

    List<Ciudad> listarCiudades();

    Ciudad consultarCiudad(Integer codigoCiudad) throws Exception;

}
