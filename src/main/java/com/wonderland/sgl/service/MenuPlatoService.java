package com.wonderland.sgl.service;
import com.wonderland.sgl.model.MenuPlato;
import com.wonderland.sgl.repository.MenuPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuPlatoService {
    @Autowired private MenuPlatoRepository repo;
    public List<MenuPlato> obtenerTodos() { return repo.findAll(); }
    public MenuPlato crear(MenuPlato menuPlato) { return repo.save(menuPlato); }
}