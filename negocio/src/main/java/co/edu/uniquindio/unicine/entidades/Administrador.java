package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Administrador extends Persona implements Serializable {

    @Column(nullable = false, unique = true)
    private String usuario;

    public Administrador(String cedula, String nombre, @Email String correo, String password, String usuario) {
        super(cedula, nombre, correo, password);
        this.usuario = usuario;
    }
}
