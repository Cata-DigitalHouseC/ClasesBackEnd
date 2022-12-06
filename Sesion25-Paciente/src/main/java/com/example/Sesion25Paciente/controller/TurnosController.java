package com.example.Sesion25Paciente.controller;

import com.example.Sesion25Paciente.model.Turno;
import com.example.Sesion25Paciente.repository.impl.PacienteDaoH2;
import com.example.Sesion25Paciente.repository.impl.TurnoListRepository;
import com.example.Sesion25Paciente.service.PacienteService;
import com.example.Sesion25Paciente.service.TurnosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turnos")
public class TurnosController
{
    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno)
    {
        PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
        TurnosService turnoService = new TurnosService(new TurnoListRepository());

        Turno turnoGuardado = null;
        ResponseEntity<Turno> response;

        if(pacienteService.buscar(turno.getPaciente().getId()) == null)
        {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else
        {
            response = ResponseEntity.ok(turnoService.guardar(turno));
        }

        return response;
    }

}
