package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Menu_Bebida")
public class MenuBebida {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_m_bebida")
    private Integer idMBebida;

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_bebida", nullable = false)
    private CatalogoBebida bebida;

    @Column(name = "cant_por_nino", nullable = false)
    private Integer cantPorNino;
}