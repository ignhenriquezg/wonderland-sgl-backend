package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.MenuBebida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuBebidaRepository extends JpaRepository<MenuBebida, Integer> {List<MenuBebida> findByMenuIdMenu(Integer idMenu);}