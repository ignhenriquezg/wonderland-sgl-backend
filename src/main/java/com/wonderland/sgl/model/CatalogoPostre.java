package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Catalogo_Postre")
public class CatalogoPostre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_postre")
    private Integer idPostre;

    @Column(name = "nombre_postre", nullable = false)
    private String nombrePostre;
}