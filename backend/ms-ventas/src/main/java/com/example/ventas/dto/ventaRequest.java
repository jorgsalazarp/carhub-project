package com.example.ventas.dto;

import lombok.AllArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;

@AllArgsConstructor
@Schema(description = "Request para crear una venta")
public class ventaRequest {

    public ventaRequest() {
        
    }
    
    @Schema(description= "Id Cliente", example = "1")
    private String idCliente;

    @Schema(description= "Monto total transaccion", example= "10000")
    private Double montoTotal;

    @Schema(description= "Id del vehiculo", example= "1")
    private String idVehiculo;

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public void setMontoTotal(Double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }   
    
    public void setIdVehiculo(String idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public Double getMontoTotal() {
        return montoTotal;
    }
}
