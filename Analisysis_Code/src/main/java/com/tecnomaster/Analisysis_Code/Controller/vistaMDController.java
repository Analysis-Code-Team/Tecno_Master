package com.tecnomaster.Analisysis_Code.Controller;

import com.tecnomaster.Analisysis_Code.Entities.MovimientoDinero;
import com.tecnomaster.Analisysis_Code.Services.MovimientoDineroServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class vistaMDController {
    @Autowired
    MovimientoDineroServicios servicio;


//    Listar Todos los movimientos
    @GetMapping("/MovimientoDinero")
    public String buscarMd(Model model){
        List<MovimientoDinero> listaMov = this.servicio.movimientos();
        model.addAttribute("lista",listaMov);
        model.addAttribute("movimiento", new MovimientoDinero());
        return "MovimientoDineo";
    }


//    Agregar Movimiento
    @PostMapping("/MovimientoDinero")
    public String newMovimiento(@ModelAttribute("movimiento") MovimientoDinero newMoviDin){
        servicio.crearMovimientoDinero(newMoviDin, newMoviDin.getUsuario().getId());
        return "redirect:/MovimientoDinero";

    }

//    Editar Libro
    @GetMapping("/MovimientoDinero/{id}")
    public String obteMov(@PathVariable("id") int id,Model model){
        model.addAttribute("movimiento2", servicio.consultaMovimientoDineroID(id).get());
        return "editMovimiento";
    }


    @PostMapping("/MovimientoDinero2/{id}")
    public String actualizarLibro(@PathVariable("id") int id, @ModelAttribute("movimiento2") MovimientoDinero movimiento){
        MovimientoDinero mv = servicio.consultaMovimientoDineroID(id).get();
        mv.setFechaActualizacion(new Date());
        mv.setMonto(movimiento.getMonto());
        mv.setConcepto(movimiento.getConcepto());
        mv.setTipo(movimiento.getTipo());
        servicio.actulizar(mv);
        return "redirect:/MovimientoDinero";
    }


//    Eliminar movimiento
    @GetMapping("/eliminarMovimiento/{id}")
    public String eliminarMovimiento(@PathVariable("id") int id, Model model){
        servicio.eliminarMd(id);
        return "redirect:/MovimientoDinero";
    }

}
