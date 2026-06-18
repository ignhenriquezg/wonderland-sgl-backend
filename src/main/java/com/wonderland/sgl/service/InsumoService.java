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
    
    public void eliminar(Integer id) {
        // 1. Limpiamos todas las tablas de recetas de la V1
        insumoRepository.desvincularDePostres(id);
        insumoRepository.desvincularDeBebidas(id);
        insumoRepository.desvincularDePlatos(id);
        
        // 2. Ahora que no pertenece a ninguna receta, se borra el insumo
        insumoRepository.deleteById(id);
    }
}