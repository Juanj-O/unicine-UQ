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

    @OneToOne(mappedBy = "cupon")
    private Compra compra;


    @OneToMany(mappedBy = "cupon")
    @ToString.Exclude
    private List<CuponCliente> cupon;

    public Cupon(Float descuento, LocalDateTime fechaVencimiento, String descripcion, Boolean estado) {
        this.descuento = descuento;
        this.fechaVencimiento = fechaVencimiento;
        this.descripcion = descripcion;
        this.estado = estado;
    }
}
