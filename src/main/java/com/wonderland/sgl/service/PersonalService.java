package com.wonderland.sgl.service;

import com.wonderland.sgl.dto.PersonalRegistroDTO;
import com.wonderland.sgl.model.Personal;
import com.wonderland.sgl.model.Rol;
import com.wonderland.sgl.model.Usuario;
import com.wonderland.sgl.repository.PersonalRepository;
import com.wonderland.sgl.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PersonalService {
    
    @Autowired 
    private PersonalRepository repository;
    
    @Autowired 
    private UsuarioRepository usuarioRepository;
    
    public List<Personal> obtenerTodos() { 
        return repository.findAll(); 
    }
    
    @Transactional
    public Personal crearConUsuario(PersonalRegistroDTO dto) { 
        // 1. Crear el registro del empleado (Personal)
        Personal personal = new Personal();
        personal.setRut(dto.getRut());
        personal.setNombres(dto.getNombres());
        personal.setApellidos(dto.getApellidos());
        personal.setTelefono(dto.getTelefono());
        
        Rol rol = new Rol();
        rol.setIdRol(dto.getIdRol());
        personal.setRol(rol);
        
        Personal personalGuardado = repository.save(personal);
        
        // 2. Si el Admin le asignó correo y contraseña, creamos su credencial de acceso (Usuario)
        if (dto.getCorreo() != null && !dto.getCorreo().isEmpty() && dto.getPassword() != null && !dto.getPassword().isEmpty()) {
            Usuario usuario = new Usuario();
            usuario.setPersonal(personalGuardado);
            usuario.setCorreo(dto.getCorreo());
            usuario.setPasswordHash(dto.getPassword()); // Más adelante aquí podemos aplicar BCrypt para mayor seguridad
            usuarioRepository.save(usuario);
        }
        
        return personalGuardado;
    }
    
    @Transactional
    public void eliminar(Integer id) { 
        // Primero borramos sus credenciales de acceso para evitar el bloqueo de MySQL (Foreign Key)
        usuarioRepository.eliminarPorPersonal(id);
        // Luego borramos el registro físico del empleado
        repository.deleteById(id); 
    }
}