package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.CatalogoPlato;
import com.wonderland.sgl.service.CatalogoPlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/platos")
@CrossOrigin(origins = "*")
public class CatalogoPlatoController {
    @Autowired private CatalogoPlatoService service;
    @GetMapping public List<CatalogoPlato> listar() { return service.obtenerTodos(); }
    @PostMapping public CatalogoPlato crear(@RequestBody CatalogoPlato plato) { return service.crear(plato); }
}