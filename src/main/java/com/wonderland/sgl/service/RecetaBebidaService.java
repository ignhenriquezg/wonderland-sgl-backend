package com.wonderland.sgl.service;
import com.wonderland.sgl.model.RecetaBebida;
import com.wonderland.sgl.repository.RecetaBebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecetaBebidaService {
    @Autowired private RecetaBebidaRepository repo;
    public List<RecetaBebida> obtenerTodas() { return repo.findAll(); }
    public RecetaBebida crear(RecetaBebida receta) { return repo.save(receta); }
}