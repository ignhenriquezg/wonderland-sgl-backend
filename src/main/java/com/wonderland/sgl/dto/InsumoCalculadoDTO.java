package com.wonderland.sgl.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class InsumoCalculadoDTO {
    private String nombreInsumo;
    private String unidadMedida;
    private BigDecimal cantidadTotal;

    // Un constructor personalizado para facilitar la creación de estos paquetes
    public InsumoCalculadoDTO(String nombreInsumo, String unidadMedida, BigDecimal cantidadTotal) {
        this.nombreInsumo = nombreInsumo;
        this.unidadMedida = unidadMedida;
        this.cantidadTotal = cantidadTotal;
    }
}
