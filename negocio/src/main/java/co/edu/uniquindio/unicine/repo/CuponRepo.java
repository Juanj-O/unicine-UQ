package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.CuponCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface CuponRepo extends JpaRepository<Cupon, Integer> {

    Cupon findByCodigo(Integer codigoCupon);

    @Query("select c from Cupon c where c.descuento = :descuento")
    List<Cupon> listarCuponesPorDescuento(Float descuento);

    @Query("select cup from CuponCliente cup where cup.codigo = :codigoClienteCupon")
    CuponCliente obtenerClienteCupon(Integer codigoClienteCupon);
}
