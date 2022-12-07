package com.dh.demo.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "profesores")
public class Profesor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombreProfesor") //nombre en la tabla de esa columna, en HQL arroja error, porque es sobre los obj no sobre las tablas
    private String nombre;
    private String titulo;

    @OneToMany(fetch = FetchType.EAGER) //LAZY -> Carga perezosa, Solo busca cuando se lo pedis, EAGER -> Trae todo de una vez
    @JoinColumn(name = "profesor_id")
    private Set<Alumnos> alumnos;

    public Profesor() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
