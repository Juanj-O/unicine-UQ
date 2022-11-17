package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EntradaRepo extends JpaRepository<Entrada, Integer> {

    @Query("select e from Entrada e where e.codigo = :codigoEntrada")
    Entrada obtenerEntrada(Integer codigoEntrada);

}
