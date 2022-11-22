package co.edu.uniquindio.unicine.rest;

import co.edu.uniquindio.unicine.dtos.CompraDTO;
import co.edu.uniquindio.unicine.dtos.LoginDTO;
import co.edu.uniquindio.unicine.entidades.AdministradorTeatro;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.servicios.ClienteServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/cliente")
public class ClienteController {

    @Autowired
    private ClienteServicioImpl clienteServicioImpl;

    @PostMapping("/login-cliente")
    public ResponseEntity<?> loginCliente(@RequestBody LoginDTO login){
        System.out.println(login);
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.login(login.getCorreo(), login.getPassword()));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/registrar-cliente")
    public ResponseEntity<?> registrarCliente(@RequestBody Cliente cliente){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.registrarCliente(cliente));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PutMapping("/actualizar-cliente")
    public ResponseEntity<?> actualizarCliente(@RequestBody Cliente cliente){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.actualizarCliente(cliente));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @DeleteMapping("/eliminar-cliente/{id}")
    public ResponseEntity<?> eliminarCliente(@PathVariable(name = "id") String cedula){
        try {
            clienteServicioImpl.eliminarCliente(cedula);
            return ResponseEntity.status(200).body("Eliminado Exitosamente");
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-clientes")
    public ResponseEntity<?> listarClientes(){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.listarCliente());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping(value="/cliente/{id}")
    public ResponseEntity<?> buscarCliente(@PathVariable(name="id") String cedula) {
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.buscarCliente(cedula));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-ciudades")
    public ResponseEntity<?> listarCiudades(){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.listarCiudades());
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    /**
     * Metodo que permite listar los teatros dado el codigo de una ciudad
     */
    @GetMapping("/listar-teatros-ciudad/{id}")
    public ResponseEntity<?> listarTeatrosCiudad(@PathVariable(name="id") Integer codigoCiudad){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.listarTeatrosCiudad(codigoCiudad));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    /**
     * Metodo que permite listar las peliculas en cartelera de un teatro
     *
     */
    @GetMapping("/listar-peliculas-teatro/{id}")
    public ResponseEntity<?> listarPeliculasCartelera(@PathVariable(name="id") Integer codigoTeatro){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.listarPeliculasCartelera(codigoTeatro));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    /**
     * Metodo que permite listar las funciones de una pelicula
     * en un teatro especifico
     */
    @GetMapping("/listar-peliculas-teatro/{idPelicula}/{idTeatro}")
    public ResponseEntity<?> listarFuncionesPelicula(
            @PathVariable(name="idPelicula") Integer codigoPelicula,
            @PathVariable(name="idTeatro") Integer codigoTeatro){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.listarFuncionesPelicula(codigoPelicula, codigoTeatro));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-historial/{id}")
    public ResponseEntity<?> listarHistorial(
            @PathVariable(name="id") String cedula){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.listarHistorial(cedula));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @PostMapping("/hacer-compra")
    public ResponseEntity<?> hacerCompra(@RequestBody CompraDTO compraDto){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.hacerCompra(compraDto));
        }catch (Exception e){
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/listar-compras/{id}")
    public ResponseEntity<?> listarCompras(
            @PathVariable(name="id") String cedula){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.listarHistorial(cedula));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }

    @GetMapping("/obtener-compra/{id}")
    public ResponseEntity<?> obtenerCompra(
            @PathVariable(name="id") Integer codigoCompra){
        try {
            return ResponseEntity.status(200).body(clienteServicioImpl.obtenerCompra(codigoCompra));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(e.getMessage());
        }
    }
}
