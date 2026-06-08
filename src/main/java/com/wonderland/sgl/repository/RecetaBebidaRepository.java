package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.RecetaBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RecetaBebidaRepository extends JpaRepository<RecetaBebida, Integer> {List<RecetaBebida> findByBebidaIdBebida(Integer idBebida);}