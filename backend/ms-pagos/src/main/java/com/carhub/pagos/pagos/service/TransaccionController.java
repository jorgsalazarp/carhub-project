package com.carhub.pagos.pagos.controllers;

import com.carhub.pagos.pagos.models.Transaccion;
import com.carhub.pagos.pagos.service.TransaccionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
