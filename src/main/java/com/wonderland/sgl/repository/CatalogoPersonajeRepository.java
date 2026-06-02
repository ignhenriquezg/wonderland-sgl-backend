package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.CatalogoPersonaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoPersonajeRepository extends JpaRepository<CatalogoPersonaje, Integer> {}