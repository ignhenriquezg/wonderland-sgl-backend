package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.Insumo;
import com.wonderland.sgl.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/insumos")
@CrossOrigin(origins = "*")
public class InsumoController {
    @Autowired private InsumoService insumoService;
    @GetMapping public List<Insumo> listar() { return insumoService.obtenerTodos(); }
    @PostMapping public Insumo crear(@RequestBody Insumo insumo) { return insumoService.crearInsumo(insumo); }
    @DeleteMapping("/{id}") public void eliminar(@PathVariable Integer id) { insumoService.eliminar(id); }
}