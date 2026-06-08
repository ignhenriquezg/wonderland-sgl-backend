package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.MenuPlato;
import com.wonderland.sgl.service.MenuPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu-platos")
@CrossOrigin(origins = "*")
public class MenuPlatoController {
    @Autowired private MenuPlatoService service;
    @GetMapping public List<MenuPlato> listar() { return service.obtenerTodos(); }
    @PostMapping public MenuPlato crear(@RequestBody MenuPlato menuPlato) { return service.crear(menuPlato); }
}