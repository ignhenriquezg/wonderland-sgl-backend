package com.wonderland.sgl.controller;
import com.wonderland.sgl.model.Cliente;
import com.wonderland.sgl.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@CrossOrigin(origins = "*")
public class ClienteController {
    @Autowired private ClienteService service;
    @GetMapping public List<Cliente> listar() { return service.obtenerTodos(); }
    @PostMapping public Cliente crear(@RequestBody Cliente cliente) { return service.crear(cliente); }
}