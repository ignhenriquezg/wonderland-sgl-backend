package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.Tematica;
import com.wonderland.sgl.service.TematicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/tematicas")
@CrossOrigin(origins = "*")
public class TematicaController {
    @Autowired private TematicaService tematicaService;
    @GetMapping public List<Tematica> listar() { return tematicaService.obtenerTodas(); }
    @PostMapping public Tematica crear(@RequestBody Tematica tematica) { return tematicaService.crearTematica(tematica); }
    @DeleteMapping("/{id}") public void eliminar(@PathVariable Integer id) { tematicaService.eliminar(id); }
}