package com.wonderland.sgl.service;
import com.wonderland.sgl.model.MenuBebida;
import com.wonderland.sgl.repository.MenuBebidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuBebidaService {
    @Autowired private MenuBebidaRepository repo;
    public List<MenuBebida> obtenerTodos() { return repo.findAll(); }
    public MenuBebida crear(MenuBebida menuBebida) { return repo.save(menuBebida); }
}