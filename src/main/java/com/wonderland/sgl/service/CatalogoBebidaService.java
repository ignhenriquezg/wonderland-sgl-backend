package com.wonderland.sgl.service;
import com.wonderland.sgl.model.CatalogoBebida;
import com.wonderland.sgl.repository.CatalogoBebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CatalogoBebidaService {
    @Autowired private CatalogoBebidaRepository repo;
    public List<CatalogoBebida> obtenerTodas() { return repo.findAll(); }
    public CatalogoBebida crear(CatalogoBebida bebida) { return repo.save(bebida); }
}