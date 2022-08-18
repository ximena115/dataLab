package com.sena.LabData.repository;

import com.sena.LabData.entity.Etapa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtapaRepository extends JpaRepository<Etapa, Integer> {
}
