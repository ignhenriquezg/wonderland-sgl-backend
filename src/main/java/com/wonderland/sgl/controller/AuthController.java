package com.wonderland.sgl.controller;

import com.wonderland.sgl.dto.LoginRequestDTO;
import com.wonderland.sgl.dto.LoginResponseDTO;
import com.wonderland.sgl.model.Usuario;
import com.wonderland.sgl.repository.UsuarioRepository;
import com.wonderland.sgl.security.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired private UsuarioRepository usuarioRepo;
    @Autowired private JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO request) {
        Usuario usuario = usuarioRepo.findByCorreo(request.getCorreo()).orElse(null);

        if (usuario != null && usuario.getPasswordHash().equals(request.getPassword())) {
            String token = jwtService.generarToken(usuario.getCorreo());
            return ResponseEntity.ok(new LoginResponseDTO(token));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Correo o contraseña incorrectos");
    }
}