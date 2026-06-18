package com.wonderland.sgl.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Menu_Insumo")
public class MenuInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_menu_insumo")
    private Integer idMenuInsumo;

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    @JsonIgnoreProperties("insumos")
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_insumo", nullable = false)
    private Insumo insumo;

    @Column(name = "cantidad_necesaria", nullable = false)
    private Double cantidadNecesaria;
}