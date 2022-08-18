package com.sena.LabData.repository;

import com.sena.LabData.entity.TipoTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoTrabajoRepository extends JpaRepository<TipoTrabajo, Integer> {
}
