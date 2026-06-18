package com.wonderland.sgl.repository;

import com.wonderland.sgl.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Menu_Plato WHERE id_menu = :idMenu", nativeQuery = true)
    void limpiarMenuPlato(@Param("idMenu") Integer idMenu);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Menu_Bebida WHERE id_menu = :idMenu", nativeQuery = true)
    void limpiarMenuBebida(@Param("idMenu") Integer idMenu);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Menu_Postre WHERE id_menu = :idMenu", nativeQuery = true)
    void limpiarMenuPostre(@Param("idMenu") Integer idMenu);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Menu_Personaje WHERE id_menu = :idMenu", nativeQuery = true)
    void limpiarMenuPersonaje(@Param("idMenu") Integer idMenu);
}