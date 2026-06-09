package com.wonderland.sgl.service;
import com.wonderland.sgl.model.Menu;
import com.wonderland.sgl.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MenuService {
    @Autowired private MenuRepository repo;
    public List<Menu> obtenerTodos() { return repo.findAll(); }
    public Menu crear(Menu menu) { return repo.save(menu); }
    public void eliminar(Integer id) { repo.deleteById(id); }
}