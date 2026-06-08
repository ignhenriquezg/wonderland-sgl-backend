package com.wonderland.sgl.service;
import com.wonderland.sgl.model.Usuario;
import com.wonderland.sgl.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioService {
    @Autowired private UsuarioRepository repo;
    public List<Usuario> obtenerTodos() { return repo.findAll(); }
    public Usuario crear(Usuario usuario) { return repo.save(usuario); }
}