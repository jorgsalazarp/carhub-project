package com.example.ventas.repository;

import com.example.ventas.model.ventaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;


public interface ventaRepository extends JpaRepository<ventaModel, Long> {
    Optional<ventaModel> findByOrdenId(String ordenId);
}