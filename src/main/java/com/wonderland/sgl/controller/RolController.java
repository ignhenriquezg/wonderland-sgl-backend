package com.wonderland.sgl.controller;

import com.wonderland.sgl.model.Rol;
import com.wonderland.sgl.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/roles")
@CrossOrigin(origins = "*")
public class RolController {

    @Autowired
    private RolService rolService;

    @GetMapping
    public List<Rol> listarRoles() {
        return rolService.obtenerTodosLosRoles();
    }

    @PostMapping
    public Rol crear(@RequestBody Rol rol) {
        return rolService.crearRol(rol);
    }

    @DeleteMapping("/{id}") 
    public void eliminar(@PathVariable Integer id) { 
        rolService.eliminar(id); 
    }
}