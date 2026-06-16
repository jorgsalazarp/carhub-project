package com.carhub.pagos.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseController {
    protected ResponseEntity<Object> generarRespuesta(HttpStatus status, String mensaje, Object data) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status.value());
        map.put("mensaje", mensaje);
        map.put("data", data);
        return new ResponseEntity<>(map, status);
    }
}
