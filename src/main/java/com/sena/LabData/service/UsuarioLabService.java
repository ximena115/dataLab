package com.sena.LabData.service;


import com.sena.LabData.entity.UsuarioLab;
import com.sena.LabData.repository.UsuarioLabRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service

@Transactional
public class UsuarioLabService {

    @Autowired
    UsuarioLabRepository usuarioLabRepository;

    public List<UsuarioLab> listaUsuario() {
        return usuarioLabRepository.findAll();
    }

    public Optional<UsuarioLab> getUsuario(int idUsuario) {
        return usuarioLabRepository.findById(idUsuario);
    }

    public void saveUsuario(UsuarioLab usuarioLab) {
        usuarioLabRepository.save(usuarioLab);
    }

    public void deleteUsuario(int idUsuario) {
        usuarioLabRepository.deleteById(idUsuario);
    }

    public boolean existsByIdUsuario(int idUsuario) {
        return usuarioLabRepository.existsById(idUsuario);
    }

}

