package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.repo.ClienteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ClienteTest {

    @Autowired
    private ClienteRepo clienteRepo;

    public void registrar() {

    }

    public void eliminar(){

    }

    public void actualizar(){

    }

    public void obtener(){

    }


}