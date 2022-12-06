package co.com.dh.controller;


import co.com.dh.entities.Movimiento;
import co.com.dh.service.MovimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimiento")
public class MovimientoController {

    @Autowired
    public MovimientoService movimientoService;
    @PostMapping
    public ResponseEntity<Movimiento> crear(@RequestBody Movimiento movimiento) {

        movimientoService.save(movimiento);
        return ResponseEntity.ok(movimientoService.save(movimiento));
    }

    @GetMapping
    public ResponseEntity<String> getMovimiento(@RequestBody Movimiento movimiento) {
        return ResponseEntity.ok("Hola");
    }
}
