package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public interface PeliculaRepo extends JpaRepository<Pelicula, Integer> {

    @Query("select f.pelicula from Funcion  f where f.codigo = :codigo ")
    Pelicula obtenerPeliculaPorFuncion(Integer codigo);

    @Query("select p from Pelicula p where p.estado = :estado")
    List<Pelicula> obtenerEstado(Boolean estado);

    @Query("select p from Pelicula p where p.nombre like concat('%', :nombre, '%')and p.estado = :estadoPelicula")
    List<Pelicula> buscarPeliculas(String nombre, boolean estadoPelicula);

    @Query("select p from Pelicula p where p.nombre like concat('%', :nombre, '%')")
    List<Pelicula> buscarPeliculasNombre(String nombre);

    Pelicula findPeliculaByCodigo(Integer codigoPelicula);
    @Query("select p from Teatro t join Sala s on t.codigo = s.teatro.codigo inner join Funcion f on f.sala.codigo = s.codigo inner join " +
            "Pelicula p on p.codigo = f.pelicula.codigo where t.codigo = 1")
    List<Pelicula> buscarPeliculasTeatro();


    @Query("select p from Ciudad c join Teatro t on c.codigo = t.ciudad.codigo inner join Sala s on t.codigo = s.teatro.codigo inner join " +
            "Funcion f on f.sala.codigo = s.codigo inner join Pelicula p on p.codigo = f.pelicula.codigo where c.codigo = :codigoCiudad")
    List<Pelicula> buscarPeliculasCiudad(Integer codigoCiudad);

}
