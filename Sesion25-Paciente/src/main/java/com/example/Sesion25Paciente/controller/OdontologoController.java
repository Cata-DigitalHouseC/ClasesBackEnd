package com.example.Sesion25Paciente.controller;

import com.example.Sesion25Paciente.dto.OdontologoDto;
import com.example.Sesion25Paciente.entities.Odontologo;
import com.example.Sesion25Paciente.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController
{
    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<OdontologoDto> registrarOdontologo(@RequestBody OdontologoDto odontologoDto)
    {
        //siemre responde ok, hay que manejar el error 400 200 500
        //Y los logs?
        return ResponseEntity.ok(odontologoService.guardar(odontologoDto));
    }

    @GetMapping
    public ResponseEntity<List<OdontologoDto>> listarOdontologos()
    {
        List<OdontologoDto> dtos = new ArrayList<>();
        for (Odontologo odontologo : odontologoService.listar())
        {
            dtos.add(mapEntityToDto(odontologo));
        }
        return ResponseEntity.ok(dtos);
    }

    //no va, esta devolviendo una entidad, acopla con la capa de persistencia
    @PatchMapping("/{id}")
    public ResponseEntity<OdontologoDto> modificarOdontologo(@PathVariable Integer id, @RequestBody OdontologoDto odontologoDto)
    {
        return ResponseEntity.ok(mapEntityToDto(odontologoService.actualizar(id, odontologoDto)));
    }


    private OdontologoDto mapEntityToDto(Odontologo odontologoEntity) {
        OdontologoDto odontologoDto = new OdontologoDto();
        odontologoDto.id = odontologoEntity.getId();
        odontologoDto.nombre = odontologoEntity.getNombre();
        odontologoDto.apellido = odontologoEntity.getApellido();
        return odontologoDto;
    }
}
