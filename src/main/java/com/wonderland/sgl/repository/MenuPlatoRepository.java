package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.MenuPlato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuPlatoRepository extends JpaRepository<MenuPlato, Integer> {List<MenuPlato> findByMenuIdMenu(Integer idMenu);}
