package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Menu_Plato")
public class MenuPlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_m_plato")
    private Integer idMPlato;

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_plato", nullable = false)
    private CatalogoPlato plato;

    @Column(name = "cant_por_nino", nullable = false)
    private Integer cantPorNino;
}