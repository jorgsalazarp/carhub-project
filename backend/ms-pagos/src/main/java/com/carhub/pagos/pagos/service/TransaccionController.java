package com.carhub.pagos.pagos.service;

import com.carhub.pagos.pagos.models.Transaccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/pagos")
public class TransaccionController {

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

    private ResponseEntity<Object> generarRespuesta(HttpStatus status, String mensaje, Object datos) {
        Map<String, Object> body = new HashMap<>();
        body.put("status", status.value());
        body.put("mensaje", mensaje);
        body.put("datos", datos);
        return new ResponseEntity<>(body, status);
    }
}
