package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.AdministradorRepo;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.AdministradorRepo;
import co.edu.uniquindio.unicine.repo.ClienteRepo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.context.jdbc.Sql;

import java.util.List;


import javax.validation.constraints.Email;
import java.util.Arrays;
import java.util.Optional;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {

    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    public void registrar() {

        Administrador administrador = new Administrador("12345", "Fernando", "admin@admin.com", "12345", "admin");

        Administrador guardado = administradorRepo.save(administrador);
        Assertions.assertNotNull(guardado);
        System.out.println(guardado);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Administrador buscado = administradorRepo.findById("11111").orElse(null);
        System.out.println(buscado);
        administradorRepo.delete(buscado);
        Assertions.assertNotNull(administradorRepo.findById("11111").orElse(null));

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Administrador buscado = administradorRepo.findById("11111").orElse(null);
        buscado.setCorreo("correo_nuevo_admin@gmail.com");

        Administrador nuevo = administradorRepo.save(buscado);

        Assertions.assertEquals("correo_nuevo_admin@gmail.com", nuevo.getCorreo());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Administrador> buscando = administradorRepo.findById("11111");
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Administrador> lista = administradorRepo.findAll();
        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacionAdmi(){

        Administrador administrador = administradorRepo.comprobarAutenticacion("admin@gmail.com","123123");
        Assertions.assertNotNull(administrador);
    }
}
