package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Turno_Operativo")
public class TurnoOperativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_turno")
    private Integer idTurno;

    // Conexión actualizada al nuevo motor
    @ManyToOne
    @JoinColumn(name = "id_reserva")
    private Reserva reserva;

    // Mantenemos evento por compatibilidad, pero ya no es obligatorio
    @ManyToOne
    @JoinColumn(name = "id_evento")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "id_personal", nullable = false)
    private Personal personal;

    @ManyToOne
    @JoinColumn(name = "id_personaje") 
    private CatalogoPersonaje personaje;

    @Column(name = "hora_inicio", nullable = false)
    private LocalDateTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalDateTime horaFin;

    // --- NUEVOS CAMPOS DE ASISTENCIA ---
    @Column(name = "estado_asistencia", length = 20)
    private String estadoAsistencia = "PENDIENTE";

    @Column(length = 1000)
    private String justificacion;

    @Column(name = "ruta_archivo")
    private String rutaArchivo;
}