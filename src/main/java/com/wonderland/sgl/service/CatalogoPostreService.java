package com.wonderland.sgl.service;
import com.wonderland.sgl.model.CatalogoPostre;
import com.wonderland.sgl.repository.CatalogoPostreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoPostreService {
    @Autowired private CatalogoPostreRepository repo;
    public List<CatalogoPostre> obtenerTodos() { return repo.findAll(); }
    public CatalogoPostre crear(CatalogoPostre postre) { return repo.save(postre); }
}