package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.RecetaPlato;
import com.wonderland.sgl.service.RecetaPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/receta-platos")
@CrossOrigin(origins = "*")
public class RecetaPlatoController {
    @Autowired private RecetaPlatoService service;
    @GetMapping public List<RecetaPlato> listar() { return service.obtenerTodas(); }
    @PostMapping public RecetaPlato crear(@RequestBody RecetaPlato receta) { return service.crear(receta); }
}