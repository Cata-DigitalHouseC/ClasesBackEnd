package com.dh.service;

import com.dh.entities.Producto;
import com.dh.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    public Optional<Producto> buscar(Integer id) {
        //return productoRepository.findById(id).orElse(null);
        return productoRepository.findById(id);
    }
}
