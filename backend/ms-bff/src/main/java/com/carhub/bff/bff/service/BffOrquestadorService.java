package com.carhub.bff.bff.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BffOrquestadorService {
    @Autowired
    private RestTemplate restTemplate;

    public Object obtenerUsuariosDesdeMicroservicio() {
        String urlMsUsuarios = "http://localhost:8085/usuarios";
        return restTemplate.getForObject(urlMsUsuarios, Object.class);
    }
}
