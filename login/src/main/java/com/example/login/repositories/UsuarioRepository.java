package com.example.login.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<com.example.login.entities.Usuario, Long> {
    Optional<Usuario> findByNombreUsuario(String nombreUsuario);
}
