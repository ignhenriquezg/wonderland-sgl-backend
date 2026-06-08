package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Menu_Personaje")
public class MenuPersonaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_m_personaje")
    private Integer idMPersonaje;

    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "id_personaje", nullable = false)
    private CatalogoPersonaje personaje;
}