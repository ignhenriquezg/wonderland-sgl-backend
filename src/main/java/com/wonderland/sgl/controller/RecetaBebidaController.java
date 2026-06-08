package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.RecetaBebida;
import com.wonderland.sgl.service.RecetaBebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/receta-bebidas")
@CrossOrigin(origins = "*")
public class RecetaBebidaController {
    @Autowired private RecetaBebidaService service;
    @GetMapping public List<RecetaBebida> listar() { return service.obtenerTodas(); }
    @PostMapping public RecetaBebida crear(@RequestBody RecetaBebida receta) { return service.crear(receta); }
}