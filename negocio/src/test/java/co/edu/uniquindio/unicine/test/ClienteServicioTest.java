package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.servicios.ClienteServicioImpl;
import co.edu.uniquindio.unicine.servicios.EmailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
@Transactional
public class ClienteServicioTest {
    @Autowired
    private ClienteServicioImpl clienteServicio;

    @Autowired
    private EmailService emailService;
    @Test
    @Sql("classpath:dataset.sql")
    public void registrarCliente() {
        String[] tels = new String[] {"6547651231", "67876867"};
        Cliente cliente = new Cliente("11", "Juan", "11@gmail.com", "11", true, "ulrFoto", Arrays.asList(tels));
        System.out.println(cliente);
        try {
            Cliente clienteRegistrado = clienteServicio.registrarCliente(cliente);
            System.out.println(clienteRegistrado);

            Assertions.assertNotNull(clienteRegistrado);

        } catch (Exception e) {
            System.out.println(e.toString());
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

    @Test
    public void enviarCorreoTest(){
        emailService.enviarEmail("Prueba de envio" , "Este es un mensaje" , "ahumada1248@gmail.com");
    }

    /**
     * Metodo de prueba para eliminar un cliente
     */
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminarCliente() {
        try {
            clienteServicio.eliminarCliente("22222");
            Assertions.assertTrue(true);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Cliente> lista = clienteServicio.listarCliente();
        lista.forEach(System.out::println);
        Assertions.assertTrue(true);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void consultarCliente() {
        try {
            Cliente cliente = clienteServicio.buscarCliente("22222");
            System.out.println(cliente);

            Assertions.assertNotNull(cliente);
        } catch (Exception e) {
            Assertions.assertTrue(false);
        }
    }

}
