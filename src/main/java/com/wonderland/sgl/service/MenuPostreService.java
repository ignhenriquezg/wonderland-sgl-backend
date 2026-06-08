package com.wonderland.sgl.service;
import com.wonderland.sgl.model.MenuPostre;
import com.wonderland.sgl.repository.MenuPostreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuPostreService {
    @Autowired private MenuPostreRepository repo;
    public List<MenuPostre> obtenerTodos() { return repo.findAll(); }
    public MenuPostre crear(MenuPostre menuPostre) { return repo.save(menuPostre); }
}