package com.example.Sesion25Paciente.controller;

import com.example.Sesion25Paciente.model.Odontologo;
import com.example.Sesion25Paciente.repository.impl.OdontologoDaoH2;
import com.example.Sesion25Paciente.service.OdontologoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController
{
    private OdontologoService odontologoService = new OdontologoService(new OdontologoDaoH2());

    @PostMapping
    public Odontologo registrarOdontologo(@RequestBody Odontologo odontologo)
    {
        return odontologoService.guardar(odontologo);
    }

    @GetMapping
    public List<Odontologo> listarOdontologos()
    {
        return odontologoService.listar();
    }


}
