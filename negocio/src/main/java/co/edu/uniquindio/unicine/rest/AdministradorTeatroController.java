package co.edu.uniquindio.unicine.rest;

import co.edu.uniquindio.unicine.dtos.CrearTeatroDTO;
import co.edu.uniquindio.unicine.dtos.LoginDTO;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.entidades.Teatro;
import co.edu.uniquindio.unicine.servicios.AdministradorImpl;
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
    public ResponseEntity<?> crearTeatro(@RequestBody CrearTeatroDTO teatro){
        try {
            return ResponseEntity.status(200).body(administradorTeatro.crearTeatro(teatro));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-teatro")
    public ResponseEntity<?> actualizarTeatro(@RequestBody Teatro teatro){
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
}
