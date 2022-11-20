package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.dtos.CrearTeatroDTO;
import co.edu.uniquindio.unicine.entidades.*;

import java.util.List;

public interface AdministradorTeatroServicio {

    AdministradorTeatro login(String correo, String password)throws Exception;

    Teatro crearTeatro(CrearTeatroDTO teatro) throws Exception;

    Teatro actualizarTeatro(Teatro teatro) throws Exception;

    void eliminarTeatro(Integer codigoTeatro) throws Exception;

    List<Teatro> listarTeatro();

    Teatro consultarTeatro(Integer codigoTeatro) throws Exception;


    Funcion crearFuncion(Funcion funcion) throws Exception;

    Funcion actualizarFuncion(Funcion funcion) throws Exception;

    void eliminarFuncion(Integer codigoFuncion) throws Exception;

    List<Funcion> listarFuncion();

    Funcion consultarFuncion(Integer codigoFuncion) throws Exception;

    Sala crearSala(Sala sala) throws Exception;

    Sala actualizarSala(Sala sala) throws Exception;


    void eliminarSala(Integer codigoSala) throws Exception;

    List<Sala> listarSalas();

    Sala consultarSala(Integer codigoSala) throws Exception;

    Horario crearHorario(Horario horario) throws Exception;
    Horario actualizarHorario(Horario horario) throws Exception;

    void eliminarHorario(Integer codigoHorario) throws Exception;

    List<Horario> listarHorarios();

    Horario consultarHorario(Integer codigoHorarioFuncion) throws Exception;


}
