package co.com.dh.service;


import co.com.dh.entities.Movimiento;
import co.com.dh.repository.MovimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimientoService {

    @Autowired
    private MovimientoRepository movimientoRepository;

    public Movimiento save(Movimiento movimiento) {
        return movimientoRepository.save(movimiento);
    }
}
