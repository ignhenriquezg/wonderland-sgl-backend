package com.wonderland.sgl.repository;
import com.wonderland.sgl.model.MenuPostre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MenuPostreRepository extends JpaRepository<MenuPostre, Integer> {List<MenuPostre> findByMenuIdMenu(Integer idMenu);}