package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.servicios.ClienteServicioImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;

public class ClienteServicioTest {
    @Autowired
    private ClienteServicioImpl clienteServicio;
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCliente() {
        String[] tels = new String[] {"6547651231", "67876867"};
        Cliente cliente = new Cliente("434343", "Juan", "ju43@gmail.com", "12345", true, "ulrFoto", Arrays.asList(tels));

        try {
            Cliente clienteRegistrado = clienteServicio.registrarCliente(cliente);
            Assertions.assertNotNull(clienteRegistrado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void actualizarCliente() {
        Cliente cliente = null;
        try {
            cliente = clienteServicio.buscarCliente("22222");
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
        cliente.setNombre("pepito");
        try {
            Cliente almacenado = clienteServicio.actualizarCliente(cliente);
            Assertions.assertNotNull(almacenado);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }
}
