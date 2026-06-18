package com.wonderland.sgl.dto;

import lombok.Data;

@Data
public class PersonalRegistroDTO {
    private String rut;
    private String nombres;
    private String apellidos;
    private String telefono;
    private Integer idRol;
    
    // Credenciales de acceso
    private String correo;
    private String password;
}