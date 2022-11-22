package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.dtos.CompraDTO;
import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

public interface ClienteServicio {

    Cliente login(String correo, String password) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente(String cedulaCliente) throws Exception;

    List<Cliente> listarCliente();

    Cliente buscarCliente(String cedula) throws Exception;

    List<Ciudad> listarCiudades();

    List<Teatro> listarTeatrosCiudad(Integer codigoCiudad) throws Exception;

    List<Pelicula> listarPeliculasCartelera(Integer codigoTeatro) throws Exception;

    List<Funcion> listarFuncionesPelicula(Integer codigoPelicula, Integer codigoTeatro) throws Exception;

    Compra hacerCompra(CompraDTO compra) throws Exception;

    List<Compra> listarCompras(String codigoCliente);


    Compra obtenerCompra(Integer codigoCompra) throws Exception;

    Compra aplicarDescuentoCupon(Compra compra, CuponCliente cupon) throws Exception;

    List<Compra> listarHistorial(String cedulaCliente) throws Exception;

    List<Pelicula> buscarPeliculas(String nombrePelicula) throws Exception;

    Cliente obtenerCliente(String cedula) throws Exception;


}
