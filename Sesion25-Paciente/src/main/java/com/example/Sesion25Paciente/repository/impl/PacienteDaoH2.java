package com.example.Sesion25Paciente.repository.impl;

import com.example.Sesion25Paciente.model.Paciente;
import com.example.Sesion25Paciente.repository.IDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    public PacienteDaoH2() {
    }

    @Override
    public Paciente guardar(Paciente paciente) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection("jdbc:h2:~/test;PASSWORD=sa;USER=sa;INIT=RUNSCRIPT FROM 'create.sql' ");

            preparedStatement = connection.prepareStatement("INSERT INTO PACIENTES (nombre , apellido ) VALUES (?,?)  ");

            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());

            preparedStatement.execute();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
        return paciente;


    }

    @Override
    public Paciente buscarPorId(int id) {
        return null;
    }

    @Override
    public Paciente actualizar(Paciente paciente) {
        return null;
    }

    @Override
    public void borrar(int id) {

    }

    @Override
    public List<Paciente> buscarTodos() {
        return null;
    }

}
