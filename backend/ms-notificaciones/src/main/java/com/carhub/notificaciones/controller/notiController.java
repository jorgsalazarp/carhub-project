package com.carhub.notificaciones.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carhub.notificaciones.dto.notiRequest;
import com.carhub.notificaciones.service.notiService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/notificaciones")
@Tag(name = "Modulo de las notificaciones", description = "Endpoints para el envio de las notificaciones")
public class notiController {
    
    private final notiService service;

    public notiController(notiService service) {
        this.service = service;
    }

    @PostMapping("/enviar")
    @Operation(summary = "Enviar notificacion por email", description = "Es la simulacion del procesamiento y del envio de las alertas")
    @ApiResponse(responseCode = "200", description = "Notificacion enviada con exito")
    @ApiResponse(responseCode = "500", description = "Error en el envio de la notificación")
    public ResponseEntity<Map<String, Object>> enviarNotificacion(@RequestBody notiRequest request) {
        boolean exito = service.envioAlerta(request);

        if (exito) {
            return ResponseEntity.ok(Map.of("status", "Exito", "message", "Alerta despachada."));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(Map.of("status", "ERROR", "message", "No se pudo procesar la notificacion."));
        }
    }
    
}
