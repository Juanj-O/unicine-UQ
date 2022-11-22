package co.edu.uniquindio.unicine.dtos;


import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SalaDTO {

    private Integer codigo;

    private String nombre;

    private Integer codigoDistribucionSillas;

    private Integer codigoTeatro;

    private Integer codigoPelicula;

}
