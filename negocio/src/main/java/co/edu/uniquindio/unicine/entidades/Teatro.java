package co.edu.uniquindio.unicine.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Teatro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false, length = 150)
    private String direccion;

    @Column(nullable = false)
    private String telefono;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private AdministradorTeatro administradorTeatro;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;

    @JsonIgnore
    @ToStringExclude
    @OneToMany(mappedBy = "teatro")
    private List<Sala> salas;


    public Teatro(String nombre, String direccion, String telefono, AdministradorTeatro administradorTeatro, Ciudad ciudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.administradorTeatro = administradorTeatro;
        this.ciudad = ciudad;
    }
}
