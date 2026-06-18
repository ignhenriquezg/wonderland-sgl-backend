package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.CatalogoTarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CatalogoTareaRepository extends JpaRepository<CatalogoTarea, Integer> {
    List<CatalogoTarea> findByRol_IdRol(Integer idRol);
}