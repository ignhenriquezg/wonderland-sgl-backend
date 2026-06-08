package com.wonderland.sgl.service;
import com.wonderland.sgl.model.Cliente;
import com.wonderland.sgl.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClienteService {
    @Autowired private ClienteRepository repo;
    public List<Cliente> obtenerTodos() { return repo.findAll(); }
    public Cliente crear(Cliente cliente) { return repo.save(cliente); }
}