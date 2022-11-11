package com.sena.LabData.service;

import com.sena.LabData.entity.TipoTrabajo;
import com.sena.LabData.repository.TipoTrabajoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

@Transactional
public class TipoTrabajoService {

    @Autowired
    TipoTrabajoRepository tipoTrabajoRepository;

    public List<TipoTrabajo> listaTipoTrabajo() {
        return tipoTrabajoRepository.findAll();
    }

    public Optional<TipoTrabajo> getTipoTrabajo(int idTipoTrabajo) {
        return tipoTrabajoRepository.findById(idTipoTrabajo);
    }

    public void saveTipoTrabajo(TipoTrabajo tipoTrabajo) {
        tipoTrabajoRepository.save(tipoTrabajo);
    }

    public void deleteTipoTrabajo(int idTipoTrabajo) {
        tipoTrabajoRepository.deleteById(idTipoTrabajo);
    }

    public boolean existsByIdTipoTrabajo(int idUsuario) {
        return tipoTrabajoRepository.existsById(idUsuario);
    }
}
