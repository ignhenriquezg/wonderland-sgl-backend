package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Insumo")
public class Insumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_insumo")
    private Integer idInsumo;

    @Column(nullable = false)
    private String nombre;

    @Column(name = "unidad_medida", nullable = false)
    private String unidadMedida;

    // --- NUEVA COLUMNA DE INVENTARIO ---
    @Column(name = "stock_actual", nullable = false)
    private Double stockActual = 0.0;
}