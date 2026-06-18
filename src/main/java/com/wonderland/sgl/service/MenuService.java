package com.wonderland.sgl.service;

import com.wonderland.sgl.model.Menu;
import com.wonderland.sgl.model.Reserva;
import com.wonderland.sgl.repository.MenuRepository;
import com.wonderland.sgl.repository.ReservaRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {
    
    @Autowired 
    private MenuRepository repo;

    @Autowired
    private ReservaRepository reservaRepo;

    @Autowired
    private EntityManager entityManager;
    
    public List<Menu> obtenerTodos() { 
        return repo.findAll(); 
    }
    
    public Menu crear(Menu menu) { 
        if (menu.getInsumos() != null) {
            menu.getInsumos().forEach(insumoItem -> insumoItem.setMenu(menu));
        }
        return repo.save(menu); 
    }
    
    @Transactional
    public void eliminar(Integer id) {
        // 1. Validar si hay reservas V4 activas
        List<Reserva> reservasConEsteMenu = reservaRepo.findAll().stream()
                .filter(r -> r.getMenu() != null && r.getMenu().getIdMenu().equals(id))
                .collect(Collectors.toList());

        boolean tieneActivas = reservasConEsteMenu.stream()
                .anyMatch(r -> "PENDIENTE".equals(r.getEstado()) || "CONFIRMADA".equals(r.getEstado()));

        if (tieneActivas) {
            throw new RuntimeException("No se puede eliminar porque está siendo utilizado en una reserva activa.");
        }

        // 2. Borrar reservas canceladas/rechazadas que usen este menú
        for (Reserva r : reservasConEsteMenu) {
            reservaRepo.deleteById(r.getIdReserva());
        }

        // 3. Limpiar las tablas antiguas de la V1 (Platos, Bebidas, Postres, Personajes)
        repo.limpiarMenuPlato(id);
        repo.limpiarMenuBebida(id);
        repo.limpiarMenuPostre(id);
        repo.limpiarMenuPersonaje(id);

        // 4. NUEVO: Limpiar la tabla puente de la V7 que acabamos de crear
        entityManager.createNativeQuery("DELETE FROM Menu_Insumo WHERE id_menu = :id")
                .setParameter("id", id).executeUpdate();

        // 5. Limpiar TODO el rastro de Eventos antiguos asociados a este Menú
        // 5.1 Borrar Bitácoras de esos Eventos
        entityManager.createNativeQuery("DELETE FROM Bitacora WHERE id_evento IN (SELECT id_evento FROM Evento WHERE id_menu = :id)")
                .setParameter("id", id).executeUpdate();
        // 5.2 Borrar Turnos Operativos de esos Eventos
        entityManager.createNativeQuery("DELETE FROM Turno_Operativo WHERE id_evento IN (SELECT id_evento FROM Evento WHERE id_menu = :id)")
                .setParameter("id", id).executeUpdate();
        // 5.3 Borrar los Eventos en sí
        entityManager.createNativeQuery("DELETE FROM Evento WHERE id_menu = :id")
                .setParameter("id", id).executeUpdate();

        // 6. ¡Por fin! Borrar el menú.
        repo.deleteById(id); 
    }
}