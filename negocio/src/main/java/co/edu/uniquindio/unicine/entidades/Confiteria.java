package co.edu.uniquindio.unicine.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Confiteria implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String imagen;

    @Column(nullable = false)
    @Positive
    private Float precio;

    @JsonIgnore
    @OneToMany(mappedBy = "confiteria")
    private List<ConfiteriaCompra> confiteria;

    public Confiteria(String nombre, String imagen, Float precio) {
        this.nombre = nombre;
        this.imagen = imagen;
        this.precio = precio;
    }
}
