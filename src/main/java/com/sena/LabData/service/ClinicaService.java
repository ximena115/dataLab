package com.sena.LabData.service;

import com.sena.LabData.entity.Clinica;
import com.sena.LabData.repository.ClinicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

@Transactional
public class ClinicaService {

    @Autowired
    ClinicaRepository clinicaRepository;

    public List<Clinica> listaClinicas(){ return  clinicaRepository.findAll();}

    public Optional<Clinica> getClinica(int idUsuario){
        return  clinicaRepository.findById(idUsuario);
    }

    public void saveClinica(Clinica clinica){
        clinicaRepository.save(clinica);
    }

    public void deleteClinica(int idUsuario){
        clinicaRepository.deleteById(idUsuario);
    }

    public boolean existsByIdClinica(int idUsuario){
        return clinicaRepository.existsById(idUsuario);
    }
}
