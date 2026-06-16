package com.example.ventas.service;

import java.util.UUID;

import com.example.ventas.model.ventaModel;
import org.springframework.stereotype.Service;
import com.example.ventas.repository.ventaRepository;
import com.example.ventas.dto.ventaRequest;

@Service
public class ventaService {

    private final ventaRepository ventaRepository;

    public ventaService(ventaRepository ventaRepository) {
        this.ventaRepository = ventaRepository;
    }

    public String procesoVenta(ventaRequest request) {
        String ordenId = "ORD-" +UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        
        ventaModel venta = new ventaModel();
        venta.setOrdenId(ordenId);
        venta.setClienteId(null);
        venta.setMontoTotal(request.getMontoTotal());


        ventaRepository.save(venta);
        return ordenId;
    }

    public String crearVenta(ventaRequest ventaRequest) {
        return this.procesoVenta(ventaRequest);
    }

}