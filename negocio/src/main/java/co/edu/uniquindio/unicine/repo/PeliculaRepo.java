package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {

@Query("select distinct f.pelicula from Funcion  f")
    List<Pelicula> obtenerPeliculasPorFuncion();

    @Query("select p from Pelicula p where p.estado = :estado")
    Pelicula obtenerEstado(String estado);

    @Query("select p from Pelicula p where p.nombre like concat('%', :nombre, '%')and p.estado = :estadoPelicula")
    List<Pelicula> buscarPeliculas(String nombre, String estadoPelicula);

}
