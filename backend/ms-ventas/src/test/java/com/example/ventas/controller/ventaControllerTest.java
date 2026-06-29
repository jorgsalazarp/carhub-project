package com.example.ventas.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.ventas.dto.ventaRequest;
import com.example.ventas.repository.ventaRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ventaControllerTest {
    
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private ventaRepository repository;

    @Test
    void testCrearVenta() {

        //limpieza de base de datos
        repository.deleteAll();

        //preparacion del request
        ventaRequest request = new ventaRequest();
        request.setMontoTotal(100.0);

        //endpoint
        ResponseEntity<Map<String, String>> response = restTemplate.exchange(
            "/api/ventas/crearOrden",
            HttpMethod.POST,
            new HttpEntity<>(request),
            new ParameterizedTypeReference<Map<String, String>>(){}
        );

        //validacion de las respuestas del mapa 
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Map<String, String> body = response.getBody();
        assertNotNull(body);
        assertEquals("Venta creada exitosamente", body.get("mensaje"));
        assertEquals("Pendiente al pago", body.get("estado"));

        //es la solicitud de la orden, junto con el prefijo 
        String ordenId = body.get("ordenId");
        assertTrue(ordenId.startsWith("ORD-"));

        //validacion impacto en la BD
        assertEquals(1, repository.count());
        assertEquals(ordenId, repository.findAll().get(0).getOrdenId());

        //swagger leyendo el controller
        ResponseEntity<String> swaggerResponse = restTemplate.getForEntity("/api-docs", String.class);
        assertEquals(HttpStatus.OK, swaggerResponse.getStatusCode());
        assertTrue(swaggerResponse.getBody().contains("/api/ventas/crearOrden"));
    }
}
