package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.RecetaBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecetaBebidaRepository extends JpaRepository<RecetaBebida, Integer> {}