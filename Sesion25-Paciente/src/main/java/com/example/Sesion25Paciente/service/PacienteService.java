package com.example.Sesion25Paciente.service;

import com.example.Sesion25Paciente.entities.Paciente;
import com.example.Sesion25Paciente.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PacienteService{

    private PacienteRepository pacienteIDao;

    public PacienteService(PacienteRepository pacienteRepository) {

        this.pacienteIDao = pacienteRepository;
    }

    public Paciente guardar(Paciente paciente) {
        return pacienteIDao.save(paciente);
    }

    public Optional<Paciente> buscar(Integer id) {
        return pacienteIDao.findById(id);
    }

}
