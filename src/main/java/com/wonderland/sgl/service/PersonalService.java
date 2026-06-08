package com.wonderland.sgl.service;
import com.wonderland.sgl.model.Personal;
import com.wonderland.sgl.repository.PersonalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonalService {
    @Autowired private PersonalRepository repo;
    public List<Personal> obtenerTodos() { return repo.findAll(); }
    public Personal crear(Personal personal) { return repo.save(personal); }
}