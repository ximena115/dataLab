package com.sena.LabData.controller;

import com.sena.LabData.dto.Mensaje;
import com.sena.LabData.dto.TipoTrabajoDTO;
import com.sena.LabData.entity.TipoTrabajo;
import com.sena.LabData.service.TipoTrabajoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/tipotrabajo")

@CrossOrigin(origins = "http://localhost:4200")
public class TipoTrabajoController {

    @Autowired
    TipoTrabajoService tipoTrabajoService;

    @GetMapping("/listaTipoTrabajo")
    public ResponseEntity<List<TipoTrabajo>> listaTipoTrabajos() {

        List<TipoTrabajo> tipoTrabajos = tipoTrabajoService.listaTipoTrabajo();
        return new ResponseEntity<List<TipoTrabajo>>(tipoTrabajos, HttpStatus.OK);
    }

    @GetMapping("/detalleTipoTrabajo/{idTipoTrabajo}")
    public ResponseEntity<TipoTrabajo> tipoTrabajoById(@PathVariable("idTipoTrabajo") int idTipoTrabajo) {

        if (!tipoTrabajoService.existsByIdTipoTrabajo(idTipoTrabajo))
            return new ResponseEntity(new Mensaje("No existe el Tipo Trabajo"), HttpStatus.NOT_FOUND);

        TipoTrabajo tipoTrabajo = tipoTrabajoService.getTipoTrabajo(idTipoTrabajo).get();
        return new ResponseEntity(tipoTrabajo, HttpStatus.OK);
    }

    @PostMapping("/crearTipoTrabajo")
    public ResponseEntity<?> creaTipoTrabajo(@RequestBody TipoTrabajoDTO tipoTrabajoDTO) {


        TipoTrabajo tipoTrabajo = new TipoTrabajo(tipoTrabajoDTO.getId(),
                tipoTrabajoDTO.getNombre(),
                tipoTrabajoDTO.getArea());

        tipoTrabajoService.saveTipoTrabajo(tipoTrabajo);
        return new ResponseEntity(new Mensaje("Tipo Trabajo creado"), HttpStatus.OK);

    }

    @DeleteMapping("/eliminarTipoTrabajo/{idTipoTrabajo}")
    public ResponseEntity<?> eliminarTipoTrabajo(@PathVariable("idTipoTrabajo") int idTipoTrabajo) {

        if (!tipoTrabajoService.existsByIdTipoTrabajo(idTipoTrabajo))
            return new ResponseEntity(new Mensaje("No existe el Tipo Trabajo"), HttpStatus.NOT_FOUND);
        tipoTrabajoService.deleteTipoTrabajo(idTipoTrabajo);
        return new ResponseEntity(new Mensaje("Tipo Trabajo eliminado"), HttpStatus.OK);
    }

    @PutMapping("/actualizarTipoTrabajo/{idTipoTrabajo}")
    public ResponseEntity<?> actualizarTipoTrabajo(@PathVariable("idTipoTrabajo") int idTipoTrabajo, @RequestBody TipoTrabajoDTO tipoTrabajoDTO) {


        if (!tipoTrabajoService.existsByIdTipoTrabajo(idTipoTrabajo))
            return new ResponseEntity(new Mensaje("No existe el Tipo Trabajo"), HttpStatus.NOT_FOUND);

        TipoTrabajo tipoTrabajo = tipoTrabajoService.getTipoTrabajo(idTipoTrabajo).get();
        tipoTrabajo.setId(tipoTrabajoDTO.getId());
        tipoTrabajo.setNombre(tipoTrabajoDTO.getNombre());

        tipoTrabajoService.saveTipoTrabajo(tipoTrabajo);

        return new ResponseEntity(new Mensaje("Tipo Trabajo actualizado"), HttpStatus.OK);
    }
}
