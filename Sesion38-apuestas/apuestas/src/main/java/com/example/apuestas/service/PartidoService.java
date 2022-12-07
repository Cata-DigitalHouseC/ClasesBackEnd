package com.example.apuestas.service;

import com.example.apuestas.entities.Estado;
import com.example.apuestas.entities.Partido;
import com.example.apuestas.repository.PartidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PartidoService {


    @Autowired
    private PartidoRepository partidoRepository;

    public Partido agregar(Partido partido) {
        if(partido.getEstado().equals(Estado.FINALIZADO)){
            return partidoRepository.save(partido);
        }
        return null;

    }

}
