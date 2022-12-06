package com.example.Sesion25Paciente.repository.impl;

import com.example.Sesion25Paciente.model.Odontologo;
import com.example.Sesion25Paciente.model.Paciente;
import com.example.Sesion25Paciente.repository.IDao;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
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
    public Paciente buscar(int id) {
        //log.debug("Buscando al Paciente con id = " + id);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Paciente paciente = null;
        try {
            //1 Levantar el driver y Conectarnos
            Class.forName("org.h2.Driver");

            connection = DriverManager.getConnection("jdbc:h2:~/test;PASSWORD=sa;USER=sa;INIT=RUNSCRIPT FROM 'create.sql' ");
            //2 Crear una sentencia
            preparedStatement = connection.prepareStatement("SELECT id,nombre,apellido FROM pacientes where id = ?");
            preparedStatement.setInt(1, id);

            //3 Ejecutar una sentencia SQL
            ResultSet result = preparedStatement.executeQuery();

            //4 Obtener resultados
            while (result.next()) {
                int idPaciente = result.getInt("id");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");

                paciente = new Paciente(idPaciente, nombre, apellido);
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
            //log.error(throwables);
        }

        return paciente;
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
        return null;}

}
