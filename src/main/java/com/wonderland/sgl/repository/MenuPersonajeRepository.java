package com.wonderland.sgl.repository;

import com.wonderland.sgl.model.MenuPersonaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuPersonajeRepository extends JpaRepository<MenuPersonaje, Integer> {
    List<MenuPersonaje> findByMenuIdMenu(Integer idMenu);
}