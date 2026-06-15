package com.loquendodev.carhub.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loquendodev.carhub.models.entity.Usuario;
import com.loquendodev.carhub.repository.UsuarioRepository;
import com.loquendodev.carhub.services.UsuarioService;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController //definicion de clase controladora.
@RequestMapping("/api/v1") //ruta base para acceder a los endpoints del controlador.
@CrossOrigin(origins = "http://localhost:4200") //endpoint del frontend, con los permisos para consumir servicios en el backend.


public class usuarioController extends baseController {

    private final UsuarioRepository usuarioRepository;

    usuarioController(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/usuarios") //se asigna la solicitud HTTP, usado para consultar o leer informacion de un recurso especifico (GET).
    public List<Usuario> listarUsuarios(){
        return usuarioService.obtenerUsuarios();
    }

    @GetMapping("/usuarios/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable("id") Integer id){
        return usuarioService.obtenerUsuarioPorId(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/usuarios/{id}") //Se usa para eliminar un recurso especifico (DELETE).
    public ResponseEntity<String> eliminarUsuarioPorId(@PathVariable("id") Integer id){
        boolean usuarioEliminado = usuarioService.eliminarUsuarioPorId(id);
        if (usuarioEliminado){
            return ResponseEntity.ok("Usuario eliminado");

        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("el usuario que se desea eliminar\ncon su id: "+id+" no ha sido encontrado");
        }
    }

    @PutMapping("/usuarios/{id}") //se usa para actualizar o para reemplazar un recurso existente (PUT).
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable("id") Integer id, @RequestBody Usuario usr)
    {
        return usuarioRepository.findById(id)
        .map(usuarioCreado -> {
            usuarioCreado.setNameUser(usr.getNameUser());
            usuarioCreado.setEmailUser(usr.getEmailUser());
            usuarioCreado.setPasswordUser(usr.getPasswordUser());
            usuarioCreado.setPhoneUser(usr.getPhoneUser());

            Usuario usuarioActualizado = usuarioRepository.save(usuarioCreado);
            return ResponseEntity.ok(usuarioActualizado);

        }).orElseGet(()-> ResponseEntity.notFound().build());
    }

    @PostMapping("/usuarios") //es usado para la creacion de un nuevo recurso (POST).
    public ResponseEntity<Usuario> crearUsuario(@RequestBody Usuario usr){
        Usuario usuarioCreado = usuarioService.guardarUsuario(usr);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCreado);
    }

}
