package co.edu.uniquindio.unicine.entidades;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Positive;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cupon implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @Positive
    @Column(nullable = false)
    private Float descuento;

    @Column(nullable = false)
    private LocalDateTime fechaVencimiento;

    @Column(nullable = false)
    private Boolean estado;

    @Column(nullable = false)
    private String descripcion;

    //Relaciones

    @ToString.Exclude
    @OneToMany(mappedBy = "cupon")
    private List<CuponCliente> cuponCliente;


    public Cupon(Float descuento, LocalDateTime fechaVencimiento, Boolean estado, String descripcion) {
        this.descuento = descuento;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
        this.descripcion = descripcion;
    }
}
