package com.wonderland.sgl.service;
import com.wonderland.sgl.model.CatalogoPersonaje;
import com.wonderland.sgl.repository.CatalogoPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoPersonajeService {
    @Autowired private CatalogoPersonajeRepository repo;
    public List<CatalogoPersonaje> obtenerTodos() { return repo.findAll(); }
    public CatalogoPersonaje crear(CatalogoPersonaje personaje) { return repo.save(personaje); }
}