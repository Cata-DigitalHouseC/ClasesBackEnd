package com.example.paqueteria.repository;

import com.example.paqueteria.entity.Estado;
import com.example.paqueteria.entity.Paquete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PaqueteRepository extends MongoRepository<Paquete, String> {

    @Query("{'estado': ?0}")
    Paquete findByEstado(Estado estado);

}

