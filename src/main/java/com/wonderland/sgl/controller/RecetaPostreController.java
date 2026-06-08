package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.RecetaPostre;
import com.wonderland.sgl.service.RecetaPostreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/receta-postres")
@CrossOrigin(origins = "*")
public class RecetaPostreController {
    @Autowired private RecetaPostreService service;
    @GetMapping public List<RecetaPostre> listar() { return service.obtenerTodas(); }
    @PostMapping public RecetaPostre crear(@RequestBody RecetaPostre receta) { return service.crear(receta); }
}