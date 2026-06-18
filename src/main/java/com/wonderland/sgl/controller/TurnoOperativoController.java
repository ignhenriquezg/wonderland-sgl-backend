package com.wonderland.sgl.controller;

import com.wonderland.sgl.model.TurnoOperativo;
import com.wonderland.sgl.service.TurnoOperativoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/turnos")
@CrossOrigin(origins = "*")
public class TurnoOperativoController {
    
    @Autowired 
    private TurnoOperativoService service;
    
    @GetMapping 
    public List<TurnoOperativo> listar() { 
        return service.obtenerTodos(); 
    }
    
    @PostMapping 
    public TurnoOperativo crear(@RequestBody TurnoOperativo turno) { 
        return service.crear(turno); 
    }

    // Ruta para que el Staff responda y suba su justificativo
    @PutMapping("/{id}/asistencia")
    public TurnoOperativo responderAsistencia(
            @PathVariable Integer id,
            @RequestParam("estado") String estado,
            @RequestParam(value = "justificacion", required = false) String justificacion,
            @RequestParam(value = "archivo", required = false) MultipartFile archivo) {
        
        return service.responderAsistencia(id, estado, justificacion, archivo);
    }

    // Ruta para que el Administrador pueda ver/descargar el archivo adjunto
    @GetMapping("/archivos/{fileName}")
    public ResponseEntity<Resource> obtenerArchivo(@PathVariable String fileName) {
        try {
            Path filePath = Paths.get(System.getProperty("user.dir") + "/uploads/justificativos/" + fileName);
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists() || resource.isReadable()) {
                return ResponseEntity.ok()
                        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                        .body(resource);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}