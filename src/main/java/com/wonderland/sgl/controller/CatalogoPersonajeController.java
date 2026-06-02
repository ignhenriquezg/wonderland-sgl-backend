package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.CatalogoPersonaje;
import com.wonderland.sgl.service.CatalogoPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personajes")
@CrossOrigin(origins = "*")
public class CatalogoPersonajeController {
    @Autowired private CatalogoPersonajeService service;
    @GetMapping public List<CatalogoPersonaje> listar() { return service.obtenerTodos(); }
    @PostMapping public CatalogoPersonaje crear(@RequestBody CatalogoPersonaje personaje) { return service.crear(personaje); }
}