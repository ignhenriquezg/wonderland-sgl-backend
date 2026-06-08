package com.wonderland.sgl.service;

import com.wonderland.sgl.model.*;
import com.wonderland.sgl.repository.*;
import com.wonderland.sgl.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EventoService {

    @Autowired private EventoRepository repo;
    @Autowired private ClienteRepository clienteRepo;
    @Autowired private MenuRepository menuRepo;
    @Autowired private EstadoEventoRepository estadoRepo;
    
    @Autowired private CalculadoraLogisticaService calculadoraService;

    public List<Evento> obtenerTodos() { return repo.findAll(); }
    public Evento crear(Evento evento) { return repo.save(evento); }

    public ResumenReservaDTO procesarNuevaReserva(ReservaRequestDTO request) {
        Cliente cliente = clienteRepo.findById(request.getIdCliente()).orElseThrow();
        Menu menu = menuRepo.findById(request.getIdMenu()).orElseThrow();
        
        EstadoEvento estadoPendiente = estadoRepo.findById(1).orElseThrow(); 

        Evento nuevoEvento = new Evento();
        nuevoEvento.setCliente(cliente);
        nuevoEvento.setMenu(menu);
        nuevoEvento.setEstado(estadoPendiente);
        nuevoEvento.setFechaEvento(request.getFechaEvento());
        nuevoEvento.setCantNinos(request.getCantNinos());

        Evento eventoGuardado = repo.save(nuevoEvento);

        List<InsumoCalculadoDTO> insumos = calculadoraService.calcularInsumosParaEvento(menu.getIdMenu(), request.getCantNinos());
        List<StaffRequeridoDTO> staff = calculadoraService.calcularStaffParaEvento(menu.getIdMenu(), request.getCantNinos());

        return new ResumenReservaDTO(
            "Reserva creada exitosamente para " + cliente.getNombre(),
            eventoGuardado.getIdEvento(),
            insumos,
            staff
        );
    }

    public void eliminar(Integer id) {
        repo.deleteById(id);
    }
}