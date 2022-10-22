package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
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

    @OneToMany(mappedBy = "horario")
    private List<Funcion> funciones;

    public Horario(Integer codigo, String dia, String hora) {
        this.codigo = codigo;
        this.dia = dia;
        this.hora = hora;
    }
}
