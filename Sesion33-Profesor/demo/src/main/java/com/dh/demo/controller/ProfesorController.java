package com.dh.demo.controller;


import com.dh.demo.entities.Profesor;
import com.dh.demo.service.ProfesorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/profesor")
public class ProfesorController {

    @Autowired
    private final ProfesorService profesorService;


    public ProfesorController(ProfesorService profesorService) {
        this.profesorService = profesorService;
    }

    @GetMapping
    public ResponseEntity<List<Profesor>> buscarTodos(){
        //List<Profesor> profes = profesorService.buscarTodos();
        //profes.getAlumnos().forEach(alumno -> System.out.println(alumno.getNombre()));
        return ResponseEntity.ok(profesorService.buscarTodos());
    }
}
