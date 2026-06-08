package com.wonderland.sgl.exception;

import com.wonderland.sgl.dto.ErrorResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.NoSuchElementException;

@RestControllerAdvice(basePackages = "com.wonderland.sgl.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponseDTO> manejarRegistroNoEncontrado(NoSuchElementException ex) {
        ErrorResponseDTO error = new ErrorResponseDTO(
            "Registro no encontrado", 
            "El dato solicitado no existe en la base de datos."
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDTO> manejarErrorGeneral(Exception ex) {
        ex.printStackTrace(); 
        
        ErrorResponseDTO error = new ErrorResponseDTO(
            "Error interno del servidor", 
            ex.getMessage()
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}