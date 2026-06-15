package com.carhub.notificaciones.model;

import java.time.LocalDateTime;
import lombok.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data
@Entity
@Table(name = "historial_notificaciones")
public class notiModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ordenId;
    private String destinatarioCorreo;
    private String tipoCorreo;
    private String estadoCorreo;

    @Column(length = 500)
    private String mensajeCorreo;

    private LocalDateTime fechaEnvio;

    @PrePersist
    protected void onCreate() {
        this.fechaEnvio = LocalDateTime.now();
    }
}
