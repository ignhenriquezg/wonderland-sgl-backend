package com.wonderland.sgl.repository;

import com.wonderland.sgl.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
    // Recupera el método original que necesita AuthController para el Login
    Optional<Usuario> findByCorreo(String correo);

    // Mantiene el método de limpieza para evitar errores de llave foránea (FK) al eliminar personal
    @Modifying
    @Transactional
    @Query(value = "DELETE FROM Usuario WHERE id_personal = :idPersonal", nativeQuery = true)
    void eliminarPorPersonal(@Param("idPersonal") Integer idPersonal);

    // Agrega esta línea justo debajo de la que busca por correo:
    Optional<Usuario> findByPersonal_IdPersonal(Integer idPersonal);
}