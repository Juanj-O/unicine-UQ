package co.edu.uniquindio.unicine.rest;
import co.edu.uniquindio.unicine.entidades.Cliente;
import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
public class PruebaController {

    @Autowired
    private ClienteRepo clienteRepo;


    @GetMapping
    public List<Cliente> listarUsuarios(){
        return clienteRepo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Optional<Cliente> ObtenerClientePorId(@PathVariable(name = "id") String id){
        return clienteRepo.findById(id);
    }
}
