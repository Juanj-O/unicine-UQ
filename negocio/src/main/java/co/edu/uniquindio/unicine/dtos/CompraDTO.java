package co.edu.uniquindio.unicine.dtos;

import co.edu.uniquindio.unicine.entidades.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CompraDTO {

    private String medioPago;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime fecha;

    private Float valorTotal;

    private Integer codigoCupon;

    private String cedula;

    private Integer codigoFuncion;

    private Integer codigoHorario;
}
