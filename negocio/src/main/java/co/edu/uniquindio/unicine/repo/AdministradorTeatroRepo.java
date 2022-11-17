package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorTeatroRepo extends JpaRepository<AdministradorTeatro, String> {

    @Query("select a from AdministradorTeatro a where a.correo = :correo and a.password = :password ")
    AdministradorTeatro comprobarAutenticacion(String correo, String password);

    AdministradorTeatro findAdministradorTeatroByCedula(String cedula);

    @Query("select at from Teatro t, in (t.administradorTeatro) at where t.codigo = :codigo")
    AdministradorTeatro obtenerPorTeatro(Integer codigo);

    @Query("select at from AdministradorTeatro at where at.correo = :correo")
    AdministradorTeatro obtenerPorCorreo(String correo);

}
