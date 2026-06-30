package com.loquendodev.carhub.services;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.loquendodev.carhub.models.entity.Usuario;
import com.loquendodev.carhub.repository.UsuarioRepository;

@ExtendWith(MockitoExtension.class)
public class ventaServiceTest {
    
    @Mock
    private ventaRepository repository;

    @InjectMocks
    private ventaService service;

    @Test
    public void testListarVentas() {
        Venta venta = new Venta();
        venta.setIdVenta(1);

        when(repository.findAll()).thenReturn(Arrays.asList(venta));

        List<Venta> resultado = service.obtenerVentas();

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.get(0).getIdVenta());
        verify(repository, times(1).findAll());
    }
}
