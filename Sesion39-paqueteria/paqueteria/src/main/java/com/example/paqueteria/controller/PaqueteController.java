package com.example.paqueteria.controller;

import com.example.paqueteria.entity.Paquete;
import com.example.paqueteria.service.PaqueteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/paquetes")
public class PaqueteController {

    private PaqueteService paqueteService;

    public PaqueteController(PaqueteService paqueteService) {
        this.paqueteService = paqueteService;
    }

    @PostMapping
    public Paquete agregar(@RequestBody Paquete paquete){
        return paqueteService.agregarPaquete(paquete);
    }

    @GetMapping
    public List<Paquete> listar(){
        return paqueteService.listarPaquetes();
    }

    @GetMapping("/enCamino")
    public List<Paquete> listarEnCamino(){
        return paqueteService.listarPaquetesEnCamino();
    }
}
