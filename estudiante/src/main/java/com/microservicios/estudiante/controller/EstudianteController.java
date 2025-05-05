package com.microservicios.estudiante.controller;

import com.microservicios.estudiante.entity.Estudiante;
import com.microservicios.estudiante.repository.EstudianteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/estudiantes")
public class EstudianteController {

    private final EstudianteRepository repo;

    public EstudianteController(EstudianteRepository repo) {
        this.repo = repo;
    }

    @PostMapping
    public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
        return repo.save(estudiante);
    }

    @GetMapping
    public List<Estudiante> obtenerTodos() {
        return repo.findAll();
    }

    @GetMapping("/{rut}")
    public Optional<Estudiante> obtenerPorRut(@PathVariable String rut) {
        return repo.findById(rut);
    }
}
