package com.sena.LabData.repository;

import com.sena.LabData.entity.Caso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CasoRepository extends JpaRepository<Caso, Integer> {
}
