package com.carhub.bff.bff.controllers;

import com.carhub.bff.bff.service.BffOrquestadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bff/api")
@CrossOrigin(origins = "*")
public class BffGatewayController {
    @Autowired
    private BffOrquestadorService orquestadorService;

    @GetMapping("/dashboard/usuarios")
    public ResponseEntity<Object> obtenerResumenUsuarios() {
        Object respuestaDeUsuarios = orquestadorService.obtenerUsuariosDesdeMicroservicio();
        return ResponseEntity.ok(respuestaDeUsuarios);
    }
}
