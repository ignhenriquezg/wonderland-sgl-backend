package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.MenuPersonaje;
import com.wonderland.sgl.service.MenuPersonajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu-personajes")
@CrossOrigin(origins = "*")
public class MenuPersonajeController {
    @Autowired private MenuPersonajeService service;
    @GetMapping public List<MenuPersonaje> listar() { return service.obtenerTodos(); }
    @PostMapping public MenuPersonaje crear(@RequestBody MenuPersonaje menuPersonaje) { return service.crear(menuPersonaje); }
}