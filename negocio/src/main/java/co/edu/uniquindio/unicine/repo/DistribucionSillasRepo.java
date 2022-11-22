package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.DistribucionSillas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DistribucionSillasRepo extends JpaRepository<DistribucionSillas, Integer>{

    DistribucionSillas findByCodigo(Integer codigoDistribucionSillas);
}
