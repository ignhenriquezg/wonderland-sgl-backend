package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.TurnoOperativo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoOperativoRepository extends JpaRepository<TurnoOperativo, Integer> {}