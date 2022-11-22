package co.edu.uniquindio.unicine.dtos;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TeatroDTO {

    private Integer codigo;
    private String nombre;
    private String direccion;
    private String telefono;
    private String idAdministradorTeatro;
    private Integer idCiudad;

    public TeatroDTO(String nombre, String direccion, String telefono, String idAdministradorTeatro, Integer idCiudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idAdministradorTeatro = idAdministradorTeatro;
        this.idCiudad = idCiudad;
    }
}
