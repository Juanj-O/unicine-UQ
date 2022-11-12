package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Pelicula;

import java.util.List;

public interface ClienteServicio {

    Cliente login(String correo, String password) throws Exception;

    Cliente registrarCliente(Cliente cliente) throws Exception;

    Cliente actualizarCliente(Cliente cliente) throws Exception;

    void eliminarCliente(String cedulaCliente) throws Exception;

    List<Cliente> listarCliente();
    Cliente buscarCliente(String cedula) throws Exception;
    List<Compra> listarHistorial(String cedulaCliente) throws Exception;

    Compra hacerCompra(Compra compra) throws Exception;

    boolean redimirCupon(Integer codigoCuenta) throws Exception;

    List<Pelicula> buscarPeliculas(String nombrePelicula) throws Exception;

}
