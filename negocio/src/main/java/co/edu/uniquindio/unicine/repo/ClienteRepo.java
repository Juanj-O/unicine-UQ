package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Compra;
import co.edu.uniquindio.unicine.entidades.Cupon;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.swing.*;

@Repository
public interface ClienteRepo extends JpaRepository<Cliente, String> {

    @Query("select c from Cliente c where c.correo = :correo")
    Cliente obtenerClientePorCorreo (String correo);

    @Query("select c from Cliente c where c.estado = :estado")
    List<Cliente> obtenerClientePorEstado(boolean estado, Pageable paginador);

    Cliente findClienteByCedula(String cedula);

    @Query("select comp from Cliente c, in (c.compras) comp where c.cedula = :cedula")
    List<Compra> obtenerListaCompraporCedula(String cedula);

    @Query("select cup from Cliente c join c.cuponClientes cup where c.correo = :correo")
    List<Cupon> obtenerCupones(String correo);

    @Query("select c.cedula from Cliente c left join c.compras comp")
    List<Object[]> obtenerComprasUsuarios();

    Cliente findByCorreo(String correo);

    Cliente findByCorreoAndPassword(String correo, String password);

    @Query("select cup.cupon from Cliente cli left join cli.cuponClientes cup where cup.cliente.cedula = :cedula")
    List<Cupon> obtenerCuponesCliente(String cedula);

    @Query("select c.nombre, vent from Cliente c left join c.ventas vent")
    List<Object[]> obtenerComprasTodos();
}
