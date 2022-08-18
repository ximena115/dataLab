package com.sena.LabData.repository;

import com.sena.LabData.entity.UsuarioLab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioLabRepository extends JpaRepository<UsuarioLab, Integer> {



}
