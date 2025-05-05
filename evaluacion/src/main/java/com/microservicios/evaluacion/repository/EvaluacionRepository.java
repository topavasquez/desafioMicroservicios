package com.microservicios.evaluacion.repository;

import com.microservicios.evaluacion.entity.Evaluacion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvaluacionRepository extends JpaRepository<Evaluacion, Long> {
}
