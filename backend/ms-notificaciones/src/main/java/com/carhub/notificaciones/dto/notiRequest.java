package com.carhub.notificaciones.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO para la solicitud de notificaciones")
public class notiRequest {
    
    @Schema(description = "Id de la orden", example = "ORD-ABC12345")
    private String ordenId;

    @Schema(description = "Destinatario de la notificación", example = "cliente@ejemplo.com")
    private String destinatario;

    @Schema(description = "Tipo de notificacion", example = "Venta Confirmada", allowableValues = {"Venta Confirmada", "Pago Pendiente", "Pago Rechazado", "Pago Aceptado", "Orden Enviada", "Orden Entregada"})
    private String tipoCorreo;

    @Schema(description = "Mensaje notificacion", example = "Orden aprobada, Preparando para envio")
    private String mensaje;
}
