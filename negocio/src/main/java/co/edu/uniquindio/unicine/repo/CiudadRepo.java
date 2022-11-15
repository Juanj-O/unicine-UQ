package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Ciudad;
import co.edu.uniquindio.unicine.entidades.Teatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CiudadRepo extends JpaRepository<Ciudad, Integer> {

    Ciudad findCiudadByCodigo(Integer codigo);
    Ciudad findCiudadByNombre(String nombre);

    @Query("select c.teatros from Ciudad c where c.nombre = :nombreCiudad")
    List<Teatro> teatrosPorNombreCiudad(String nombreCiudad);

    @Query("select c.nombre, count(t) from Ciudad c left join c.teatros t group by c")
    List<Object[]> contarNumeroTeatrosPorCiudad();

}


