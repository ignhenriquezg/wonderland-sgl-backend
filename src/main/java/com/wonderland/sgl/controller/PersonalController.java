package com.wonderland.sgl.controller;

import com.wonderland.sgl.dto.PersonalRegistroDTO;
import com.wonderland.sgl.model.Personal;
import com.wonderland.sgl.service.PersonalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/personal")
@CrossOrigin(origins = "*")
public class PersonalController {
    
    @Autowired 
    private PersonalService service;
    
    @GetMapping 
    public List<Personal> listar() { 
        return service.obtenerTodos(); 
    }
    
    @PostMapping 
    public Personal crear(@RequestBody PersonalRegistroDTO dto) { 
        return service.crearConUsuario(dto); 
    }
    
    @DeleteMapping("/{id}") 
    public void eliminar(@PathVariable Integer id) { 
        service.eliminar(id); 
    }
}