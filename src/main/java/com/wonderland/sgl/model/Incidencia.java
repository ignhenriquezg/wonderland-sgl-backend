package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Incidencia")
public class Incidencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidencia")
    private Integer idIncidencia;

    @ManyToOne
    @JoinColumn(name = "id_reserva", nullable = false)
    private Reserva reserva;

    @ManyToOne
    @JoinColumn(name = "id_personal_reporta", nullable = false)
    private Personal personalReporta;

    @Column(nullable = false, length = 500)
    private String descripcion;

    @Column(length = 20)
    private String estado = "PENDIENTE";

    @Column(name = "hora_reporte", nullable = false)
    private LocalDateTime horaReporte;

    @Column(name = "hora_resolucion")
    private LocalDateTime horaResolucion;
}