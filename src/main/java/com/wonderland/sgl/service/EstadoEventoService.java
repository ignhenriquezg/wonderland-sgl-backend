package com.wonderland.sgl.service;
import com.wonderland.sgl.model.EstadoEvento;
import com.wonderland.sgl.repository.EstadoEventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EstadoEventoService {
    @Autowired private EstadoEventoRepository repo;
    public List<EstadoEvento> obtenerTodos() { return repo.findAll(); }
    public EstadoEvento crear(EstadoEvento estado) { return repo.save(estado); }
}