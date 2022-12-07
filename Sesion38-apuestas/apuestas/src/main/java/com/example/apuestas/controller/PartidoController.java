package com.example.apuestas.controller;

import com.example.apuestas.entities.Partido;
import com.example.apuestas.service.PartidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/partidos")
public class PartidoController {

    @Autowired
    private PartidoService partidoService;

    @PostMapping
    public Partido registrar(@RequestBody Partido partido){
        return partidoService.agregar(partido);
    }

    @GetMapping
    public String saludar(){
        return "Hola";
    }
}
