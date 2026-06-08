package com.wonderland.sgl.service;
import com.wonderland.sgl.model.Evento;
import com.wonderland.sgl.repository.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {
    @Autowired private EventoRepository repo;
    public List<Evento> obtenerTodos() { return repo.findAll(); }
    public Evento crear(Evento evento) { return repo.save(evento); }
}