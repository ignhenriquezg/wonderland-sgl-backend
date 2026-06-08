package com.wonderland.sgl.dto;

import lombok.Data;

@Data
public class StaffRequeridoDTO {
    private String rolOPersonaje;
    private Integer cantidadNecesaria;

    public StaffRequeridoDTO(String rolOPersonaje, Integer cantidadNecesaria) {
        this.rolOPersonaje = rolOPersonaje;
        this.cantidadNecesaria = cantidadNecesaria;
    }
}