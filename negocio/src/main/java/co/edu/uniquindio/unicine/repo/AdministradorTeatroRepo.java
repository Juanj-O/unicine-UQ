package co.edu.uniquindio.unicine.repo;

import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministradorTeatroRepo extends JpaRepository<AdministradorTeatro, Integer> {

    @Query("select a from Administrador a where a.correo = :correo and a.password = :password ")
    AdministradorTeatro comprobarAutenticacion(String correo, String password);

    AdministradorTeatro findAdministradorTeatroByCedula(String cedula);

}
