package co.edu.uniquindio.unicine.servicios;

import co.edu.uniquindio.unicine.dtos.FuncionDTO;
import co.edu.uniquindio.unicine.dtos.SalaDTO;
import co.edu.uniquindio.unicine.dtos.TeatroDTO;
import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorTeatroImpl implements AdministradorTeatroServicio {

    @Autowired
    AdministradorTeatroRepo administradorTeatroRepo;
    @Autowired
    TeatroRepo teatroRepo;
    @Autowired
    FuncionRepo funcionRepo;
    @Autowired
    SalaRepo salaRepo;
    @Autowired
    HorarioRepo horarioRepo;

    @Autowired
    CiudadRepo ciudadRepo;

    @Autowired
    PeliculaRepo peliculaRepo;

    @Autowired
    DistribucionSillasRepo distribucionSillasRepo;

    @Autowired
    AdministradorImpl administradorImpl;

    @Override
    public AdministradorTeatro login(String correo, String password) throws Exception {
        AdministradorTeatro administradorTeatro = administradorTeatroRepo.comprobarAutenticacion(correo, password);
        if (administradorTeatro == null) throw new Exception("Usuario y contraseña incorrectos");
        return administradorTeatro;
    }

    @Override
    public Teatro crearTeatro(TeatroDTO teatroDto) throws Exception {
        Ciudad ciudad = administradorImpl.consultarCiudad(teatroDto.getIdCiudad());
        AdministradorTeatro administradorTeatro= administradorTeatroRepo.findAdministradorTeatroByCedula(teatroDto.getIdAdministradorTeatro());
        Teatro teatroAux = teatroRepo.findTeatroByNombre(teatroDto.getNombre());
        if(administradorTeatro == null) {
            throw new Exception("El Administrador de teatro no existe");
        } else if (teatroAux != null) {
            throw new Exception("Ya existe un teatro con ese nombre");
        }
        Teatro teatro = new Teatro(teatroDto.getNombre(), teatroDto.getDireccion(),
                teatroDto.getTelefono(), administradorTeatro, ciudad);

        return teatroRepo.save(teatro);
    }

    @Override
    public Teatro actualizarTeatro(TeatroDTO teatroDto) throws Exception {
        Ciudad ciudad = administradorImpl.consultarCiudad(teatroDto.getIdCiudad());
        AdministradorTeatro administradorTeatro= administradorTeatroRepo.findAdministradorTeatroByCedula(teatroDto.getIdAdministradorTeatro());
        if(administradorTeatro == null) {
            throw new Exception("El Administrador de teatro no existe");
        }
        System.out.println(teatroDto);
        Teatro teatroAux = teatroRepo.findTeatroByCodigo(teatroDto.getCodigo());
        if (teatroAux==null) throw new Exception("No existe el teatro");
        teatroAux.setDireccion(teatroDto.getDireccion());
        teatroAux.setNombre(teatroDto.getNombre());
        teatroAux.setTelefono(teatroDto.getTelefono());
        teatroAux.setCiudad(ciudad);
        teatroAux.setAdministradorTeatro(administradorTeatro);

        return teatroRepo.save(teatroAux);
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
    public Funcion crearFuncion(FuncionDTO funcionDto) throws Exception {
        Pelicula pelicula = peliculaRepo.findByCodigo(funcionDto.getCodigoPelicula());
        Sala sala = salaRepo.findByCodigo(funcionDto.getCodigoSala());
        if (pelicula == null){
            throw new Exception("La pelicula no existe");
        } else if (sala == null) {
            throw new Exception("La sala no existe");
        }
        Funcion funcion = new Funcion(funcionDto.getPrecio(), sala, pelicula );
        return funcionRepo.save(funcion);
    }

    @Override
    public Funcion actualizarFuncion(FuncionDTO funcionDto) throws Exception {
        Funcion funcion = verificarFuncion(funcionDto.getCodigo());
        funcion.setPrecio(funcionDto.getPrecio());
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
    public Sala crearSala(SalaDTO salaDto) throws Exception {
        Pelicula pelicula = peliculaRepo.findByCodigo(salaDto.getCodigoPelicula());
        Teatro teatro = teatroRepo.findTeatroByCodigo(salaDto.getCodigoTeatro());
        DistribucionSillas distribucionSillas = distribucionSillasRepo.findByCodigo(salaDto.getCodigoDistribucionSillas());

        if (pelicula == null) {
            throw new Exception("La pelicula no existe");
        } else if (teatro == null) {
            throw new Exception("El teatro no existe");
        } else if (distribucionSillas == null) {
            throw new Exception("La distribucion de sillas no existe");
        }
        Sala sala = new Sala(salaDto.getNombre(), distribucionSillas, teatro);

        return salaRepo.save(sala);
    }

    @Override
    public Sala actualizarSala(SalaDTO salaDto) throws Exception {
        Pelicula pelicula = peliculaRepo.findByCodigo(salaDto.getCodigoPelicula());
        Teatro teatro = teatroRepo.findTeatroByCodigo(salaDto.getCodigoTeatro());
        DistribucionSillas distribucionSillas = distribucionSillasRepo.findByCodigo(salaDto.getCodigoDistribucionSillas());
        Sala salaAux = salaRepo.findByCodigo(salaDto.getCodigo());
        if (pelicula == null) {
            throw new Exception("La pelicula no existe");
        } else if (teatro == null) {
            throw new Exception("El teatro no existe");
        } else if (distribucionSillas == null) {
            throw new Exception("La distribucion de sillas no existe");
        } else if (salaAux == null) {
            throw new Exception("La sala no existe");
        }
        salaAux.setNombre(salaDto.getNombre());
        salaAux.setTeatro(teatro);
        salaAux.setDistribucionSillas(distribucionSillas);
        salaAux.setTeatro(teatro);

        return salaRepo.save(salaAux);
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
        return horarioRepo.findAll();
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

    private Funcion verificarFuncion(Integer codigoFuncion) throws Exception {
        Funcion funcion = funcionRepo.findById(codigoFuncion).orElse(null);
        if (funcion == null){
            throw new Exception("La función no existe");
        }
        return funcion;
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
        Sala sala = salaRepo.findByCodigo(codigoSala);
        if (sala == null){
            throw new Exception("la sala no existe");
        }
    }

    private void verificarHorario(Integer codigoHorarioFuncion) throws Exception {
        Horario horario = horarioRepo.findByCodigo(codigoHorarioFuncion);
        if (horario == null){
            throw new Exception("El horario no existe");
        }
    }
}
