package co.edu.uniquindio.unicine.test;

import co.edu.uniquindio.unicine.repo.FuncionRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class FuncionTest {


    @Autowired
    private FuncionRepo funcionRepo;

    @Test
    public void registrar() {


    }
    @Test
    @Sql("classpath:dataset.sql")
    public void eliminar(){

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void actualizar(){

    }
    @Test
    @Sql("classpath:dataset.sql")
    public void obtener(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void obtenerEntradaCompra(){

    }

    @Test
    @Sql("classpath:dataset.sql")
    public void listarFuncionesPorPelicula(){
        List<Object[]> funciones = funcionRepo.listarFuncionesPorPelicula(4);
        funciones.forEach(o ->
                System.out.println(o[0] +", "+ o[1]+", "+ o[2]+", "+ o[3]+", "+ o[4]+", "+ o[5]+", "+ o[6])
                );

    }

}
