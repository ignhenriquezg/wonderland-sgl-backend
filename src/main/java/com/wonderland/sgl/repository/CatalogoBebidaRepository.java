package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.CatalogoBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoBebidaRepository extends JpaRepository<CatalogoBebida, Integer> {}