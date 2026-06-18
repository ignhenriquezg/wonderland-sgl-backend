package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

    @Column(name = "tipo_producto", length = 30)
    private String tipoProducto; 

    // --- RELACIÓN ASOCIADA EN CASCADA PARA GUARDAR INGREDIENTES ---
    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("menu")
    private List<MenuInsumo> insumos;
}