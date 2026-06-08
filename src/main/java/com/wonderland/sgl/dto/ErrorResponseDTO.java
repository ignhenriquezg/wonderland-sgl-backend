package com.wonderland.sgl.dto;

import lombok.Data;

@Data
public class ErrorResponseDTO {
    private String error;
    private String detalle;

    public ErrorResponseDTO(String error, String detalle) {
        this.error = error;
        this.detalle = detalle;
    }
}