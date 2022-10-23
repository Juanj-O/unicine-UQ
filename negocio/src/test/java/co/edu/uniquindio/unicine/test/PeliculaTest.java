package co.edu.uniquindio.unicine.test;


import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.Genero;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.repo.PeliculaRepo;
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
public class PeliculaTest {

    @Autowired
    private PeliculaRepo peliculaRepo;

    @Test
    public void registrar() {

        Pelicula pelicula = new Pelicula("Rayo Macqueen", "imagenUrl", "Macqueen.mp4",
                "carros", "carros", true);

        Pelicula guardado = peliculaRepo.save(pelicula);
        Assertions.assertNotNull(guardado);
        System.out.println(guardado);
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){
        Pelicula buscado = peliculaRepo.findById(1).orElse(null);
        System.out.println(buscado);
        peliculaRepo.delete(buscado);
        Assertions.assertNotNull(peliculaRepo.findById(1).orElse(null));
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){
        Pelicula buscado = peliculaRepo.findById(1).orElse(null);
        buscado.setNombre("Avatar");

        Pelicula nuevo = peliculaRepo.save(buscado);

        Assertions.assertEquals("Avatar", nuevo.getNombre());
    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){
        Optional<Pelicula> buscando = peliculaRepo.findById(1);
        Assertions.assertNotNull(buscando.orElse(null));
        System.out.println(buscando.orElse(null));
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPeliculaFuncion(){

        Pelicula pelicula = peliculaRepo.obtenerPeliculaPorFuncion(1);
        System.out.println(pelicula);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listar(){
        List<Pelicula> lista = peliculaRepo.findAll();
        lista.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerPeliculaEstado(){
        List<Pelicula> peliculas = peliculaRepo.obtenerEstado(true);
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

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPeliculaTeatro(){
        List<Pelicula> peliculas = peliculaRepo.buscarPeliculasTeatro( );
        peliculas.forEach(System.out::println);
    }

    @Test
    @Sql("classpath:dataset.sql")
    public void buscarPeliculaCiudad(){
        List<Pelicula> peliculas = peliculaRepo.buscarPeliculasCiudad(1);
        peliculas.forEach(System.out::println);
    }

}
