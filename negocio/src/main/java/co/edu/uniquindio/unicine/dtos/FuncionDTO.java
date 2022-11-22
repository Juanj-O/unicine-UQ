package co.edu.uniquindio.unicine.dtos;
import co.edu.uniquindio.unicine.entidades.Horario;
import co.edu.uniquindio.unicine.entidades.Pelicula;
import co.edu.uniquindio.unicine.entidades.Sala;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class FuncionDTO {

    private Integer codigo;

    private Float precio;

    private Integer codigoSala;

    private Integer codigoPelicula;
}
