package com.example.Sesion25Paciente.repository.impl;

import com.example.Sesion25Paciente.model.Turno;
import com.example.Sesion25Paciente.repository.IDao;

import java.util.ArrayList;
import java.util.List;

public class TurnoListRepository implements IDao<Turno>
{
    private List<Turno> listaTurnos;

    public TurnoListRepository() {
        this.listaTurnos = new ArrayList<>();
    }

    @Override
    public Turno guardar(Turno turno) {
        listaTurnos.add(turno);
        return turno;
    }

    @Override
    public Turno buscar(int id) {
        return null;
    }

    @Override
    public Turno actualizar(Turno turno) {
        return null;
    }

    @Override
    public void borrar(int id) {

    }

    @Override
    public List<Turno> buscarTodos() {
        return listaTurnos;
    }
}
