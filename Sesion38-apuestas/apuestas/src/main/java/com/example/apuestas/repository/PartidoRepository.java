package com.example.apuestas.repository;

import com.example.apuestas.entities.Partido;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidoRepository extends MongoRepository<Partido, String> {

}

