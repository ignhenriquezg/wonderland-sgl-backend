package com.wonderland.sgl.controller;

import com.wonderland.sgl.model.Evento;
import com.wonderland.sgl.dto.ReservaRequestDTO;
import com.wonderland.sgl.dto.ResumenReservaDTO;
import com.wonderland.sgl.service.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/eventos")
@CrossOrigin(origins = "*")
public class EventoController {

    @Autowired private EventoService service;

    @GetMapping 
    public List<Evento> listar() { return service.obtenerTodos(); }

    @PostMapping 
    public Evento crear(@RequestBody Evento evento) { return service.crear(evento); }

    @PostMapping("/reservar")
    public ResumenReservaDTO hacerReserva(@RequestBody ReservaRequestDTO request) {
        return service.procesarNuevaReserva(request);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Integer id) {
        service.eliminar(id);
    }
}