package co.edu.uniquindio.unicine.repo;


import co.edu.uniquindio.unicine.entidades.Cupon;
import co.edu.uniquindio.unicine.entidades.CuponCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CuponClienteRepo extends JpaRepository<CuponCliente, Integer> {

    @Query("select c.cuponCliente from Compra c where c.codigo = :codigoCompra")
    CuponCliente obtenerClienteCupon(Integer codigoCompra);

    CuponCliente findByCodigo(Integer codigoCuponCliente);

    @Query("select c from Cupon c where c.codigo = :codigo")
    Cupon obtenerCupon(Integer codigo);
}
