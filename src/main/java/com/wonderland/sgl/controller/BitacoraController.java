package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.Bitacora;
import com.wonderland.sgl.service.BitacoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bitacora")
@CrossOrigin(origins = "*")
public class BitacoraController {
    @Autowired private BitacoraService service;
    @GetMapping public List<Bitacora> listar() { return service.obtenerTodas(); }
    @PostMapping public Bitacora crear(@RequestBody Bitacora bitacora) { return service.crear(bitacora); }
}