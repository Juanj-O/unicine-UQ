package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Entrada;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionRepo extends JpaRepository<Funcion, Integer> {

    @Query("select f.pelicula.nombre, f.pelicula.estado, f.sala.codigo, f.sala.teatro.direccion, " +
            "f.sala.teatro.ciudad.nombre " +
            "from Funcion f where f.pelicula.codigo = :codigoPelicula")
    List<Object[]> listarFuncionesPorPelicula(Integer codigoPelicula);

    Funcion findFuncionByCodigo(Integer codigo);

    @Query("select f.pelicula.nombre from Funcion f where f.codigo=:codigoFuncion")
    String obtenerNombrePeliculaPorID(Integer codigoFuncion);

    @Query("select f.precio from Funcion f where f.codigo=:codigoFuncion")
    Integer obtenerPrecionFuncion(Integer codigoFuncion);

    @Query("select f from Funcion f where f = :funcion")
    Funcion verificarFuncion(Funcion funcion);

    @Query("select f from Funcion f where f.horario=:codigoHorario")
    List<Funcion> obtenerFuncionesPorHorario(Integer codigoHorario);

    @Query("select f from Funcion f join f.sala s where s.codigo=:codigoSala")
    List<Funcion> obtenerFuncionCodigoSala(Integer codigoSala);

    @Query("select f from Funcion f where f.pelicula.codigo = :codigoPelicula and f.sala.teatro.codigo = :codigoTeatro")
    List<Funcion> listarFuncionesPeliculaTeatro(Integer codigoPelicula, Integer codigoTeatro);

    @Query("select f.sala from Funcion f where f.codigo=:codigoFuncion")
    Sala obtenerSalaFuncion(Integer codigoFuncion);

    @Query("select f from Funcion f where f.pelicula.codigo = :codigoPelicula and f.sala.teatro.ciudad.codigo = :codigoCiudad")
    List<Funcion> obtenerFuncionesPorCiudadPelicula(Integer codigoPelicula, Integer codigoCiudad);

    @Query("select c.entradas from Compra c where c.funcion.codigo = :codigoFuncion")
    List<Entrada> obtenerEntradasFuncion(Integer codigoFuncion);

}
