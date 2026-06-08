package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Receta_Bebida")
public class RecetaBebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta_bebida")
    private Integer idRecetaBebida;

    @ManyToOne
    @JoinColumn(name = "id_bebida", nullable = false)
    private CatalogoBebida bebida;

    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private Insumo insumo;

    @Column(name = "cantidad_necesaria", nullable = false)
    private BigDecimal cantidadNecesaria;
}