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
        //Validar un solo turno asignado por paciente
        if(buscarPorIdPaciente(turno.getPaciente().getId()) == null){
            return turnoListRepository.guardar(turno);
        }
        return null;
    }

    private Turno buscarPorIdPaciente(Integer id) {
        List<Turno> turnos = turnoListRepository.buscarTodos();
        for (Turno turno : turnos) {
            if(turno.getPaciente().getId().equals(id)){
                return turno;
            }
        }
        return null;
    }


    public List<Turno> listar() {
        return turnoListRepository.buscarTodos();
    }
}
