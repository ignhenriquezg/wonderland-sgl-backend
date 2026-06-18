package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.ChecklistTurno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ChecklistTurnoRepository extends JpaRepository<ChecklistTurno, Integer> {
    List<ChecklistTurno> findByTurno_IdTurno(Integer idTurno);
}