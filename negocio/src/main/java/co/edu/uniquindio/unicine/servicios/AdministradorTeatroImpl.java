package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.AdministradorTeatroRepo;
import co.edu.uniquindio.unicine.repo.FuncionRepo;
import co.edu.uniquindio.unicine.repo.SalaRepo;
import co.edu.uniquindio.unicine.repo.TeatroRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorTeatroImpl implements AdministradorTeatroServicio{

    AdministradorTeatroRepo administradorTeatroRepo;
    TeatroRepo teatroRepo;
    FuncionRepo funcionRepo;
    SalaRepo salaRepo;

    public AdministradorTeatroImpl(AdministradorTeatroRepo administradorTeatroRepo){

    }

    @Override
    public AdministradorTeatro login(String correo, String password) throws Exception {
        AdministradorTeatro administradorTeatro = administradorTeatroRepo.comprobarAutenticacion(correo, password);
        if (administradorTeatro == null) throw new Exception("Usuario y contraseña incorrectos");
        return administradorTeatro;
    }

    @Override
    public Teatro crearTeatro(Teatro teatro) throws Exception {
        boolean teatroExiste = esTeatroRepetido(teatro.getNombre(), teatro.getCiudad().getNombre());
        if (teatroExiste) throw new Exception("El teatro ya eiste");
        return teatroRepo.save(teatro);
    }

    private boolean esTeatroRepetido(String nombre, String ciudad) {
        return teatroRepo.buscarTeatro(nombre, ciudad) != null;
    }

    @Override
    public void eliminarTeatro(Integer codigoTeatro) throws Exception {
        Teatro teatro = teatroRepo.findTeatroByCodigo(codigoTeatro);
        if (teatro == null) throw new Exception("El teatro que intenta eliminar no existe");
        teatroRepo.delete(teatro);
    }

    @Override
    public List<Teatro> listarTeatro() {
        return teatroRepo.findAll();
    }

    @Override
    public Funcion crearFuncion(Funcion funcion) {
        return null;
    }

    @Override
    public void eliminarFuncion(Integer codigoFuncion) throws Exception {
        Funcion funcion = funcionRepo.findFuncionByCodigo(codigoFuncion);
        if (funcion == null) throw new Exception("La función no existe");
        funcionRepo.delete(funcion);
    }

    @Override
    public List<Funcion> listarFuncion() {
        return funcionRepo.findAll();
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
        return salaRepo.findAll();
    }

    @Override
    public Horario crearHorario(Horario horario) {
        return null;
    }

    @Override
    public void eliminarHorario(Integer codigoHorario) {

    }
}
