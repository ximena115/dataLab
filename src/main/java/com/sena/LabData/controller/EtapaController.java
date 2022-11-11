package com.sena.LabData.controller;

import com.sena.LabData.dto.EtapaDTO;
import com.sena.LabData.dto.Mensaje;
import com.sena.LabData.entity.Etapa;
import com.sena.LabData.service.EtapaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/etapa")

@CrossOrigin(origins = "http://localhost:4200")
public class EtapaController {

    @Autowired
    EtapaService etapaService;

    @GetMapping("/listaEtapas")
    public ResponseEntity<List<Etapa>> listaEtapas() {

        List<Etapa> etapas = etapaService.listaEtapas();
        return new ResponseEntity<List<Etapa>>(etapas, HttpStatus.OK);
    }

    @GetMapping("/detalleEtapa/{idEtapa}")
    public ResponseEntity<Etapa> etapaById(@PathVariable("idEtapa") int idEtapa) {

        if (!etapaService.existsByIdEtapa(idEtapa))
            return new ResponseEntity(new Mensaje("No existe La etapa"), HttpStatus.NOT_FOUND);

        Etapa etapa = etapaService.getEtapa(idEtapa).get();
        return new ResponseEntity(etapa, HttpStatus.OK);
    }

    @PostMapping("/crearEtapa")
    public ResponseEntity<?> creaEtapa(@RequestBody EtapaDTO etapaDTO) {


        Etapa etapa = new Etapa(etapaDTO.getId(),
                etapaDTO.getNombre(),
                etapaDTO.getFechaEsperada(),
                etapaDTO.getFechaIngreso(),
                etapaDTO.getFechaSalida());

        etapaService.saveEtapa(etapa);
        return new ResponseEntity(new Mensaje("Etapa creada"), HttpStatus.OK);

    }

    @DeleteMapping("/eliminarEtapa/{idEtapa}")
    public ResponseEntity<?> eliminarEtapa(@PathVariable("idEtapa") int idEtapa) {

        if (!etapaService.existsByIdEtapa(idEtapa))
            return new ResponseEntity(new Mensaje("No existe la etapa"), HttpStatus.NOT_FOUND);
        etapaService.deleteEtapa(idEtapa);
        return new ResponseEntity(new Mensaje("Etapa eliminada"), HttpStatus.OK);
    }

    @PutMapping("/actualizarEtapa/{idEtapa}")
    public ResponseEntity<?> actualizarEtapa(@PathVariable("idEtapa") int idEtapa, @RequestBody EtapaDTO etapaDTO) {


        if (!etapaService.existsByIdEtapa(idEtapa))
            return new ResponseEntity(new Mensaje("No existe la etapa"), HttpStatus.NOT_FOUND);

        Etapa etapa = etapaService.getEtapa(idEtapa).get();
        etapa.setId(etapaDTO.getId());
        etapa.setNombre(etapaDTO.getNombre());
        etapa.setFechaEsperada(etapaDTO.getFechaEsperada());
        etapa.setFechaIngreso(etapaDTO.getFechaIngreso());
        etapa.setFechaSalida(etapaDTO.getFechaSalida());

        etapaService.saveEtapa(etapa);

        return new ResponseEntity(new Mensaje("etapa actualizada"), HttpStatus.OK);
    }
}
