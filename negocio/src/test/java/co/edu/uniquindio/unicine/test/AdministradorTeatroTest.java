package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.AdministradorRepo;
import co.edu.uniquindio.unicine.repo.AdministradorTeatroRepo;
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
public class AdministradorTeatroTest {

    @Autowired
    private AdministradorTeatroRepo administradorTeatroRepo;

    @Test
    public void registrar() {
        AdministradorTeatro administrador = new AdministradorTeatro("12345", "Fernando", "admin@admin.com", "12345");

        AdministradorTeatro guardado = administradorTeatroRepo.save(administrador);
        Assertions.assertNotNull(guardado);
        System.out.println(guardado);

    }


    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        AdministradorTeatro buscado = administradorTeatroRepo.findById("11111").orElse(null);;
        System.out.println(buscado);
        administradorTeatroRepo.delete(buscado);
        Assertions.assertNotNull(administradorTeatroRepo.findById("11111").orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        AdministradorTeatro buscado = administradorTeatroRepo.findById("1").orElse(null);
        buscado.setCorreo("correo_nuevo_admin@gmail.com");

        AdministradorTeatro nuevo = administradorTeatroRepo.save(buscado);

        Assertions.assertEquals("correo_nuevo_admin@gmail.com", nuevo.getCorreo());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<AdministradorTeatro> buscando = administradorTeatroRepo.findById("1");
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<AdministradorTeatro> lista = administradorTeatroRepo.findAll();
        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacionAdmi(){
        AdministradorTeatro administradorTeatro = administradorTeatroRepo.comprobarAutenticacion("admin2@gmail.com","123123");
        Assertions.assertNotNull(administradorTeatro);
    }
}
