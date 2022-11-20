package co.edu.uniquindio.unicine.rest;

import co.edu.uniquindio.unicine.dtos.LoginDTO;
import co.edu.uniquindio.unicine.entidades.*;
import co.edu.uniquindio.unicine.repo.*;
import co.edu.uniquindio.unicine.servicios.AdministradorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("api/admnistrador")
public class AdmnistradorController {

    @Autowired
    private AdministradorImpl administrador;

    @PostMapping("/login-administrador")
    public ResponseEntity<?> loginAdministrador(@RequestBody LoginDTO login){
        try {
            return ResponseEntity.status(200).body(administrador.login(login.getCorreo(), login.getPassword()));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/registrar-admin-teatro")
    public ResponseEntity<?> registrarAdminTeatro(@RequestBody AdministradorTeatro administradorTeatro){
        try {
            return ResponseEntity.status(200).body(administrador.registrarAdminTeatro(administradorTeatro));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-admin-teatros")
    public ResponseEntity<?> listarAdminTeatro() {
        try {
            return ResponseEntity.status(200).body(administrador.listarAdminTeatro());
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }


    @PostMapping("/crear-pelicula")
    public ResponseEntity<?> crearPelicula(@RequestBody Pelicula pelicula){
        try {
            return ResponseEntity.status(200).body(administrador.crearPelicula(pelicula));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-pelicula")
    public ResponseEntity<?> actualizarPelicula(@RequestBody Pelicula pelicula){
        try {
            return ResponseEntity.status(200).body(administrador.actualizarPelicula(pelicula));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-pelicula/{id}")
    public ResponseEntity<?> eliminarPelicula(@PathVariable(name = "id") Integer id){
        try {
            administrador.eliminarPelicula(id);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/pelicula/{id}")
    public ResponseEntity<?> consultarPelicula(@PathVariable(name="id") Integer id) {
        try {
            return ResponseEntity.status(200).body(administrador.consultarPelicula(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
    @GetMapping("/listar-peliculas")
    public ResponseEntity<?> listarPeliculas(){
        try {
            return ResponseEntity.status(200).body(administrador.listarPeliculas());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/crear-confiteria")
    public ResponseEntity<?> crearConfiteria(@RequestBody Confiteria confiteria){
        try {
            return ResponseEntity.status(200).body(administrador.crearConfiteria(confiteria));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-confiteria")
    public ResponseEntity<?> actualizarConfiteria(@RequestBody Confiteria confiteria){
        try {
            return ResponseEntity.status(200).body(administrador.actualizarConfiteria(confiteria));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-confiteria/{id}")
    public ResponseEntity<?> eliminarConfiteria(@PathVariable(name = "id") Integer id){
        try {
            administrador.eliminarConfiteria(id);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/consultar-confiteria/{id}")
    public ResponseEntity<?> consultarConfiteria(@PathVariable(name="id") Integer id) {
        try {
            return ResponseEntity.status(200).body(administrador.consultarConfiteria(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-confiteria")
    public ResponseEntity<?> listarConfiteria(){
        try {
            return ResponseEntity.status(200).body(administrador.listarConfiteria());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/crear-cupon")
    public ResponseEntity<?> crearCupon(@RequestBody Cupon cupon){
        try {
            return ResponseEntity.status(200).body(administrador.crearCupon(cupon));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-cupon")
    public ResponseEntity<?> actualizarCupon(@RequestBody Cupon cupon){
        try {
            return ResponseEntity.status(200).body(administrador.actualizarCupon(cupon));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-cupon/{id}")
    public ResponseEntity<?> eliminarCupon(@PathVariable(name = "id") Integer id){
        try {
            administrador.eliminarCupon(id);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-cupones")
    public ResponseEntity<?> listarCupones(){
        try {
            return ResponseEntity.status(200).body(administrador.listarCupones());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/consultar-cupon/{id}")
    public ResponseEntity<?> consultarCupon(@PathVariable(name="id") Integer id) {
        try {
            return ResponseEntity.status(200).body(administrador.consultarCupon(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/crear-ciudad")
    public ResponseEntity<?> crearCiudad(@RequestBody Ciudad ciudad){
        try {
            return ResponseEntity.status(200).body(administrador.crearCiudad(ciudad));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-ciudad")
    public ResponseEntity<?> actualizarCiudad(@RequestBody Ciudad ciudad){
        try {
            return ResponseEntity.status(200).body(administrador.actualizarCiudad(ciudad));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-ciudad/{id}")
    public ResponseEntity<?> eliminarCiudad(@PathVariable(name = "id") Integer id){
        try {
            administrador.eliminarCiudad(id);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-ciudadades")
    public ResponseEntity<?> listarCiudades(){
        try {
            return ResponseEntity.status(200).body(administrador.listarCiudades());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/consultar-ciudad/{id}")
    public ResponseEntity<?> consultarCiudad(@PathVariable(name="id") Integer id) {
        try {
            return ResponseEntity.status(200).body(administrador.consultarCiudad(id));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
