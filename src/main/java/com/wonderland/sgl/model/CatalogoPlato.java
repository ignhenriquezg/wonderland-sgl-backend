package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Catalogo_Plato")
public class CatalogoPlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_plato")
    private Integer idPlato;

    @Column(name = "nombre_plato", nullable = false)
    private String nombrePlato;

    @Column
    private String descripcion;
}