package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Catalogo_Personaje")
public class CatalogoPersonaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_personaje")
    private Integer idPersonaje;

    @Column(name = "nombre_personaje", nullable = false)
    private String nombrePersonaje;
}