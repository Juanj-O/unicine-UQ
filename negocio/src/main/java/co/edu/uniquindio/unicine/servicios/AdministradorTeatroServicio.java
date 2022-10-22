package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

public interface AdministradorTeatroServicio {

    AdministradorTeatro login(String correo, String password);

    Teatro crearTeatro(Teatro teatro);

    void eliminarTeatro(Integer codigoTeatro);

    List<Teatro> listarTeatro();

    Funcion crearFuncion(Funcion funcion);

    void eliminarFuncion(Integer codigoFuncion);

    List<Funcion> listarFuncion();

    Sala crearSala(Sala sala);

    void eliminarSala(Integer codigoSala);

    List<Sala> listarSalas();

    Horario crearHorario(Horario horario);

    void eliminarHorario(Integer codigoHorario);
}
