package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Confiteria;
import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.repo.CompraRepo;
import co.edu.uniquindio.unicine.repo.EntradaRepo;
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
public class EntradaTest {


    @Autowired
    private EntradaRepo entradaRepo;
    @Autowired
    private CompraRepo compraRepo;

    @Test
    public void registrar() {
        Compra compra = compraRepo.findById(1).orElse(null);

        Entrada entrada = new Entrada(2, 2, compra);

        Entrada guardado = entradaRepo.save(entrada);
        Assertions.assertNotNull(guardado);
        System.out.println(guardado);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Entrada buscado = entradaRepo.findById(1).orElse(null);
        System.out.println(buscado);
        entradaRepo.delete(buscado);
        Assertions.assertNotNull(entradaRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Entrada buscado = entradaRepo.findById(1).orElse(null);
        buscado.setFila(4);

        Entrada nuevo = entradaRepo.save(buscado);

        Assertions.assertEquals(4,  nuevo.getFila());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Entrada> buscando = entradaRepo.findById(1);
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Entrada> lista = entradaRepo.findAll();
        lista.forEach(System.out::println);
    }
}
