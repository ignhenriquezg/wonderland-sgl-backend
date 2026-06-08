package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.RecetaPlato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecetaPlatoRepository extends JpaRepository<RecetaPlato, Integer> {List<RecetaPlato> findByPlatoIdPlato(Integer idPlato);}