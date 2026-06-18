package com.wonderland.sgl.service;

import com.wonderland.sgl.model.Cliente;
import com.wonderland.sgl.model.Reserva;
import com.wonderland.sgl.repository.ClienteRepository;
import com.wonderland.sgl.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClienteService {
    @Autowired private ClienteRepository repo;
    @Autowired private ReservaRepository reservaRepo;
    @Autowired private EntityManager entityManager;

    public List<Cliente> obtenerTodos() { return repo.findAll(); }
    public Cliente crear(Cliente cliente) { return repo.save(cliente); }

    @Transactional
    public void eliminar(Integer id) {
        // 1. Validar Reservas de la V4
        List<Reserva> reservas = reservaRepo.findAll().stream()
                .filter(r -> r.getCliente().getIdCliente().equals(id))
                .collect(Collectors.toList());

        boolean tieneActivas = reservas.stream()
                .anyMatch(r -> r.getEstado().equals("PENDIENTE") || r.getEstado().equals("CONFIRMADA"));

        if (tieneActivas) {
            throw new RuntimeException("El cliente tiene reservas activas.");
        }

        // 2. Borrar las reservas canceladas/rechazadas (V4)
        for (Reserva r : reservas) {
            reservaRepo.deleteById(r.getIdReserva());
        }

        // 3. Destruir amarras con Eventos de la V1 (Familia Silva, etc.)
        entityManager.createNativeQuery("DELETE FROM Bitacora WHERE id_evento IN (SELECT id_evento FROM Evento WHERE id_cliente = :id)")
                .setParameter("id", id).executeUpdate();
        entityManager.createNativeQuery("DELETE FROM Turno_Operativo WHERE id_evento IN (SELECT id_evento FROM Evento WHERE id_cliente = :id)")
                .setParameter("id", id).executeUpdate();
        entityManager.createNativeQuery("DELETE FROM Evento WHERE id_cliente = :id")
                .setParameter("id", id).executeUpdate();

        // 4. Borrar el cliente
        repo.deleteById(id);
    }
}