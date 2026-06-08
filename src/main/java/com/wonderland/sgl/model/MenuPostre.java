package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Menu_Postre")
public class MenuPostre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_m_postre")
    private Integer idMPostre;

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_postre", nullable = false)
    private CatalogoPostre postre;

    @Column(name = "cant_por_nino", nullable = false)
    private Integer cantPorNino;
}