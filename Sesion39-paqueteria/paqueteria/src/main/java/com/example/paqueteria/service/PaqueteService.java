package com.example.paqueteria.service;

import com.example.paqueteria.entity.Estado;
import com.example.paqueteria.entity.Paquete;
import com.example.paqueteria.repository.PaqueteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //El inyector del Spring no sabria donde esta el service para inyectarlo con el Autowired
public class PaqueteService {

    @Autowired
    private PaqueteRepository paqueteRepository;

    //Constructor
    public PaqueteService(PaqueteRepository paqueteRepository) {
        this.paqueteRepository = paqueteRepository;
    }

    //Metodos
    public Paquete agregarPaquete(Paquete paquete){
        return paqueteRepository.save(paquete);
    }

    public List<Paquete> listarPaquetes(){
        return paqueteRepository.findAll();
    }

    public List<Paquete> listarPaquetesEnCamino(){
        List<Paquete> todosLosPaquetes = listarPaquetes();
        List<Paquete> paquetesEnCamino = new ArrayList<>();

        for (Paquete paquete : todosLosPaquetes) {
            if(paquete.getEstado().equals(Estado.EN_CAMINO)){
                paquetesEnCamino.add(paquete);
            }
        }
        return paquetesEnCamino;
    }


}
