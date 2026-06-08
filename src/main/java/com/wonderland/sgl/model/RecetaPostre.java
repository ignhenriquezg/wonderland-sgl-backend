package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Receta_Postre")
public class RecetaPostre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_receta_postre")
    private Integer idRecetaPostre;

    @ManyToOne
    @JoinColumn(name = "id_postre", nullable = false)
    private CatalogoPostre postre;

    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private Insumo insumo;

    @Column(name = "cantidad_necesaria", nullable = false)
    private BigDecimal cantidadNecesaria;
}