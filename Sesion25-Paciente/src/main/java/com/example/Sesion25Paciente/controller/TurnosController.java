package com.example.Sesion25Paciente.controller;

import com.example.Sesion25Paciente.model.Turno;
import com.example.Sesion25Paciente.repository.impl.OdontologoDaoH2;
import com.example.Sesion25Paciente.repository.impl.PacienteDaoH2;
import com.example.Sesion25Paciente.repository.impl.TurnoListRepository;
import com.example.Sesion25Paciente.service.OdontologoService;
import com.example.Sesion25Paciente.service.PacienteService;
import com.example.Sesion25Paciente.service.TurnosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turnos")
public class TurnosController
{
    private PacienteService pacienteService = new PacienteService(new PacienteDaoH2());
    private TurnosService turnoService = new TurnosService(new TurnoListRepository());
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @PostMapping
    public ResponseEntity<Turno> registrarTurno(@RequestBody Turno turno)
    {
        Turno turnoGuardado = null;
        ResponseEntity<Turno> response;

        if(pacienteService.buscar(turno.getPaciente().getId()) == null
                && odontologoService.buscar(turno.getOdontologo().getId()) == null)

        {
            response = ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        else
        {
            response = ResponseEntity.ok(turnoService.guardar(turno));
        }

        return response;
    }

    @GetMapping
    public ResponseEntity<List<Turno>> listarTurnos()
    {
        List<Turno> turnos = turnoService.listar();

        if(turnos.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.ok(turnoService.listar());
    }

}
