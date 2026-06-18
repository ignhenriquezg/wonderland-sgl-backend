package com.wonderland.sgl.service;

import com.wonderland.sgl.model.TurnoOperativo;
import com.wonderland.sgl.repository.TurnoOperativoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Service
public class TurnoOperativoService {
    
    @Autowired 
    private TurnoOperativoRepository repo;
    
    public List<TurnoOperativo> obtenerTodos() { 
        return repo.findAll(); 
    }
    
    public TurnoOperativo crear(TurnoOperativo turno) { 
        return repo.save(turno); 
    }

    // Nuevo método: Motor de control de asistencia y manejo de archivos
    public TurnoOperativo responderAsistencia(Integer idTurno, String estado, String justificacion, MultipartFile archivo) {
        TurnoOperativo turno = repo.findById(idTurno)
                .orElseThrow(() -> new RuntimeException("Turno no encontrado"));
        
        turno.setEstadoAsistencia(estado);

        if ("RECHAZADO".equals(estado)) {
            // Lógica de validación de justificación
            if (justificacion == null || justificacion.trim().isEmpty()) {
                turno.setJustificacion("Injustificado");
            } else {
                turno.setJustificacion(justificacion);
            }

            // Lógica de guardado de archivo físico
            if (archivo != null && !archivo.isEmpty()) {
                try {
                    String uploadDir = System.getProperty("user.dir") + "/uploads/justificativos/";
                    File dir = new File(uploadDir);
                    if (!dir.exists()) {
                        dir.mkdirs(); // Crea la carpeta si no existe
                    }
                    
                    String fileName = System.currentTimeMillis() + "_" + archivo.getOriginalFilename();
                    Path filePath = Paths.get(uploadDir + fileName);
                    Files.copy(archivo.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
                    
                    turno.setRutaArchivo(fileName);
                } catch (IOException e) {
                    throw new RuntimeException("Error al guardar el archivo adjunto", e);
                }
            }
        }
        return repo.save(turno);
    }
}