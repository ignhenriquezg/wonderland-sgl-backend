package com.wonderland.sgl.service;

import com.wonderland.sgl.model.Tematica;
import com.wonderland.sgl.repository.TematicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TematicaService {

    @Autowired
    private TematicaRepository tematicaRepository;

    public List<Tematica> obtenerTodas() {
        return tematicaRepository.findAll();
    }

    public Tematica crearTematica(Tematica tematica) {
        return tematicaRepository.save(tematica);
    }
}