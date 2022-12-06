package com.dh.controller;

import com.dh.entities.Producto;
import com.dh.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/producto")
public class ProductoController
{

    @Autowired
    public ProductoService productoService;


    @GetMapping("/{id}")
   public ResponseEntity<Producto> getProducto(@PathVariable Integer id)
   {

      //return ResponseEntity.ok(productoService.buscar(id));
       Optional<Producto> producto = productoService.buscar(id);
         if(producto.isPresent())
         {
              return ResponseEntity.ok(producto.get());
         }
         else
         {
              return ResponseEntity.notFound().build();
         }
   }


}
