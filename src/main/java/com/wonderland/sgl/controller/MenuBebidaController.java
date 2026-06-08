package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.MenuBebida;
import com.wonderland.sgl.service.MenuBebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu-bebidas")
@CrossOrigin(origins = "*")
public class MenuBebidaController {
    @Autowired private MenuBebidaService service;
    @GetMapping public List<MenuBebida> listar() { return service.obtenerTodos(); }
    @PostMapping public MenuBebida crear(@RequestBody MenuBebida menuBebida) { return service.crear(menuBebida); }
}