package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorTeatroImpl implements AdministradorTeatroServicio {

    AdministradorTeatroRepo administradorTeatroRepo;
    TeatroRepo teatroRepo;
    FuncionRepo funcionRepo;
    SalaRepo salaRepo;

    HorarioRepo horarioRepo;

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

    @Override
    public Teatro actualizarTeatro(Teatro teatro) throws Exception {
        verificarTeatro(teatro.getCodigo());
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
    public List<Teatro> listarTeatro() { return teatroRepo.findAll(); }

    @Override
    public Teatro consultarTeatro(Integer codigoTeatro) throws Exception {
        verificarTeatro(codigoTeatro);
        return teatroRepo.findById(codigoTeatro).orElse(null);
    }

    @Override
    public Funcion crearFuncion(Funcion funcion) throws Exception {
        verificarFuncion(funcion.getCodigo());
        return funcionRepo.save(funcion);
    }

    @Override
    public Funcion actualizarFuncion(Funcion funcion) throws Exception {
        verificarFuncion(funcion.getCodigo());
        return funcionRepo.save(funcion);
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
    public Funcion consultarFuncion(Integer codigoFuncion) throws Exception {
        verificarFuncion(codigoFuncion);
        return funcionRepo.findById(codigoFuncion).orElse(null);
    }

    @Override
    public Sala crearSala(Sala sala) throws Exception {
        validarSala(sala);
        return salaRepo.save(sala);
    }

    @Override
    public Sala actualizarSala(Sala sala) throws Exception {
        verificarSalaCodgio(sala.getCodigo());
        return salaRepo.save(sala);
    }

    @Override
    public void eliminarSala(Integer codigoSala) throws Exception {
        verificarSalaCodgio(codigoSala);
        salaRepo.deleteById(codigoSala);
    }

    @Override
    public List<Sala> listarSalas() {
        return salaRepo.findAll();
    }

    @Override
    public Sala consultarSala(Integer codigoSala) throws Exception {
        verificarSalaCodgio(codigoSala);
        return salaRepo.findById(codigoSala).orElse(null);
    }

    @Override
    public Horario crearHorario(Horario horario) throws Exception {
        verificarHorario(horario.getCodigo());
        return horarioRepo.save(horario);
    }

    @Override
    public Horario actualizarHorario(Horario horario) throws Exception {
        verificarHorario(horario.getCodigo());
        return horarioRepo.save(horario);
    }

    @Override
    public void eliminarHorario(Integer codigoHorario) throws Exception {
        Horario horario = consultarHorario(codigoHorario);
        horarioRepo.delete(horario);
    }

    @Override
    public List<Horario> listarHorarios()  {
        return null;
    }

    @Override
    public Horario consultarHorario(Integer codigoHorarioFuncion) throws Exception {
        verificarHorario(codigoHorarioFuncion);
        return horarioRepo.findById(codigoHorarioFuncion).orElse(null);
    }

    private void verificarTeatro(Integer codigoTeatro) throws Exception {
        Teatro teatro = teatroRepo.findById(codigoTeatro).orElse(null);
        if (teatro == null) {
            throw new Exception("El teatro no existe");
        }
    }

    private void verificarFuncion(Integer codigoFuncion) throws Exception {
        Funcion funcion = funcionRepo.findById(codigoFuncion).orElse(null);
        if (funcion == null){
            throw new Exception("La función no existe");
        }
    }

    private void validarSala(Sala sala) throws Exception {
        if (sala.getNombre() == null) {
            throw new Exception("El Nombre esta vacio y es obligatiorio");
        } else if (sala.getDistribucionSillas() == null) {
            throw new Exception("Distribucion sillas  esta vacio y es obligatiorio");
        }
        Teatro teatro = teatroRepo.findById(sala.getTeatro().getCodigo()).orElse(null);
        if (teatro == null){
            throw new Exception("El teatro es obligatorio");
        }
    }

    private void verificarSalaCodgio (Integer codigoSala) throws Exception {
        Sala sala = salaRepo.findById(codigoSala).orElse(null);
        if (sala == null){
            throw new Exception("la sala no existe");
        }
    }

    private void verificarHorario(Integer codigoHorarioFuncion) throws Exception {
        Horario horario = horarioRepo.findById(codigoHorarioFuncion).orElse(null);
        if (horario == null){
            throw new Exception("El horario no existe");
        }
    }
}
