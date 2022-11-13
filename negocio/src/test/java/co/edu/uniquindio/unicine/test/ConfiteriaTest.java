package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Confiteria;
import co.edu.uniquindio.unicine.entidades.MedioPago;
import co.edu.uniquindio.unicine.repo.ConfiteriaRepo;
import co.edu.uniquindio.unicine.repo.FuncionRepo;
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
public class ConfiteriaTest {


    @Autowired
    private ConfiteriaRepo confiteriaRepo;

    @Test
    public void registrar() {
        Confiteria confiteria = new Confiteria("Crispetas", "UrlImagen", 24000F);
        Confiteria guardado = confiteriaRepo.save(confiteria);
        Assertions.assertNotNull(guardado);
        System.out.println(guardado);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Confiteria buscado = confiteriaRepo.findById(1).orElse(null);
        System.out.println(buscado);
        confiteriaRepo.delete(buscado);
        Assertions.assertNotNull(confiteriaRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Confiteria buscado = confiteriaRepo.findById(1).orElse(null);
        buscado.setNombre("Crispetas caramelo");

        Confiteria nuevo = confiteriaRepo.save(buscado);
        System.out.println(nuevo);

        Assertions.assertEquals("Crispetas caramelo",  nuevo.getNombre());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Confiteria> buscando = confiteriaRepo.findById(1);
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Confiteria> lista = confiteriaRepo.findAll();
        lista.forEach(System.out::println);
    }
}
