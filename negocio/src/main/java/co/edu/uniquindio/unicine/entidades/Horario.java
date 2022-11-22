package co.edu.uniquindio.unicine.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Horario implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Column(nullable = false)
    private String dia;

    @Column(nullable = false)
    private String hora;

    @ManyToOne
    @ToString.Exclude
    private Funcion funcion;

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "horario")
    private List<Compra> compras;

    public Horario( String dia, String hora) {
        this.dia = dia;
        this.hora = hora;
    }
}
