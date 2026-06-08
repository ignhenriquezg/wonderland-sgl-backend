package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.MenuPlato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuPlatoRepository extends JpaRepository<MenuPlato, Integer> {}