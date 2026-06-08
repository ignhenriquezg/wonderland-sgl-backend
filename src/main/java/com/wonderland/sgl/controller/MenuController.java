package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.Menu;
import com.wonderland.sgl.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/menus")
@CrossOrigin(origins = "*")
public class MenuController {
    @Autowired private MenuService service;
    @GetMapping public List<Menu> listar() { return service.obtenerTodos(); }
    @PostMapping public Menu crear(@RequestBody Menu menu) { return service.crear(menu); }
}