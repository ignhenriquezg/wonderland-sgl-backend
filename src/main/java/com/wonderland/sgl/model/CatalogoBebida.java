package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Catalogo_Bebida")
public class CatalogoBebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bebida")
    private Integer idBebida;

    @Column(name = "nombre_bebida", nullable = false)
    private String nombreBebida;
}