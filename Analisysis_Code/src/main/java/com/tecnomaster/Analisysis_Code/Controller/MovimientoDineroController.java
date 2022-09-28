package com.tecnomaster.Analisysis_Code.Controller;


import com.tecnomaster.Analisysis_Code.Entities.MovimientoDinero;
import com.tecnomaster.Analisysis_Code.Services.MovimientoDineroServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.Optional;


@RestController
public class MovimientoDineroController {
    @Autowired
    MovimientoDineroServicios movimientoDineroServicio;


    //Listar Movimientos por empleado ---OK
    @GetMapping("/users/{id}/movements")
    public ArrayList<MovimientoDinero> consultaPorUsuarios(@PathVariable("id") Integer idEmpleado){
        return this.movimientoDineroServicio.buscarMovimientosDinero(idEmpleado);
    }

    //Listar Movimientos por Empresa ---OK
    @GetMapping("/enterprises/{id}/movements")
    public ArrayList<MovimientoDinero> consultaPorEmpresa(@PathVariable("id") Integer idEmpresa){
        return this.movimientoDineroServicio.buscarPorEmpresa(idEmpresa);
    }


    //Listar todos los movimiento sin filtros ---OK
    @GetMapping("/movements")
    public ArrayList<MovimientoDinero> movimientos(){
        return movimientoDineroServicio.movimientos();
    }

    //Listar Movimiento por su id ---OK
    @GetMapping("/movements/{id}")
    public Optional<MovimientoDinero> cunsultarMovimiento(@PathVariable("id") int id){
        return this.movimientoDineroServicio.consultaMovimientoDineroID(id);
    }


    // Crear movimiento desde usuarios ---OK
    @PostMapping("/users/{id}/movements")
    public  String crearMovimientoDinero (@PathVariable("id") int idEmpleado, @RequestBody MovimientoDinero movimiento){
        return movimientoDineroServicio.crearMovimientoDinero(movimiento, idEmpleado);
    }


    // Actualizar movimiento (Solo se actualiza Monto y Concepto... y se pone la fecha de forma automatica)
    @PatchMapping("/movements/{id}")
    public String actualizar(@PathVariable("id") int idMd, @RequestBody Map<Object, Object> newMD){
        return movimientoDineroServicio.actualizarMovimientoDinero(idMd, newMD);

    }

    // Eliminar Movimiento ---OK
    @DeleteMapping("/movements/{id}")
    public String eliminarMovimientoDinero (@PathVariable("id") int index){
        return this.movimientoDineroServicio.eliminarMd(index);
    }

}
