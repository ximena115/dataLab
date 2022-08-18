package com.sena.LabData.service;

import com.sena.LabData.entity.Odontologo;
import com.sena.LabData.repository.OdontologoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

@Transactional
public class OdontologoService {

    @Autowired
    OdontologoRepository odontologoRepository;

    public List<Odontologo> listaOdontologo(){ return  odontologoRepository.findAll();}

    public Optional<Odontologo> getOdontologo(int idOdontologo){
        return  odontologoRepository.findById(idOdontologo);
    }

    public void saveOdontologo(Odontologo odontologo){
        odontologoRepository.save(odontologo);
    }

    public void deleteOdontologo(int idOdontologo){
        odontologoRepository.deleteById(idOdontologo);
    }

    public boolean existsByIdOdontologo(int idOdontologo){
        return odontologoRepository.existsById(idOdontologo);
    }
}
