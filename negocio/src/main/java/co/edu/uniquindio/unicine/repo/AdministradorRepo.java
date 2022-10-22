package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.Administrador;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AdministradorRepo extends JpaRepository<Administrador, String> {

    @Query("select a from Administrador a where a.correo = :correo and a.password = :password ")
    Administrador comprobarAutenticacion(String correo, String password);

    Optional<Administrador> findByCorreo(String correo);

    @Query("select at from AdministradorTeatro at where at.cedula = :cedula")
    List<AdministradorTeatro> obtenerAdministradoresTeatro(String cedula);


}
