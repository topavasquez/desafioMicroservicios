package com.microservicios.evaluacion.controller;

import com.microservicios.evaluacion.entity.Evaluacion;
import com.microservicios.evaluacion.repository.EvaluacionRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/evaluaciones")
public class EvaluacionController {

    private final EvaluacionRepository repo;

    public EvaluacionController(EvaluacionRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Evaluacion crearEvaluacion(@RequestBody Evaluacion evaluacion) {
        return repo.save(evaluacion);
    }

    @GetMapping
    public List<Evaluacion> obtenerTodas() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Evaluacion> obtenerPorId(@PathVariable Long id) {
        return repo.findById(id);
    }
}
