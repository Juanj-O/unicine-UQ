package co.edu.uniquindio.unicine.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AdministradorTeatro extends Persona implements Serializable {

    @JsonIgnore
    @ToStringExclude
    @OneToMany(mappedBy = "administradorTeatro")
    private List<Teatro> teatros;

    public AdministradorTeatro(String cedula,String nombre, String correo, String password) {
        super(cedula, nombre, correo, password);
    }
}
