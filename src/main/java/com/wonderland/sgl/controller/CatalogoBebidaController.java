package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.CatalogoBebida;
import com.wonderland.sgl.service.CatalogoBebidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bebidas")
@CrossOrigin(origins = "*")
public class CatalogoBebidaController {
    @Autowired private CatalogoBebidaService service;
    @GetMapping public List<CatalogoBebida> listar() { return service.obtenerTodas(); }
    @PostMapping public CatalogoBebida crear(@RequestBody CatalogoBebida bebida) { return service.crear(bebida); }
}