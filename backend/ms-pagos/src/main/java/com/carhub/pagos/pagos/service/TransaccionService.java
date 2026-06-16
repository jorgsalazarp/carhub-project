package com.carhub.pagos.pagos.service;

import com.carhub.pagos.pagos.models.Transaccion;
import com.carhub.pagos.pagos.repository.TransaccionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TransaccionService {

    @Autowired
    private TransaccionRepository repository;

    public List<Transaccion> obtenerTodosLosPagos() {
        return repository.findAll();
    }

    public Transaccion procesarPago(Transaccion transaccion) {
        transaccion.setEstadoPago("APROBADO");
        return repository.save(transaccion);
    }
}
