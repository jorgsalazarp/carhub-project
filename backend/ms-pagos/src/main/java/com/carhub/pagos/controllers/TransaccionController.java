package com.carhub.pagos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carhub.pagos.pagos.models.Transaccion;
import com.carhub.pagos.pagos.service.TransaccionService;

@RestController
@RequestMapping("/api/pagos")
public class TransaccionController extends BaseController {

    @Autowired
    private TransaccionService service;

    @GetMapping
    public ResponseEntity<Object> listarPagos() {
        return generarRespuesta(HttpStatus.OK, "Pagos obtenidos con éxito", service.obtenerTodosLosPagos());
    }

    @PostMapping
    public ResponseEntity<Object> crearPago(@RequestBody Transaccion transaccion) {
        Transaccion nuevoPago = service.procesarPago(transaccion);
        return generarRespuesta(HttpStatus.CREATED, "Pago procesado exitosamente", nuevoPago);
    }
}
