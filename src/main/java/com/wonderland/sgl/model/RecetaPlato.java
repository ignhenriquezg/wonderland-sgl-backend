package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Receta_Plato")
public class RecetaPlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta_plato")
    private Integer idRecetaPlato;

    @ManyToOne
    @JoinColumn(name = "id_plato", nullable = false)
    private CatalogoPlato plato;

    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private Insumo insumo;

    @Column(name = "cantidad_necesaria", nullable = false)
    private BigDecimal cantidadNecesaria;
}