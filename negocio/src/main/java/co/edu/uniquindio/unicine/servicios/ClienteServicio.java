package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;

import java.util.List;

public interface ClienteServicio {

    Cliente login(String correo, String password);

    Cliente registrarCliente(Cliente cliente);

    Cliente actualizarCliente(Cliente cliente);

    void eliminarCliente(Integer codigoCliente);

    List<Cliente> listarCliente();

    List<Compra> listarHistorial(Integer codigoUsuario);

    Compra hacerCompra(Compra compra);

    boolean redimirCupon(Integer codigoCuenta);
}
