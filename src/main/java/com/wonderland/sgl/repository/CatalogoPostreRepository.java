package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.CatalogoPostre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogoPostreRepository extends JpaRepository<CatalogoPostre, Integer> {}