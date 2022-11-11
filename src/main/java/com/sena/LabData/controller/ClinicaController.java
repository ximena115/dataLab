package com.sena.LabData.controller;

import com.sena.LabData.dto.ClinicaDTO;
import com.sena.LabData.dto.Mensaje;

import com.sena.LabData.entity.Clinica;
import com.sena.LabData.service.ClinicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/clinica")

@CrossOrigin(origins = "http://localhost:4200")
public class ClinicaController {

    @Autowired
    ClinicaService clinicaService;

    @GetMapping("/listaClinica")
    public ResponseEntity<List<Clinica>> listaClinica(){

        List<Clinica> clinicas = clinicaService.listaClinicas();
        return new ResponseEntity<List<Clinica>>(clinicas, HttpStatus.OK);
    }

    @GetMapping("/detalleClinica/{idClinica}")
    public ResponseEntity<Clinica> clinicaById(@PathVariable("idClinica") int idClinica){

        if (!clinicaService.existsByIdClinica(idClinica))
            return new ResponseEntity(new Mensaje("No existe la clinica"), HttpStatus.NOT_FOUND);

        Clinica clinica = clinicaService.getClinica(idClinica).get();
        return new ResponseEntity(clinica, HttpStatus.OK);
    }

    @PostMapping("/crearClinica")
    public ResponseEntity<?> creaClinica(@RequestBody ClinicaDTO clinicaDTO){


        Clinica clinica =  new Clinica(
                clinicaDTO.getId(),
                clinicaDTO.getNombre(),
                clinicaDTO.getFijo(),
                clinicaDTO.getDireccion(),
                clinicaDTO.getMovil(),
                clinicaDTO.getAuxiliar());

        clinicaService.saveClinica(clinica);
        return new ResponseEntity(new Mensaje("Clinica creada"), HttpStatus.OK);
    }

    @DeleteMapping("/eliminarClinica/{idClinica}")
    public ResponseEntity<?> eliminarClinica(@PathVariable("idClinica") int idClinica) {

        if (!clinicaService.existsByIdClinica(idClinica))
            return new ResponseEntity(new Mensaje("No existe la clinica"), HttpStatus.NOT_FOUND);
        clinicaService.deleteClinica(idClinica);
        return new ResponseEntity(new Mensaje("clinica eliminada"), HttpStatus.OK);
    }

    @PutMapping("/actualizarClinica/{idClinica}")
    public ResponseEntity<?> actualizarClinica(@PathVariable("idClinica") int idClinica, @RequestBody ClinicaDTO clinicaDTO) {


        if (!clinicaService.existsByIdClinica(idClinica))
            return new ResponseEntity(new Mensaje("No existe la clinica"), HttpStatus.NOT_FOUND);

        Clinica clinica = clinicaService.getClinica(idClinica).get();
        clinica.setDireccion(clinicaDTO.getDireccion());
        clinica.setNombre(clinicaDTO.getNombre());
        clinica.setAuxiliar(clinicaDTO.getAuxiliar());
        clinica.setMovil(clinicaDTO.getMovil());
        clinica.setFijo(clinicaDTO.getFijo());

        clinicaService.saveClinica(clinica);

        return new ResponseEntity(new Mensaje("Clinica actualizada"), HttpStatus.OK);
    }
}
