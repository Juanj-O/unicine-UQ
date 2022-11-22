package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.ConfiteriaCompra;
import co.edu.uniquindio.unicine.entidades.Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraRepo extends JpaRepository<Compra, Integer> {

    @Query("select e from Compra c join c.entradas e where c.codigo = :codigoCompra")
    List<Entrada> obtenerEntradaPorCompra(Integer codigoCompra);

    @Query("select sum(c.valorTotal) from Compra c where c.cliente.cedula = :cedulaCliente")
    Float calcularTotalGastado(String cedulaCliente);

    @Query("select c from Compra c where c.cliente.correo = :correo")
    List<Compra> ventasPorEmailUsuario(String correo);

    @Query("select ds.esquema from Compra c left join c.funcion.sala.distribucionSillas ds where c.codigo = :codigoCompra")
    String obtenerDistribucionSillas(Integer codigoCompra);

    @Query("select e from Compra c join c.entradas e where c.codigo = :idCompra")
    List<Entrada> entradasPorCompra(Integer idCompra);

    @Query("select c from Compra c where c.cliente.cedula = :cedula")
    List<Compra> comprasCliente(String cedula);

    @Query("select c from ConfiteriaCompra c where c.codigo = :codigoCompraConfiteria")
    ConfiteriaCompra obtenerCompraConfiteria (Integer codigoCompraConfiteria);
}
