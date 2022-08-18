package com.sena.LabData.controller;


import com.sena.LabData.dto.Mensaje;
import com.sena.LabData.dto.UsuarioDTO;
import com.sena.LabData.entity.UsuarioLab;
import com.sena.LabData.service.UsuarioLabService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/usuario")

@CrossOrigin(origins = "http://localhost:4200")

public class UsuarioLabController {

    @Autowired
    UsuarioLabService usuarioLabService;


    @GetMapping("/listaUsuarios")
    public ResponseEntity<List<UsuarioLab>> listaUsuarios() {

        List<UsuarioLab> usuarios = usuarioLabService.listaUsuario();
        return new ResponseEntity<List<UsuarioLab>>(usuarios, HttpStatus.OK);
    }

    @GetMapping("/detalleUsuario/{idUsuarioLab}")
    public ResponseEntity<UsuarioLab> usuarioById(@PathVariable("idUsuarioLab") int idUsuarioLab) {

        if (!usuarioLabService.existsByIdUsuario(idUsuarioLab))
            return new ResponseEntity(new Mensaje("No existe el usuario"), HttpStatus.NOT_FOUND);

        UsuarioLab usuarioLab = usuarioLabService.getUsuario(idUsuarioLab).get();
        return new ResponseEntity(usuarioLab, HttpStatus.OK);
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<?> creaUsuario(@RequestBody UsuarioDTO usuarioDTO) {


        UsuarioLab usuarioLab = new UsuarioLab(usuarioDTO.getId(),
                usuarioDTO.getNombre(),
                usuarioDTO.getApellido(),
                usuarioDTO.getDireccion(),
                usuarioDTO.getMovil(),
                usuarioDTO.getContrasena(),
                usuarioDTO.getCorreo(),
                usuarioDTO.getTipoUsuario(),
                usuarioDTO.getUsuario());

        usuarioLabService.saveUsuario(usuarioLab);
        return new ResponseEntity(new Mensaje("Usuario creado"), HttpStatus.OK);

    }

    @DeleteMapping("/eliminarUsuario/{idUsuarioLab}")
    public ResponseEntity<?> eliminarUsuario(@PathVariable("idUsuarioLab") int idUsuarioLab) {

        if (!usuarioLabService.existsByIdUsuario(idUsuarioLab))
            return new ResponseEntity(new Mensaje("No existe el usuario"), HttpStatus.NOT_FOUND);
        usuarioLabService.deleteUsuario(idUsuarioLab);
        return new ResponseEntity(new Mensaje("Usuario eliminado"), HttpStatus.OK);
    }

    @PutMapping("/actualizarUsuario/{idUsuarioLab}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable("idUsuarioLab") int idUsuarioLab, @RequestBody UsuarioDTO usuarioDTO) {


        if (!usuarioLabService.existsByIdUsuario(idUsuarioLab))
            return new ResponseEntity(new Mensaje("No existe el usuario"), HttpStatus.NOT_FOUND);

        UsuarioLab usuarioLab = usuarioLabService.getUsuario(idUsuarioLab).get();
        usuarioLab.setId(usuarioDTO.getId());
        usuarioLab.setNombre(usuarioDTO.getNombre());
        usuarioLab.setDireccion(usuarioDTO.getDireccion());
        usuarioLab.setMovil(usuarioDTO.getMovil());
        usuarioLab.setContrasena(usuarioDTO.getContrasena());
        usuarioLab.setCorreo(usuarioDTO.getCorreo());
        usuarioLab.setTipoUsuario(usuarioDTO.getTipoUsuario());
        usuarioLab.setUsuario(usuarioDTO.getUsuario());

        usuarioLabService.saveUsuario(usuarioLab);

        return new ResponseEntity(new Mensaje("Usuario actualizado"), HttpStatus.OK);
    }
    }
