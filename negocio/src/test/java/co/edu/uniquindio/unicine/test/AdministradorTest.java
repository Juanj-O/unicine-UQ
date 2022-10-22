package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.AdministradorRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTest {

    @Autowired
    private AdministradorRepo administradorRepo;

    @Test
    public void registrar() {


    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void comprobarAutenticacionAdmi(){

        Administrador administrador = administradorRepo.comprobarAutenticacion("admin@gmail.com","123123");
        Assertions.assertNotNull(administrador);
    }


}
