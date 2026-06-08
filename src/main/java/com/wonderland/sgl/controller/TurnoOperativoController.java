package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.TurnoOperativo;
import com.wonderland.sgl.service.TurnoOperativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "*")
public class TurnoOperativoController {
    @Autowired private TurnoOperativoService service;
    @GetMapping public List<TurnoOperativo> listar() { return service.obtenerTodos(); }
    @PostMapping public TurnoOperativo crear(@RequestBody TurnoOperativo turno) { return service.crear(turno); }
}