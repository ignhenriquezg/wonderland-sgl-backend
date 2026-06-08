package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.MenuPostre;
import com.wonderland.sgl.service.MenuPostreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menu-postres")
@CrossOrigin(origins = "*")
public class MenuPostreController {
    @Autowired private MenuPostreService service;
    @GetMapping public List<MenuPostre> listar() { return service.obtenerTodos(); }
    @PostMapping public MenuPostre crear(@RequestBody MenuPostre menuPostre) { return service.crear(menuPostre); }
}