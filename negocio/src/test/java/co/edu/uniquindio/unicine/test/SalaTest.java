package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.DistribucionSillas;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Sala;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.repo.FuncionRepo;
import co.edu.uniquindio.unicine.repo.SalaRepo;
import co.edu.uniquindio.unicine.repo.TeatroRepo;
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
public class SalaTest {


    @Autowired
    private SalaRepo salaRepo;
    @Autowired
    private TeatroRepo teatroRepo;

    @Autowired
    private FuncionRepo funcionRepo;
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Sala buscado = salaRepo.findById(1).orElse(null);
        System.out.println(buscado);
        salaRepo.delete(buscado);
        Assertions.assertNotNull(salaRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Sala buscado = salaRepo.findById(1).orElse(null);
        buscado.setNombre("Sala 25");

        Sala nuevo = salaRepo.save(buscado);

        Assertions.assertEquals("Sala 25", nuevo.getNombre());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Sala> buscando = salaRepo.findById(1);
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Sala> lista = salaRepo.findAll();
        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {

        Teatro teatro = teatroRepo.findById(1).orElse(null);

        DistribucionSillas distribucionSillas = new DistribucionSillas(30, "Esquema", 100, 10, 10 );
        System.out.println(distribucionSillas);

        Sala sala = new Sala("Sala 50", distribucionSillas, teatro);

        Sala guardado = salaRepo.save(sala);

        Assertions.assertNotNull(guardado);
        System.out.println(guardado);

    }

}
