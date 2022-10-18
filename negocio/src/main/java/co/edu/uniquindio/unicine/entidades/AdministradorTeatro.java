package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(callSuper = true)
public class AdministradorTeatro extends Persona implements Serializable {

    @OneToMany(mappedBy = "administrador_teatro")
    private List<Teatro> teatros;

    @Builder
    public AdministradorTeatro(String nombre, String correo, String password) {
        super(nombre, correo, password);
    }
}
