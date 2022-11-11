package com.sena.LabData.controller;

import com.sena.LabData.dto.Mensaje;
import com.sena.LabData.dto.OdontologoDTO;
import com.sena.LabData.entity.Odontologo;
import com.sena.LabData.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/odontologo")

@CrossOrigin(origins = "http://localhost:4200")

public class OdontologoController {

    @Autowired
    OdontologoService odontologoService;

    @GetMapping("/listaOdontologos")
    public ResponseEntity<List<Odontologo>> listaOdontologos(){

        List<Odontologo> odontologos = odontologoService.listaOdontologo();
        return new ResponseEntity<List<Odontologo>>(odontologos, HttpStatus.OK);
    }

    @GetMapping("/detalleOdontologo/{idOdontologo}")
    public ResponseEntity<Odontologo> odontologoById(@PathVariable("idOdontologo") int idOdontologo){

        if (!odontologoService.existsByIdOdontologo(idOdontologo))
            return new ResponseEntity(new Mensaje("No existe el Odontologo"), HttpStatus.NOT_FOUND);

        Odontologo odontologo = odontologoService.getOdontologo(idOdontologo).get();
        return new ResponseEntity(odontologo, HttpStatus.OK);
    }

    @PostMapping("/crearOdontologo")
    public ResponseEntity<?> creaOdontologo(@RequestBody OdontologoDTO odontologoDTO){

        Odontologo odontologo =  new Odontologo(odontologoDTO.getId(),
                odontologoDTO.getNombre(),
                odontologoDTO.getApellido(),
                odontologoDTO.getMovil(),
                odontologoDTO.getFijo(),
                odontologoDTO.getEspecialidad());

        odontologoService.saveOdontologo(odontologo);
        return new ResponseEntity(new Mensaje("Odontologo creado"), HttpStatus.OK);

    }


       @DeleteMapping("/eliminarOdontologo/{idOdontologo}")
        public ResponseEntity<?> eliminarOdontologo(@PathVariable("idOdontologo") int idOdontologo){
            if (!odontologoService.existsByIdOdontologo(idOdontologo))
                return new ResponseEntity(new Mensaje("No existe el odontologo"), HttpStatus.NOT_FOUND);
            odontologoService.deleteOdontologo(idOdontologo);
            return new ResponseEntity(new Mensaje("Odontologo eliminado"), HttpStatus.OK);
    }

    @PutMapping("/actualizarOdontologo/{idOdontologo}")
    public ResponseEntity<?> actualizarOdontologo(@PathVariable("idOdontologo") int idOdontologo, @RequestBody OdontologoDTO odontologoDTO) {


        if (!odontologoService.existsByIdOdontologo(idOdontologo))
            return new ResponseEntity(new Mensaje("No existe el Odontologo"), HttpStatus.NOT_FOUND);

        Odontologo Odontologo = odontologoService.getOdontologo(idOdontologo).get();
        Odontologo.setId(odontologoDTO.getId());
        Odontologo.setNombre(odontologoDTO.getNombre());
        Odontologo.setApellido(odontologoDTO.getApellido());
        Odontologo.setMovil(odontologoDTO.getMovil());
        Odontologo.setEspecialidad(odontologoDTO.getEspecialidad());
        Odontologo.setFijo(odontologoDTO.getFijo());

        odontologoService.saveOdontologo(Odontologo);

        return new ResponseEntity(new Mensaje("Odontologo actualizado"), HttpStatus.OK);
    }
}
