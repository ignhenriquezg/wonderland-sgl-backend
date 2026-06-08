package com.wonderland.sgl.dto;

import lombok.Data;
import java.util.List;

@Data
public class ResumenReservaDTO {
    private String mensaje;
    private Integer idEventoGenerado;
    private List<InsumoCalculadoDTO> insumosRequeridos;
    private List<StaffRequeridoDTO> staffSugerido;

    public ResumenReservaDTO(String mensaje, Integer idEventoGenerado, List<InsumoCalculadoDTO> insumos, List<StaffRequeridoDTO> staff) {
        this.mensaje = mensaje;
        this.idEventoGenerado = idEventoGenerado;
        this.insumosRequeridos = insumos;
        this.staffSugerido = staff;
    }
}