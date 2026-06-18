package com.wonderland.sgl.service;

import com.wonderland.sgl.model.*;
import com.wonderland.sgl.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OperacionService {

    @Autowired private ChecklistTurnoRepository checklistRepo;
    @Autowired private CatalogoTareaRepository tareaRepo;
    @Autowired private TurnoOperativoRepository turnoRepo;
    @Autowired private IncidenciaRepository incidenciaRepo;
    @Autowired private ReservaRepository reservaRepo;
    @Autowired private PersonalRepository personalRepo;

    // --- LÓGICA DE CHECKLISTS ---

    @Transactional
    public List<ChecklistTurno> obtenerOGenerarChecklist(Integer idTurno) {
        List<ChecklistTurno> checklistExistente = checklistRepo.findByTurno_IdTurno(idTurno);
        if (!checklistExistente.isEmpty()) {
            return checklistExistente;
        }

        TurnoOperativo turno = turnoRepo.findById(idTurno)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
                
        Integer idRol = turno.getPersonal().getRol().getIdRol();
        List<CatalogoTarea> tareasDelRol = tareaRepo.findByRol_IdRol(idRol);

        for (CatalogoTarea tarea : tareasDelRol) {
            ChecklistTurno item = new ChecklistTurno();
            item.setTurno(turno);
            item.setTarea(tarea);
            item.setCompletada(false);
            checklistRepo.save(item);
        }

        return checklistRepo.findByTurno_IdTurno(idTurno);
    }

    public ChecklistTurno marcarTareaCompletada(Integer idChecklist) {
        ChecklistTurno item = checklistRepo.findById(idChecklist)
                .orElseThrow(() -> new RuntimeException("Item de checklist no encontrado"));
        
        item.setCompletada(true);
        item.setHoraCompletada(LocalDateTime.now());
        return checklistRepo.save(item);
    }

    // --- LÓGICA DE INCIDENCIAS (EMERGENCIAS) ---

    public Incidencia reportarIncidencia(Integer idReserva, Integer idPersonal, String descripcion) {
        Reserva reserva = reservaRepo.findById(idReserva)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        Personal personal = personalRepo.findById(idPersonal)
                .orElseThrow(() -> new RuntimeException("Personal no encontrado"));

        Incidencia incidencia = new Incidencia();
        incidencia.setReserva(reserva);
        incidencia.setPersonalReporta(personal);
        incidencia.setDescripcion(descripcion);
        incidencia.setHoraReporte(LocalDateTime.now());
        incidencia.setEstado("PENDIENTE");

        return incidenciaRepo.save(incidencia);
    }

    public List<Incidencia> obtenerIncidenciasPorReserva(Integer idReserva) {
        return incidenciaRepo.findByReserva_IdReserva(idReserva);
    }

    public Incidencia resolverIncidencia(Integer idIncidencia) {
        Incidencia incidencia = incidenciaRepo.findById(idIncidencia)
                .orElseThrow(() -> new RuntimeException("Incidencia no encontrada"));
        
        incidencia.setEstado("RESUELTA");
        incidencia.setHoraResolucion(LocalDateTime.now());
        return incidenciaRepo.save(incidencia);
    }

    // --- NUEVO: LÓGICA DE CIERRE DE EVENTO ---
    public void finalizarReserva(Integer idReserva) {
        Reserva reserva = reservaRepo.findById(idReserva)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
        reserva.setEstado("FINALIZADA");
        reservaRepo.save(reserva);
    }
}