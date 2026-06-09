package com.wonderland.sgl.service;

import com.wonderland.sgl.model.Personal;
import com.wonderland.sgl.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonalService {
    @Autowired private PersonalRepository repository;
    
    public List<Personal> obtenerTodos() { return repository.findAll(); }
    public Personal crear(Personal personal) { return repository.save(personal); }
    public void eliminar(Integer id) { repository.deleteById(id); }
}