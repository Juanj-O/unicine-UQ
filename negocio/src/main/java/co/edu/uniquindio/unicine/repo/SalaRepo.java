package co.edu.uniquindio.unicine.repo;


import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Sala;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalaRepo extends JpaRepository<Sala, Integer> {

    @Query("select s from Sala s where s.codigo=:codigoSala")
    Sala obtenerSalaPorCodigo(Integer codigoSala);

    @Query("select s.funciones from Sala s where s.codigo=:codigoSala")
    List<Funcion> obtenerFuncionesSala(Integer codigoSala);

    @Query("select s from Sala s where s.distribucionSillas=:distribucion")
    List<Sala> obtenerSalasPorDistribucion(Integer distribucion);
    Sala findByCodigo(Integer integer);
}
