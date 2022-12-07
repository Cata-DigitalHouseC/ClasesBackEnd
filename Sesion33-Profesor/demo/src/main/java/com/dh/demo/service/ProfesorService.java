package com.dh.demo.service;

import com.dh.demo.entities.Profesor;
import com.dh.demo.repository.ProfesorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorService {


    private final ProfesorRepository profesorRepository;

    public ProfesorService(ProfesorRepository profesorRepository) {
        this.profesorRepository = profesorRepository;
    }

    public List<Profesor> buscarTodos() {
        return profesorRepository.findAll();
    }

    public Profesor buscarPorNombre(String nombre) {
        return profesorRepository.buscarPorNombre(nombre);
    }
}
