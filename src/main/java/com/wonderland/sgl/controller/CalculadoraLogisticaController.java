package com.wonderland.sgl.controller;

import com.wonderland.sgl.dto.InsumoCalculadoDTO;
import com.wonderland.sgl.dto.StaffRequeridoDTO;
import com.wonderland.sgl.service.CalculadoraLogisticaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logistica")
@CrossOrigin(origins = "*")
public class CalculadoraLogisticaController {

    @Autowired
    private CalculadoraLogisticaService calculadoraService;

    @GetMapping("/insumos")
    public List<InsumoCalculadoDTO> calcularInsumos(
            @RequestParam Integer idMenu, 
            @RequestParam Integer cantNinos) {
        return calculadoraService.calcularInsumosParaEvento(idMenu, cantNinos);
    }

    @GetMapping("/staff")
    public List<StaffRequeridoDTO> calcularStaff(
            @RequestParam Integer idMenu,
            @RequestParam Integer cantNinos) {
        return calculadoraService.calcularStaffParaEvento(idMenu, cantNinos);
    }
}