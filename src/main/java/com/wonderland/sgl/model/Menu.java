package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu")
    private Integer idMenu;

    @ManyToOne 
    @JoinColumn(name = "id_tematica", nullable = false)
    private Tematica tematica;

    @Column(name = "nombre_menu", nullable = false)
    private String nombreMenu;

    @Column(name = "precio_base", nullable = false)
    private BigDecimal precioBase;
}