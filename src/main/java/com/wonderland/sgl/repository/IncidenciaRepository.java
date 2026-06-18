package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.Incidencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface IncidenciaRepository extends JpaRepository<Incidencia, Integer> {
    List<Incidencia> findByReserva_IdReserva(Integer idReserva);
}