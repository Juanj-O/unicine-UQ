package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

public interface AdministradorTeatroServicio {

    AdministradorTeatro login(String correo, String password)throws Exception;

    Teatro crearTeatro(Teatro teatro) throws Exception;

    void eliminarTeatro(Integer codigoTeatro) throws Exception;

    List<Teatro> listarTeatro();

    Funcion crearFuncion(Funcion funcion) throws Exception;

    void eliminarFuncion(Integer codigoFuncion) throws Exception;

    List<Funcion> listarFuncion();

    Sala crearSala(Sala sala) throws Exception;

    void eliminarSala(Integer codigoSala) throws Exception;

    List<Sala> listarSalas();

    Horario crearHorario(Horario horario) throws Exception;

    void eliminarHorario(Integer codigoHorario) throws Exception;
}
