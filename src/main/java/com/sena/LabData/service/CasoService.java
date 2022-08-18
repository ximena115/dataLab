package com.sena.LabData.service;

import com.sena.LabData.entity.Caso;
import com.sena.LabData.repository.CasoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

@Transactional
public class CasoService {
    @Autowired
    CasoRepository casoRepository;

    public List<Caso> listaCaso(){ return  casoRepository.findAll();}

    public Optional<Caso> getCaso(int idUsuario){
        return  casoRepository.findById(idUsuario);
    }

    public void saveCaso(Caso caso){
        casoRepository.save(caso);
    }

    public void deleteCaso(int idUsuario){
        casoRepository.deleteById(idUsuario);
    }

    public boolean existsByIdCaso(int idCaso){
        return casoRepository.existsById(idCaso);
    }

}
