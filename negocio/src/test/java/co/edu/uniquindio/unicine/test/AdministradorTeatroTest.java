package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.repo.AdministradorRepo;
import co.edu.uniquindio.unicine.repo.AdministradorTeatroRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AdministradorTeatroTest {

    @Autowired
    private AdministradorTeatroRepo administradorTeatroRepo;

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

        AdministradorTeatro administradorTeatro = administradorTeatroRepo.comprobarAutenticacion("admin2@gmail.com","123123");
        Assertions.assertNotNull(administradorTeatro);
    }
}
