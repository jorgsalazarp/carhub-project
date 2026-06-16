package com.example.ventas.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.ventas.service.ventaService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import java.util.Map;
import com.example.ventas.dto.ventaRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RequestMapping("/api/ventas")
@RestController
@Tag(name = "ventaController", description = "Controlador para gestionar las ventas")
public class ventaController {
    
    private final ventaService ventaService;
    
    public ventaController(ventaService ventaService) {
        this.ventaService = ventaService;
    }

    @PostMapping("/crearOrden") //se crea una orden de venta, generando un ID unico y guardandolo en la base de datos con estado "pendiente al pago".
    @Operation(summary = "Crear una orden de venta", description = "Creacion de una nueva orden de venta")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Venta creada con exito"),
        @ApiResponse(responseCode = "400", description = "Solicitud invalida"),
        @ApiResponse(responseCode = "500", description = "Error interno del servidor")
    })

    public ResponseEntity<Map<String, String>> crearVenta(@RequestBody ventaRequest ventaRequest){
        String ordenId = ventaService.crearVenta(ventaRequest);

        Map<String, String> respuesta = Map.of(
            "ordenId", ordenId,
            "mensaje", "Venta creada exitosamente",
            "estado", "pendiente al pago"
        );

        return ResponseEntity.ok(respuesta);
    }
    
}
