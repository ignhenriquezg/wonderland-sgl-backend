package com.wonderland.sgl.controller;

import com.wonderland.sgl.dto.PerfilUpdateDTO;
import com.wonderland.sgl.model.Usuario;
import com.wonderland.sgl.service.UsuarioService;
import com.wonderland.sgl.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {
    
    @Autowired private UsuarioService service;
    @Autowired private UsuarioRepository usuarioRepo; // Agregado para poder actualizar el perfil

    // --- RUTAS ORIGINALES ---
    
    @GetMapping 
    public List<Usuario> listar() { 
        return service.obtenerTodos(); 
    }
    
    @PostMapping 
    public Usuario crear(@RequestBody Usuario usuario) { 
        return service.crear(usuario); 
    }

    // --- NUEVAS RUTAS PARA EL PERFIL DEL STAFF ---

    // Obtener el correo actual del empleado para mostrarlo en el Modal
    @GetMapping("/perfil/{idPersonal}")
    public ResponseEntity<?> obtenerPerfil(@PathVariable Integer idPersonal) {
        Optional<Usuario> usuarioOpt = usuarioRepo.findByPersonal_IdPersonal(idPersonal);
        if (usuarioOpt.isPresent()) {
            return ResponseEntity.ok(usuarioOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Actualizar correo y contraseña
    @PutMapping("/perfil/{idPersonal}")
    public ResponseEntity<?> actualizarPerfil(@PathVariable Integer idPersonal, @RequestBody PerfilUpdateDTO dto) {
        Optional<Usuario> usuarioOpt = usuarioRepo.findByPersonal_IdPersonal(idPersonal);
        
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            
            // Solo actualizamos si el usuario escribió algo nuevo
            if (dto.getCorreo() != null && !dto.getCorreo().trim().isEmpty()) {
                usuario.setCorreo(dto.getCorreo());
            }
            if (dto.getPassword() != null && !dto.getPassword().trim().isEmpty()) {
                usuario.setPasswordHash(dto.getPassword()); // En el futuro aquí idealmente va un encriptado BCrypt
            }
            
            usuarioRepo.save(usuario);
            return ResponseEntity.ok().body("{\"mensaje\": \"Perfil actualizado correctamente\"}");
        }
        return ResponseEntity.notFound().build();
    }
}