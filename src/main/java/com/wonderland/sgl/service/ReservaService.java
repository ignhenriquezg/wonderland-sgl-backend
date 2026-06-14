package com.wonderland.sgl.service;

import com.wonderland.sgl.model.Reserva;
import com.wonderland.sgl.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaService {

    @Autowired 
    private ReservaRepository repository;

    public List<Reserva> obtenerTodas() { 
        return repository.findAll(); 
    }

    public Reserva crear(Reserva reserva) { 
        return repository.save(reserva); 
    }

    // Nuevo método para que el Admin pueda cambiar el estado de la reserva
    public Reserva actualizar(Reserva reserva) {
        return repository.save(reserva);
    }

    public void eliminar(Integer id) { 
        repository.deleteById(id); 
    }
}