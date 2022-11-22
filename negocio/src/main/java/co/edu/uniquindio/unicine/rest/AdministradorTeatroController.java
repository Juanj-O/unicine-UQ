package co.edu.uniquindio.unicine.rest;

import co.edu.uniquindio.unicine.dtos.FuncionDTO;
import co.edu.uniquindio.unicine.dtos.SalaDTO;
import co.edu.uniquindio.unicine.dtos.TeatroDTO;
import co.edu.uniquindio.unicine.dtos.LoginDTO;
import co.edu.uniquindio.unicine.entidades.Funcion;
import co.edu.uniquindio.unicine.entidades.Horario;
import co.edu.uniquindio.unicine.entidades.Sala;
import co.edu.uniquindio.unicine.servicios.AdministradorTeatroImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admnistrador-teatro")
public class AdministradorTeatroController {

    @Autowired
    private AdministradorTeatroImpl administradorTeatro;

    @PostMapping("/login-administrador-teatro")
    public ResponseEntity<?> loginAdministradorTeatro(@RequestBody LoginDTO login){
        System.out.println(login);
        try {
            return ResponseEntity.status(200).body(administradorTeatro.login(login.getCorreo(), login.getPassword()));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/crear-teatro")
    public ResponseEntity<?> crearTeatro(@RequestBody TeatroDTO teatro){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.crearTeatro(teatro));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-teatro")
    public ResponseEntity<?> actualizarTeatro(@RequestBody TeatroDTO teatro){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.actualizarTeatro(teatro));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-teatro/{id}")
    public ResponseEntity<?> eliminarTeatro(@PathVariable(name = "id") Integer id){
        try {
            administradorTeatro.eliminarTeatro(id);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/teatro/{id}")
    public ResponseEntity<?> consultarTeatro(@PathVariable(name="id") Integer id) {
        try {
            return ResponseEntity.status(200).body(administradorTeatro.consultarTeatro(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/listar-teatros")
    public ResponseEntity<?> listarTeatro(){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.listarTeatro());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/crear-funcion")
    public ResponseEntity<?> crearFuncion(@RequestBody FuncionDTO funcionDto){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.crearFuncion(funcionDto));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-funcion")
    public ResponseEntity<?> actualizarFuncion(@RequestBody FuncionDTO funcion){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.actualizarFuncion(funcion));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-funcion/{id}")
    public ResponseEntity<?> eliminarFuncion(@PathVariable(name = "id") Integer id){
        try {
            administradorTeatro.eliminarFuncion(id);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/funcion/{id}")
    public ResponseEntity<?> consultarFuncion(@PathVariable(name="id") Integer id) {
        try {
            return ResponseEntity.status(200).body(administradorTeatro.consultarFuncion(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/listar-funciones")
    public ResponseEntity<?> listarFuncion(){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.listarFuncion());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/crear-sala")
    public ResponseEntity<?> crearSala(@RequestBody SalaDTO salaDto){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.crearSala(salaDto));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-sala")
    public ResponseEntity<?> actualizarSala(@RequestBody SalaDTO salaDto){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.actualizarSala(salaDto));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-sala/{id}")
    public ResponseEntity<?> eliminarSala(@PathVariable(name = "id") Integer id){
        try {
            administradorTeatro.eliminarSala(id);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/sala/{id}")
    public ResponseEntity<?> consultarSala(@PathVariable(name="id") Integer id) {
        try {
            return ResponseEntity.status(200).body(administradorTeatro.consultarSala(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/listar-salas")
    public ResponseEntity<?> listarSalas(){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.listarSalas());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    @PostMapping("/crear-horario")
    public ResponseEntity<?> crearHorario(@RequestBody Horario horario){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.crearHorario(horario));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-horario")
    public ResponseEntity<?> actualizarHorario(@RequestBody Horario horario){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.actualizarHorario(horario));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-horario/{id}")
    public ResponseEntity<?> eliminarHorario(@PathVariable(name = "id") Integer id){
        System.out.println(id);
        try {
            administradorTeatro.eliminarHorario(id);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/horario/{id}")
    public ResponseEntity<?> consultarHorario(@PathVariable(name="id") Integer id) {
        try {
            return ResponseEntity.status(200).body(administradorTeatro.consultarHorario(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/listar-horarios")
    public ResponseEntity<?> listarHorarios(){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.listarHorarios());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
