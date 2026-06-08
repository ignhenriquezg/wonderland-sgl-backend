package com.wonderland.sgl.service;
import com.wonderland.sgl.model.Bitacora;
import com.wonderland.sgl.repository.BitacoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BitacoraService {
    @Autowired private BitacoraRepository repo;
    public List<Bitacora> obtenerTodas() { return repo.findAll(); }
    public Bitacora crear(Bitacora bitacora) { return repo.save(bitacora); }
}