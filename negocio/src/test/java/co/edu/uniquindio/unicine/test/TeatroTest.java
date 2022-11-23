package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TeatroTest {



    @Autowired
    private TeatroRepo teatroRepo;
    @Autowired
    private AdministradorTeatroRepo administradorRepo;
    @Autowired
    private CiudadRepo ciudadRepo;

    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {
        AdministradorTeatro administradorTeatro = administradorRepo.findById("1").orElse(null);
        Ciudad ciudad = ciudadRepo.findById(1).orElse(null);

        Teatro teatro =new Teatro("Unicentro", "Centro", "34335", administradorTeatro, ciudad);
        Teatro guardado = teatroRepo.save(teatro);

        Assertions.assertNotNull(guardado);
        System.out.println(guardado);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Teatro buscado = teatroRepo.findById(1).orElse(null);
        System.out.println(buscado);
        teatroRepo.delete(buscado);
        Assertions.assertNotNull(teatroRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Teatro buscado = teatroRepo.findById(1).orElse(null);
        buscado.setNombre("Portal del QUindio");

        Teatro nuevo = teatroRepo.save(buscado);

        Assertions.assertEquals("Portal del QUindio", nuevo.getNombre());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Teatro> buscando = teatroRepo.findById(1);
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Teatro> lista = teatroRepo.findAll();
        lista.forEach(System.out::println);
    }
}
