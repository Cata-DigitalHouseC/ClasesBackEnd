package com.example.Sesion25Paciente.repository;

import java.util.List;

public interface IDao<T> {

    public T guardar(T t);
    public T buscar(int id);
    public T actualizar(T t);
    public void borrar(int id);
    public List<T> buscarTodos();

}
