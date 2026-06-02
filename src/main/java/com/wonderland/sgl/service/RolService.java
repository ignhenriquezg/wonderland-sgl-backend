package com.wonderland.sgl.service;

import com.wonderland.sgl.model.Rol;
import com.wonderland.sgl.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RolService {
    
    @Autowired
    private RolRepository rolRepository;

    public List<Rol> obtenerTodosLosRoles() {
        return rolRepository.findAll();
    }


    public Rol crearRol(Rol nuevoRol) {
        return rolRepository.save(nuevoRol); 
    }
}