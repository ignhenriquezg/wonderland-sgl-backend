package com.wonderland.sgl.repository;

import com.wonderland.sgl.model.Insumo;
import com.wonderland.sgl.dto.InsumoEstructuralDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer> {

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Receta_Postre WHERE id_insumo = :id", nativeQuery = true)
    void desvincularDePostres(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Receta_Bebida WHERE id_insumo = :id", nativeQuery = true)
    void desvincularDeBebidas(@Param("id") Integer id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Receta_Plato WHERE id_insumo = :id", nativeQuery = true)
    void desvincularDePlatos(@Param("id") Integer id);

    // Consulta simplificada y optimizada que lee directo de tu nuevo cotizador por receta directa
    @Query(value = "SELECT mi.id_insumo AS idInsumo, i.nombre AS nombre, i.unidad_medida AS unidadMedida, i.stock_actual AS stockActual, (mi.cantidad_necesaria * :cantNinos) AS cantidadTotalRequerida " +
            "FROM Menu_Insumo mi " +
            "JOIN Insumo i ON mi.id_insumo = i.id_insumo " +
            "WHERE mi.id_menu = :idMenu", nativeQuery = true)
    List<InsumoEstructuralDTO> calcularRequerimientosReales(@Param("idMenu") Integer idMenu, @Param("cantNinos") Integer cantNinos);
}