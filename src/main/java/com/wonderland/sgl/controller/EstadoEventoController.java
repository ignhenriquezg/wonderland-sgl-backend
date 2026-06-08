package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.EstadoEvento;
import com.wonderland.sgl.service.EstadoEventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/estados-evento")
@CrossOrigin(origins = "*")
public class EstadoEventoController {
    @Autowired private EstadoEventoService service;
    @GetMapping public List<EstadoEvento> listar() { return service.obtenerTodos(); }
    @PostMapping public EstadoEvento crear(@RequestBody EstadoEvento estado) { return service.crear(estado); }
}