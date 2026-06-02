package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.CatalogoPostre;
import com.wonderland.sgl.service.CatalogoPostreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/postres")
@CrossOrigin(origins = "*")
public class CatalogoPostreController {
    @Autowired private CatalogoPostreService service;
    @GetMapping public List<CatalogoPostre> listar() { return service.obtenerTodos(); }
    @PostMapping public CatalogoPostre crear(@RequestBody CatalogoPostre postre) { return service.crear(postre); }
}