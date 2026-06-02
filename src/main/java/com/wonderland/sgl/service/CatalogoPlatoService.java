package com.wonderland.sgl.service;
import com.wonderland.sgl.model.CatalogoPlato;
import com.wonderland.sgl.repository.CatalogoPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoPlatoService {
    @Autowired private CatalogoPlatoRepository repo;
    public List<CatalogoPlato> obtenerTodos() { return repo.findAll(); }
    public CatalogoPlato crear(CatalogoPlato plato) { return repo.save(plato); }
}