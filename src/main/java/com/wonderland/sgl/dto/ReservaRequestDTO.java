package com.wonderland.sgl.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class ReservaRequestDTO {
    private Integer idCliente;
    private Integer idMenu;
    private LocalDate fechaEvento;
    private Integer cantNinos;
}