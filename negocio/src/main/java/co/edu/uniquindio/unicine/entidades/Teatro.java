package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
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
    private Integer telefono;

    @ManyToOne
    @JoinColumn(nullable = false)
    private AdministradorTeatro administradorTeatro;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Ciudad ciudad;


    @OneToMany(mappedBy = "teatro")
    private List<Sala> salas;


    public Teatro(String nombre, String direccion, Integer telefono, AdministradorTeatro administradorTeatro, Ciudad ciudad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.administradorTeatro = administradorTeatro;
        this.ciudad = ciudad;
    }
}
