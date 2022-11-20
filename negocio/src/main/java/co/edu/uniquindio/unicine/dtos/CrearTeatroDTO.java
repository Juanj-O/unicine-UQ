package co.edu.uniquindio.unicine.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CrearTeatroDTO {

    private String nombre;
    private String direccion;
    private String telefono;
    private String idAdministradorTeatro;
    private Integer idCiudad;

}
