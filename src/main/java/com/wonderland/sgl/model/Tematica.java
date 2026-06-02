package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Tematica")
public class Tematica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tematica")
    private Integer idTematica;

    @Column(name = "nombre_tematica", nullable = false)
    private String nombreTematica;

    @Column
    private String descripcion;
}