package com.example.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.login.entities.Usuario;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.List;

@RestController
public class Auth {

    private static List<Usuario> baseDeDatos = new ArrayList<Usuario>();

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public String registrarUsuario(@RequestBody Usuario usuario) {
        boolean existeUsuario = baseDeDatos.stream()
            .anyMatch(u -> u.getNombreUsuario().equals(usuario.getNombreUsuario()));

            if(existeUsuario) {
                return "El nombre de usuario ya existe. Elija otra opcion.";
            }

        usuario.setContraseñaUsuario(passwordEncoder.encode(usuario.getContraseñaUsuario()));
        usuario.setRole("ROLE_USER");

        baseDeDatos.add(usuario);
        return "Usuario registrado exitosamente." + baseDeDatos.size();
    }
    
}
