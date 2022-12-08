package com.example.Sesion25Paciente.dto;

public class OdontologoDto {
    //data sensible, puede estar este pkg dentro de service
    public Integer id;
    public String nombre;
    public String apellido;
    public Integer matricula;

    public OdontologoDto() {
    }

    public OdontologoDto(String nombre, String apellido, Integer matricula) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
    }
}
