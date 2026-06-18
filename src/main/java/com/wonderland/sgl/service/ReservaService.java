package com.wonderland.sgl.service;

import com.wonderland.sgl.dto.InsumoEstructuralDTO;
import com.wonderland.sgl.model.Reserva;
import com.wonderland.sgl.repository.InsumoRepository;
import com.wonderland.sgl.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ReservaService {

    @Autowired 
    private ReservaRepository repository;

    @Autowired
    private InsumoRepository insumoRepository;

    public List<Reserva> obtenerTodas() { 
        return repository.findAll(); 
    }

    public Reserva crear(Reserva reserva) { 
        return repository.save(reserva); 
    }

    public Reserva actualizar(Reserva reserva) {
        if ("CONFIRMADA".equals(reserva.getEstado()) && reserva.getMenu() != null) {
            List<InsumoEstructuralDTO> requerimientos = insumoRepository.calcularRequerimientosReales(
                    reserva.getMenu().getIdMenu(), 
                    reserva.getCantidadNinos()
            );

            for (InsumoEstructuralDTO req : requerimientos) {
                insumoRepository.findById(req.getIdInsumo()).ifPresent(insumo -> {
                    double nuevoStock = insumo.getStockActual() - req.getCantidadTotalRequerida();
                    insumo.setStockActual(nuevoStock < 0 ? 0.0 : nuevoStock);
                    insumoRepository.save(insumo);
                });
            }
        }
        return repository.save(reserva);
    }

    public void eliminar(Integer id) { 
        repository.deleteById(id); 
    }
}