package com.tecnomaster.Analisysis_Code.Controller;

import com.tecnomaster.Analisysis_Code.Entities.Empleado;
import com.tecnomaster.Analisysis_Code.Services.EmpleadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class vistaEmpleadoController {
    @Autowired
    EmpleadoServices servicio;

    //Agregar Empleados
    @PostMapping("/Empleado")
    public String nuevoEmpleado(@ModelAttribute("nwEmpleado") Empleado nwEmpleado){
        servicio.agregarEmpleado(nwEmpleado);
        return "redirect:/Empleado";
    }

    //Listar todos los empleados Empleados Funcionando
    @GetMapping("/Empleado")
    public String verEmpleados(Model model){
        //List<Empleado> listaEmp = this.servicio.getAllEmpleado();
        model.addAttribute("nEmpleados", servicio.getAllEmpleado());
        //model.addAttribute("lista", listaEmp);
        model.addAttribute("empleado", new Empleado());
        return "Empleado";
    }

    //Editar Empleados
    @GetMapping("/Empleado/editar/{id}")
    public String obtenerEmpleado(@PathVariable("id") int id, Model model){
        model.addAttribute("empleadoEditar", servicio.buscarEmpleado(id).get());
        return "editarEmpleado";
    }

    @PostMapping("/Empleado/actualizar/{id}")
    public String actualizarEmpleado(@PathVariable("id") int id, @ModelAttribute("empleadoEditar") Empleado empleado){
        Empleado epl = servicio.buscarEmpleado(id).get();
        epl.setNombreEmpleado(empleado.getNombreEmpleado());
        epl.setCorreo(empleado.getCorreo());
        epl.setRole(empleado.getRole());
        epl.setEmpresa(empleado.getEmpresa());
        servicio.actualizar(epl);
        return "redirect:/Empleado";
    }


    //Eliminar Empleado Funcionando
    @GetMapping("/Empleado/eliminar/{id}")
    public String eliminarEmpleado(@PathVariable("id") int id, Model model)
    {
        servicio.eliminarEmpleado(id);
        return "redirect:/Empleado";

    }
}
