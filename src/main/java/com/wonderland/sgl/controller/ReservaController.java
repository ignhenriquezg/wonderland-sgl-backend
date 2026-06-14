package com.wonderland.sgl.controller;

import com.wonderland.sgl.model.Reserva;
import com.wonderland.sgl.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
@CrossOrigin(origins = "*")
public class ReservaController {

    @Autowired 
    private ReservaService service;

    @GetMapping 
    public List<Reserva> listar() { 
        return service.obtenerTodas(); 
    }

    @PostMapping 
    public Reserva crear(@RequestBody Reserva reserva) { 
        return service.crear(reserva); 
    }

    @PutMapping("/{id}")
    public Reserva actualizar(@PathVariable Integer id, @RequestBody Reserva reserva) {
        reserva.setIdReserva(id);
        return service.actualizar(reserva);
    }

    @DeleteMapping("/{id}") 
    public void eliminar(@PathVariable Integer id) { 
        service.eliminar(id); 
    }
}