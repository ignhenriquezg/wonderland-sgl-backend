package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.EstadoEvento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoEventoRepository extends JpaRepository<EstadoEvento, Integer> {}