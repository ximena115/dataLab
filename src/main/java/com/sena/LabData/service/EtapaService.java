package com.sena.LabData.service;

import com.sena.LabData.entity.Etapa;
import com.sena.LabData.entity.UsuarioLab;
import com.sena.LabData.repository.EtapaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

@Transactional
public class EtapaService {

    @Autowired
    EtapaRepository etapaRepository;

    public List<Etapa> listaEtapas() {
        return etapaRepository.findAll();
    }

    public Optional<Etapa> getEtapa(int idEtapa) {
        return etapaRepository.findById(idEtapa);
    }

    public void saveEtapa(Etapa etapa) {
        etapaRepository.save(etapa);
    }

    public void deleteEtapa(int idEtapa) {
        etapaRepository.deleteById(idEtapa);
    }

    public boolean existsByIdEtapa(int idEtapa) {
        return etapaRepository.existsById(idEtapa);
    }

}
