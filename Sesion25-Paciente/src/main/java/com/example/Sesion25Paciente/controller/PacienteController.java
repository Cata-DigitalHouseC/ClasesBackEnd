package com.example.Sesion25Paciente.controller;

import com.example.Sesion25Paciente.model.Paciente;
import com.example.Sesion25Paciente.repository.impl.PacienteDaoH2;
import com.example.Sesion25Paciente.service.PacienteService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/paciente")

//http:localhost:8080/paciente/5
public class PacienteController {


    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());

    @PostMapping
    public Paciente registrarPaciente(@RequestBody Paciente paciente){ //RequestBody -> Lo que le envio

        return pacienteService.guardar(paciente);
    }

    @GetMapping("/{id}")
    public Paciente getPaciente(@PathVariable Integer id){
        return pacienteService.buscar(id);
    }




}
