package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PeliculaTest {

    @Autowired
    private PeliculaRepo peliculaRepo;

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
    public void obtenerPeliculaFuncion(){

        Pelicula pelicula = peliculaRepo.obtenerPeliculaPorFuncion(1);
        System.out.println(pelicula);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPeliculaEstado(){
        List<Pelicula> peliculas = peliculaRepo.obtenerEstado(false);
        peliculas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPeliculas(){
        List<Pelicula> peliculas = peliculaRepo.buscarPeliculas("Hallowen" , true);
        peliculas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPeliculasNombre(){
        List<Pelicula> peliculas = peliculaRepo.buscarPeliculasNombre("Hallowen" );
        peliculas.forEach(System.out::println);
    }
}
