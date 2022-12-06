package com.example.Sesion25Paciente.service;

import com.example.Sesion25Paciente.model.Turno;
import com.example.Sesion25Paciente.repository.IDao;
import com.example.Sesion25Paciente.repository.impl.TurnoListRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurnosService {

    private IDao<Turno> turnoListRepository;
    public TurnosService(TurnoListRepository turnoListRepository) {
        this.turnoListRepository = turnoListRepository;
    }

    public Turno guardar(Turno turno){
        //valido logica d enegocio
        return turnoListRepository.guardar(turno);
    }


    public List<Turno> listar() {
        return turnoListRepository.buscarTodos();
    }
}
