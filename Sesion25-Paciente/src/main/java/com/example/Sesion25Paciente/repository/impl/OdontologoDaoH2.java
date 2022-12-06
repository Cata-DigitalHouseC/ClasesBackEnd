package com.example.Sesion25Paciente.repository.impl;

import com.example.Sesion25Paciente.model.Odontologo;
import com.example.Sesion25Paciente.model.Paciente;
import com.example.Sesion25Paciente.repository.IDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OdontologoDaoH2 implements IDao<Odontologo> {

    @Override
    public Odontologo guardar(Odontologo odontologo) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection("jdbc:h2:~/test;PASSWORD=sa;USER=sa;INIT=RUNSCRIPT FROM 'create.sql' ");

            preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGOS (nombre, apellido, matricula) VALUES (?,?, ?)  ");

            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setInt(3, odontologo.getMatricula());

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
        return odontologo;
    }

    @Override
    public Odontologo buscar(int id) {
        return null;
    }

    @Override
    public Odontologo actualizar(Odontologo odontologo) {
        return null;
    }

    @Override
    public void borrar(int id) {

    }

    @Override
    public List<Odontologo> buscarTodos() {

        List<Odontologo> listaOdontologos = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;


        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test;PASSWORD=sa;USER=sa;INIT=RUNSCRIPT FROM 'create.sql' ");


            preparedStatement = connection.prepareStatement("SELECT * FROM odontologos");
            ResultSet result = preparedStatement.executeQuery();

            while(result.next()){
                int id = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                int matricula = result.getInt("matricula");
                listaOdontologos.add(new Odontologo(id,nombre,apellido,matricula));
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listaOdontologos;

    }
}
