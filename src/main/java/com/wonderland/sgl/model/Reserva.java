package com.wonderland.sgl.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Reserva")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer idReserva;

    // Relación con el Cliente que solicita el evento
    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    // Relación con el paquete/menú que eligió
    @ManyToOne
    @JoinColumn(name = "id_menu", nullable = false)
    private Menu menu;

    // Fecha y hora solicitada para el evento
    @Column(name = "fecha_hora", nullable = false)
    private LocalDateTime fechaHora;

    // Para el cálculo logístico de los insumos
    @Column(name = "cantidad_ninos", nullable = false)
    private Integer cantidadNinos;

    @Column(name = "cantidad_adultos", nullable = false)
    private Integer cantidadAdultos;

    // El valor referencial que le mostraremos al cliente al final del asistente
    @Column(name = "total_estimado")
    private Integer totalEstimado;

    // Alergias, solicitudes vegetarianas, etc.
    @Column(length = 500)
    private String observaciones;

    // A este campo le enviaremos "PENDIENTE" desde la página web pública
    // Luego en tu panel admin podrás cambiarlo a "CONFIRMADA" o "RECHAZADA"
    @Column(nullable = false, length = 20)
    private String estado;
}