package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.AdministradorTeatroRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorTeatroImpl implements AdministradorTeatroServicio{

    public AdministradorTeatroImpl(AdministradorTeatroRepo administradorTeatroRepo){

    }

    @Override
    public AdministradorTeatro login(String correo, String password) {
        return null;
    }

    @Override
    public Teatro crearTeatro(Teatro teatro) {
        return null;
    }

    @Override
    public void eliminarTeatro(Integer codigoTeatro) {

    }

    @Override
    public List<Teatro> listarTeatro() {
        return null;
    }

    @Override
    public Funcion crearFuncion(Funcion funcion) {
        return null;
    }

    @Override
    public void eliminarFuncion(Integer codigoFuncion) {

    }

    @Override
    public List<Funcion> listarFuncion() {
        return null;
    }

    @Override
    public Sala crearSala(Sala sala) {
        return null;
    }

    @Override
    public void eliminarSala(Integer codigoSala) {

    }

    @Override
    public List<Sala> listarSalas() {
        return null;
    }

    @Override
    public Horario crearHorario(Horario horario) {
        return null;
    }
}
