package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.FuncionRepo;
import co.edu.uniquindio.unicine.repo.HorarioRepo;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
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
public class FuncionTest {


    @Autowired
    private FuncionRepo funcionRepo;
    @Autowired
    private SalaRepo salaRepo;
    @Autowired
    private HorarioRepo horarioRepo;
    @Autowired
    private PeliculaRepo peliculaRepo;
    @Test
    @Sql("classpath:dataset.sql")
    public void registrar() {
        Sala sala = salaRepo.findById(1).orElse(null);
        Horario horario = horarioRepo.findById(1).orElse(null);
        Pelicula pelicula = peliculaRepo.findById(1).orElse(null);

        Funcion funcion = new Funcion(20000F, sala , pelicula);

        Funcion guardado = funcionRepo.save(funcion);

        Assertions.assertNotNull(guardado);
        System.out.println(guardado);

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Funcion buscado = funcionRepo.findById(1).orElse(null);
        System.out.println(buscado);
        funcionRepo.delete(buscado);
        Assertions.assertNotNull(funcionRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Funcion buscado = funcionRepo.findById(1).orElse(null);
        buscado.setPrecio(25000F);

        Funcion nuevo = funcionRepo.save(buscado);
        System.out.println(nuevo);

        Assertions.assertEquals(25000F, nuevo.getPrecio());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Funcion> buscando = funcionRepo.findById(1);
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Funcion> lista = funcionRepo.findAll();
        lista.forEach(System.out::println);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerEntradaCompra(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarFuncionesPorPelicula(){
        List<Object[]> funciones = funcionRepo.listarFuncionesPorPelicula(4);
        funciones.forEach(o ->
                System.out.println(o[0] +", "+ o[1]+", "+ o[2]+", "+ o[3]+", "+ o[4])
                );

    }

}
