package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    @Test
    public void registrar() {

        String[] tels = new String[] {"6547651231", "67876867"};
        Cliente cliente = new Cliente("111111", "Juan", "juan@gmail.com", "12345", true, "ulrFoto", Arrays.asList(tels));

        Cliente guardado = clienteRepo.save(cliente);
        Assertions.assertNotNull(guardado);
        System.out.println(guardado);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Cliente buscado = clienteRepo.findById("111111").orElse(null);
        System.out.println(buscado);
        clienteRepo.delete(buscado);
        Assertions.assertNotNull(clienteRepo.findById("11111").orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Cliente buscado = clienteRepo.findById("22222").orElse(null);
        buscado.setCorreo("juanito@email.com");

        Cliente nuevo = clienteRepo.save(buscado);

        Assertions.assertEquals("juanito@email.com", nuevo.getCorreo());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Cliente> buscando = clienteRepo.findById("22222");
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Cliente> lista = clienteRepo.findAll();
        lista.forEach(System.out::println);
    }
}
