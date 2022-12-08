package com.example.Sesion25Paciente.service;

import com.example.Sesion25Paciente.dto.OdontologoDto;
import com.example.Sesion25Paciente.entities.Odontologo;
import com.example.Sesion25Paciente.exception.ResourceNotFoundException;
import com.example.Sesion25Paciente.repository.OdontologoRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OdontologoService {

    @Autowired
    private OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    public OdontologoDto guardar(OdontologoDto odontologo) {
        //dto -> BO
        //BO -> entity

        //o simplemente dto -> Entity

        Odontologo odontologoEntity = mapper.convertValue(odontologo, Odontologo.class);
        Odontologo odontologoCreadoEntity = odontologoRepository.save(odontologoEntity);
        OdontologoDto odontologoCreadoDto = mapper.convertValue(odontologoCreadoEntity, OdontologoDto.class);
        return odontologoCreadoDto;
    }

    private Odontologo mapDtoToEntity(OdontologoDto odontologo) {
        Odontologo odontologoEntity = new Odontologo();
        odontologoEntity.setMatricula(odontologo.matricula);
        odontologoEntity.setNombre(odontologo.nombre);
        odontologoEntity.setApellido(odontologo.apellido);
        return odontologoEntity;
    }

    public List<Odontologo> listar() {
        return odontologoRepository.findAll();
    }

    public Optional<Odontologo> buscar(Integer id) {
        return odontologoRepository.findById(id);
    }
    //Optional envuelve al obj y le agrega mas capacidades

    public Odontologo actualizar(Integer id, OdontologoDto odontologoDto) {
        //OJO no devolder la entidad
        Optional<Odontologo> odontologoOptional = buscar(id);

        if(odontologoOptional.isPresent()) {
            odontologoOptional.get().setNombre(odontologoDto.nombre != null ? odontologoDto.nombre:odontologoOptional.get().getNombre());
            odontologoOptional.get().setApellido(odontologoDto.apellido != null ? odontologoDto.apellido:odontologoOptional.get().getApellido());
            odontologoOptional.get().setMatricula(odontologoDto.matricula != null ? odontologoDto.matricula:odontologoOptional.get().getMatricula());

        }
        return odontologoRepository.save(odontologoOptional.get());
    }

    public void eliminar(Integer id) throws ResourceNotFoundException {

        if(!buscar(id).isPresent()){
            throw new ResourceNotFoundException("No se encontro el odontologo con el id: " + id); //o SQLException
        }
        odontologoRepository.deleteById(id);

        /*
        Optional<Odontologo> odontologoOptional = buscar(id);
        if(odontologoOptional.isPresent()) {
            odontologoRepository.delete(odontologoOptional.get());
            return ResponseEntity.ok("Odontologo eliminado");
        }
        return ResponseEntity.notFound().build();

         */
    }
}
