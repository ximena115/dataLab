package com.sena.LabData.controller;

import com.sena.LabData.dto.CasoDTO;
import com.sena.LabData.dto.Mensaje;
import com.sena.LabData.entity.Caso;
import com.sena.LabData.entity.UsuarioLab;
import com.sena.LabData.service.CasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/caso")

@CrossOrigin(origins = "http://localhost:4200")
public class CasoController {

    @Autowired
    CasoService casoService;

    @GetMapping("/listaCasos")
    public ResponseEntity<List<Caso>> listaCaso(){
        List<Caso> casos = casoService.listaCaso();
        return new ResponseEntity<List<Caso>>(casos, HttpStatus.OK);
    }

    @GetMapping("/detalleCaso/{idCaso}")
    public ResponseEntity<Caso> CasoById(@PathVariable("idCaso") int idCaso){

        if (!casoService.existsByIdCaso(idCaso))
            return new ResponseEntity(new Mensaje("No existe el caso"), HttpStatus.NOT_FOUND);

        Caso caso = casoService.getCaso(idCaso).get();
        return new ResponseEntity(caso, HttpStatus.OK);
    }

    @PostMapping("/crearCaso")
    public ResponseEntity<?> creaCaso(@RequestBody CasoDTO casoDTO, @AuthenticationPrincipal UsuarioLab usuarioLab){
        System.out.println (usuarioLab.getId());

        Caso caso = new Caso(casoDTO.getId(),
                casoDTO.getNombrePte(),
                casoDTO.getNumeroOrden(),
                casoDTO.getIdPte(),
                casoDTO.getRegistro(),
                casoDTO.getAntagonista(),
                usuarioLab);

        casoService.saveCaso(caso);
        return new ResponseEntity(new Mensaje("Caso creado"), HttpStatus.OK);

    }

    @DeleteMapping("/eliminarCaso/{idCaso}")
    public ResponseEntity<?> eliminarCaso(@PathVariable("idCaso") int idCaso) {

        if (!casoService.existsByIdCaso(idCaso))
            return new ResponseEntity(new Mensaje("No existe el caso"), HttpStatus.NOT_FOUND);
        casoService.deleteCaso(idCaso);
        return new ResponseEntity(new Mensaje("Caso eliminado"), HttpStatus.OK);
    }

    @PutMapping("/actualizarCaso/{idCaso}")
    public ResponseEntity<?> actualizarCaso(@PathVariable("idCaso") int idCaso, @RequestBody CasoDTO casoDTO) {


        if (!casoService.existsByIdCaso(idCaso))
            return new ResponseEntity(new Mensaje("No existe el caso"), HttpStatus.NOT_FOUND);

        Caso caso = casoService.getCaso(idCaso).get();
        caso.setNombrePte(casoDTO.getNombrePte());
        caso.setIdPte(casoDTO.getIdPte());
        caso.setNumeroOrden(casoDTO.getNumeroOrden());
        caso.setAntagonista(casoDTO.getAntagonista());
        caso.setRegistro(casoDTO.getRegistro());

        casoService.saveCaso(caso);

        return new ResponseEntity(new Mensaje("Caso actualizado"), HttpStatus.OK);
    }
}
