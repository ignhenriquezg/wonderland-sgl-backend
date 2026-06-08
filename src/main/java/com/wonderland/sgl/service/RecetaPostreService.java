package com.wonderland.sgl.service;
import com.wonderland.sgl.model.RecetaPostre;
import com.wonderland.sgl.repository.RecetaPostreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecetaPostreService {
    @Autowired private RecetaPostreRepository repo;
    public List<RecetaPostre> obtenerTodas() { return repo.findAll(); }
    public RecetaPostre crear(RecetaPostre receta) { return repo.save(receta); }
}