package com.dh.demo.repository;

import com.dh.demo.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProfesorRepository extends JpaRepository<Profesor, Integer> {

    @Query("Select p from Profesor p where p.nombre = ?1")
    Profesor buscarPorNombre(String nombre);
}

