package com.wonderland.sgl.dto;
import lombok.Data;

@Data
public class LoginResponseDTO {
    private String token;
    private String rol;
    private Integer idPersonal;

    public LoginResponseDTO(String token, String rol, Integer idPersonal) { 
        this.token = token; 
        this.rol = rol;
        this.idPersonal = idPersonal;
    }
}