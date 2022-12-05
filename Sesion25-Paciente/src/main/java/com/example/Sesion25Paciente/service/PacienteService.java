package com.example.Sesion25Paciente.service;

import com.example.Sesion25Paciente.model.Paciente;
import com.example.Sesion25Paciente.repository.IDao;
import com.example.Sesion25Paciente.repository.impl.PacienteDaoH2;

import java.util.List;

public class PacienteService{

    private IDao<Paciente> pacienteIDao;

    public PacienteService(PacienteDaoH2 pacienteDaoH2) {

        this.pacienteIDao = pacienteDaoH2;
    }

    public Paciente guardar(Paciente paciente) {
        return pacienteIDao.guardar(paciente);
    }

}
