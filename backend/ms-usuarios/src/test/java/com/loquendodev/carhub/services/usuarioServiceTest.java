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
public class usuarioServiceTest {
    
    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    public void testListarUsuarios() {
        Usuario user = new Usuario();
        user.setIdUser(1);
        user.setNameUser("Usuario Test");

        when(usuarioRepository.findAll()).thenReturn(Arrays.asList(user));

        List<Usuario> resultado = usuarioService.obtenerUsuarios();

        assertFalse(resultado.isEmpty());
        assertEquals(1, resultado.get(0).getIdUser());
        verify(usuarioRepository, times(1)).findAll();
    }
}
