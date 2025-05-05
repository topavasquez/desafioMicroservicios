package com.microservicios.estudiante.repository;

import com.microservicios.estudiante.entity.Estudiante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudianteRepository extends JpaRepository<Estudiante, String> {
}
