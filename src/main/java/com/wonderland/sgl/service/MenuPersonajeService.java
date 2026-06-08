package com.wonderland.sgl.service;
import com.wonderland.sgl.model.MenuPersonaje;
import com.wonderland.sgl.repository.MenuPersonajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuPersonajeService {
    @Autowired private MenuPersonajeRepository repo;
    public List<MenuPersonaje> obtenerTodos() { return repo.findAll(); }
    public MenuPersonaje crear(MenuPersonaje menuPersonaje) { return repo.save(menuPersonaje); }
}