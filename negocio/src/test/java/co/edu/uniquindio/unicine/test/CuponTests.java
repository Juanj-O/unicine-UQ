package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Confiteria;
import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.repo.ConfiteriaRepo;
import co.edu.uniquindio.unicine.repo.CuponRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CuponTests {


    @Autowired
    private CuponRepo cuponRepo;

    @Test
    public void registrar() {
        Cupon cupon = new Cupon(15F, LocalDateTime.now(), true, "Descuento en boleteria");
        Cupon guardado = cuponRepo.save(cupon);
        Assertions.assertNotNull(guardado);
        System.out.println(guardado);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Cupon cupon = cuponRepo.findById(1).orElse(null);
        System.out.println(cupon);
        cuponRepo.delete(cupon);
        Assertions.assertNotNull(cuponRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Cupon buscado = cuponRepo.findById(1).orElse(null);
        buscado.setDescuento(30F);

        Cupon nuevo = cuponRepo.save(buscado);

        Assertions.assertEquals(30F,  nuevo.getDescuento());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Cupon> buscando = cuponRepo.findById(1);
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Cupon> lista = cuponRepo.findAll();
        lista.forEach(System.out::println);
    }
}
