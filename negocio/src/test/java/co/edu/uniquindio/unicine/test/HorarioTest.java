package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Horario;
import co.edu.uniquindio.unicine.repo.HorarioRepo;
import co.edu.uniquindio.unicine.repo.SalaRepo;
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
public class HorarioTest {
    @Autowired
    private HorarioRepo horarioRepo;

    @Test
    public void registrar() {

        Horario horario = new Horario("22-12-2022", "19:30");
        Horario guardado = horarioRepo.save(horario);

        Assertions.assertNotNull(guardado);
        System.out.println(guardado);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Horario buscado = horarioRepo.findById(1).orElse(null);
        System.out.println(buscado);
        horarioRepo.delete(buscado);
        Assertions.assertNotNull(horarioRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Horario buscado = horarioRepo.findById(1).orElse(null);
        buscado.setHora("20:45");

        Horario nuevo = horarioRepo.save(buscado);

        Assertions.assertEquals("20:45", nuevo.getHora());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Horario> buscando = horarioRepo.findById(1);
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Horario> lista = horarioRepo.findAll();
        lista.forEach(System.out::println);
    }
}
