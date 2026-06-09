package com.wonderland.sgl.service;
import com.wonderland.sgl.model.Insumo;
import com.wonderland.sgl.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class InsumoService {
    @Autowired private InsumoRepository insumoRepository;
    public List<Insumo> obtenerTodos() { return insumoRepository.findAll(); }
    public Insumo crearInsumo(Insumo insumo) { return insumoRepository.save(insumo); }
    public void eliminar(Integer id) { insumoRepository.deleteById(id); }
}