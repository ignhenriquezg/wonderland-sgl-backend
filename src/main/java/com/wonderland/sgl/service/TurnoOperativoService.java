package com.wonderland.sgl.service;
import com.wonderland.sgl.model.TurnoOperativo;
import com.wonderland.sgl.repository.TurnoOperativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TurnoOperativoService {
    @Autowired private TurnoOperativoRepository repo;
    public List<TurnoOperativo> obtenerTodos() { return repo.findAll(); }
    public TurnoOperativo crear(TurnoOperativo turno) { return repo.save(turno); }
}