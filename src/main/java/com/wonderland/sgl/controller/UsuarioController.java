package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.Usuario;
import com.wonderland.sgl.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    @Autowired private UsuarioService service;
    @GetMapping public List<Usuario> listar() { return service.obtenerTodos(); }
    @PostMapping public Usuario crear(@RequestBody Usuario usuario) { return service.crear(usuario); }
}