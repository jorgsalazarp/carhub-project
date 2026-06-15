package com.carhub.notificaciones.service;

import org.springframework.stereotype.Service;

import com.carhub.notificaciones.dto.notiRequest;
import com.carhub.notificaciones.model.notiModel;
import com.carhub.notificaciones.repository.notiRepository;

@Service
public class notiService {
    
    private final notiRepository repository;

    public notiService(notiRepository repository) {
        this.repository = repository;
    }

    public boolean envioAlerta(notiRequest request) {
        try {
            System.out.println("=============================");
            System.out.println("Enviando Email A:" + request.getDestinatario());
            System.out.println("Asunto: [" + request.getTipoCorreo() + "] - Orden" + request.getOrdenId());
            System.out.println("Cuerpo:" + request.getMensaje());
            System.out.println("=============================");

            notiModel historial = new notiModel();
            historial.setOrdenId(request.getOrdenId());
            historial.setDestinatarioCorreo(request.getDestinatario());
            historial.setTipoCorreo(request.getTipoCorreo());
            historial.setMensajeCorreo(request.getMensaje());
            historial.setEstadoCorreo("Enviado");

            repository.save(historial);
            return true;
        } catch (Exception e) {
            System.err.println("Error al enviar notificacion: " + e.getMessage());
            return false;
        }
    }
}
