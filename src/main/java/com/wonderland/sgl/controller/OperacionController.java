package com.wonderland.sgl.controller;

import com.wonderland.sgl.model.ChecklistTurno;
import com.wonderland.sgl.model.Incidencia;
import com.wonderland.sgl.service.OperacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/operaciones")
@CrossOrigin(origins = "*")
public class OperacionController {

    @Autowired private OperacionService service;

    // --- RUTAS DE CHECKLIST ---
    @GetMapping("/turnos/{idTurno}/checklist")
    public List<ChecklistTurno> obtenerChecklist(@PathVariable Integer idTurno) {
        return service.obtenerOGenerarChecklist(idTurno);
    }

    @PutMapping("/checklist/{idChecklist}/completar")
    public ChecklistTurno completarTarea(@PathVariable Integer idChecklist) {
        return service.marcarTareaCompletada(idChecklist);
    }

    // --- RUTAS DE INCIDENCIAS ---
    @GetMapping("/reservas/{idReserva}/incidencias")
    public List<Incidencia> listarIncidencias(@PathVariable Integer idReserva) {
        return service.obtenerIncidenciasPorReserva(idReserva);
    }

    @PostMapping("/incidencias")
    public Incidencia reportarIncidencia(@RequestBody Map<String, Object> payload) {
        Integer idReserva = Integer.valueOf(payload.get("idReserva").toString());
        Integer idPersonal = Integer.valueOf(payload.get("idPersonal").toString());
        String descripcion = payload.get("descripcion").toString();
        return service.reportarIncidencia(idReserva, idPersonal, descripcion);
    }

    @PutMapping("/incidencias/{idIncidencia}/resolver")
    public Incidencia resolverIncidencia(@PathVariable Integer idIncidencia) {
        return service.resolverIncidencia(idIncidencia);
    }

    // --- NUEVO: RUTA DE CIERRE DE EVENTO ---
    @PutMapping("/reservas/{idReserva}/finalizar")
    public ResponseEntity<?> finalizarReserva(@PathVariable Integer idReserva) {
        service.finalizarReserva(idReserva);
        return ResponseEntity.ok().body("{\"mensaje\": \"Reserva finalizada con éxito\"}");
    }
}