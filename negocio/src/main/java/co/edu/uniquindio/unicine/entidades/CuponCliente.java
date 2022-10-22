package co.edu.uniquindio.unicine.entidades;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class CuponCliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer codigo;

    @JoinColumn(nullable = false)
    private Boolean estado;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Cupon cupon;
}