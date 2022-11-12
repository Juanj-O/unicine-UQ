package co.edu.uniquindio.unicine.test;


import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CompraTest {

    @Autowired
    private CompraRepo compraRepo;
    @Autowired
    private ClienteRepo clienteRepo;
    @Autowired
    private CuponRepo cuponRepo;
    @Autowired
    private FuncionRepo funcionRepo;
    @Autowired
    private HorarioRepo horarioRepo;
    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {
        Cliente cliente = clienteRepo.findById("22222").orElse(null);
        Cupon cupon = cuponRepo.findById(1).orElse(null);
        Funcion funcion = funcionRepo.findById(1).orElse(null);
        Horario horario = horarioRepo.findById(1).orElse(null);
        Compra compra = new Compra(MedioPago.NEQUI, LocalDateTime.now(), 42000F, cupon, cliente, funcion, horario);

        Compra guardado = compraRepo.save(compra);
        Assertions.assertNotNull(guardado);
        System.out.println(guardado);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Compra buscado = compraRepo.findById(1).orElse(null);
        System.out.println(buscado);
        compraRepo.delete(buscado);
        Assertions.assertNotNull(compraRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Compra buscado = compraRepo.findById(1).orElse(null);
        buscado.setMedioPago(MedioPago.VISA);

        Compra nuevo = compraRepo.save(buscado);

        Assertions.assertEquals(MedioPago.VISA, nuevo.getMedioPago());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Compra> buscando = compraRepo.findById(1);
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Compra> lista = compraRepo.findAll();
        lista.forEach(System.out::println);
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
