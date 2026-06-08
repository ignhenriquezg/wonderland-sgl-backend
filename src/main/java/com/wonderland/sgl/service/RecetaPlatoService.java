package com.wonderland.sgl.service;
import com.wonderland.sgl.model.RecetaPlato;
import com.wonderland.sgl.repository.RecetaPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecetaPlatoService {
    @Autowired private RecetaPlatoRepository repo;
    public List<RecetaPlato> obtenerTodas() { return repo.findAll(); }
    public RecetaPlato crear(RecetaPlato receta) { return repo.save(receta); }
}