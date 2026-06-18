package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Checklist_Turno")
public class ChecklistTurno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_checklist")
    private Integer idChecklist;

    @ManyToOne
    @JoinColumn(name = "id_turno", nullable = false)
    private TurnoOperativo turno;

    @ManyToOne
    @JoinColumn(name = "id_tarea", nullable = false)
    private CatalogoTarea tarea;

    @Column(nullable = false)
    private Boolean completada = false;

    @Column(name = "hora_completada")
    private LocalDateTime horaCompletada;
}