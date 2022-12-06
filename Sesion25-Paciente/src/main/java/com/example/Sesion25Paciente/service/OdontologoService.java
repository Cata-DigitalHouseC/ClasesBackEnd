package com.example.Sesion25Paciente.service;

import com.example.Sesion25Paciente.model.Odontologo;
import com.example.Sesion25Paciente.repository.IDao;
import com.example.Sesion25Paciente.repository.impl.OdontologoDaoH2;

import java.util.List;

public class OdontologoService {

    private IDao<Odontologo> odontologoDao;
    public OdontologoService(OdontologoDaoH2 odontologoDaoH2) {
        this.odontologoDao = odontologoDaoH2;
    }

    public Odontologo guardar(Odontologo odontologo) {
        return odontologoDao.guardar(odontologo);
    }

    public List<Odontologo> listar() {
        return odontologoDao.buscarTodos();
    }

    public Odontologo buscar(Integer id) {
        return odontologoDao.buscar(id);
    }
}
