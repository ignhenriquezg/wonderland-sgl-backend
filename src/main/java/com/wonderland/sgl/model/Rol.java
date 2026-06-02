package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data 
@Entity 
@Table(name = "Rol") 
public class Rol {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    @Column(name = "id_rol")
    private Integer idRol;

    @Column(name = "nombre_rol", nullable = false)
    private String nombreRol;
}