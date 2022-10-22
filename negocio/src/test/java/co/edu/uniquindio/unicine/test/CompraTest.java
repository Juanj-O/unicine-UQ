package co.edu.uniquindio.unicine.test;


import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.repo.CompraRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired
    private CompraRepo compraRepo;

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
    public void obtenerEntradaCompra(){
        List<Entrada> entradas = compraRepo.obtenerEntradaPorCompra(2);
        entradas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void calcularTotalGastado() {
       Float sumatoria =compraRepo.calcularTotalGastado("44444");
       System.out.println(sumatoria);
    }

}
