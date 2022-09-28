package com.tecnomaster.Analisysis_Code.Controller;

import com.tecnomaster.Analisysis_Code.Entities.Empleado;
import com.tecnomaster.Analisysis_Code.Services.EmpleadoServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmpleadoController
{
    @Autowired
    EmpleadoServices empleadoServices;

    //Faltaría el Pos /users{id}
    //Listar todos los empleados por medio de un Json -- Funciona Correctamente
    @GetMapping("/users")
    public List<Empleado> listar() {
        return empleadoServices.getAllEmpleado();
    }


    //Consultar empleados por ID -- Funciona correctamente
    @GetMapping("/users/{id}")
    public Optional<Empleado> buscarEmpleado(@PathVariable("id") int id)
    {
        return empleadoServices.buscarEmpleado(id);
    }


    // Busca un empleado por medio del nombre del empleado -- Revisar este método a ver si se deja o no se deja debido que no lo piden.
    @GetMapping("/BuscarNombreEmpleado/{nombreEmpleado}")
    public ArrayList<Empleado>  buscarNombreEmpleado(@PathVariable("nombreEmpleado") String nombreEmpleado )
    {
        return empleadoServices.buscarNombreEmpleado(nombreEmpleado);

    }


    //Actualizar Campos de Empleados -- Funciona Correctamente
    @PatchMapping("/users/{id}")
    public Empleado actualizarCampoEmpleado(@PathVariable("id") int id, @RequestBody Empleado empleado){
        Empleado empl=empleadoServices.buscarEmpleado(id).get();
        empl.setNombreEmpleado(empleado.getNombreEmpleado());
        empl.setCorreo(empleado.getCorreo());
        empl.setEmpresa(empleado.getEmpresa());
        empl.setRole(empleado.getRole());
        return empleadoServices.guardar_ActualizarEmpleado(empl);
    }

    //Eliminar Empleados -- Funciona Correctamente
    @DeleteMapping("/users/{id}")
    public String eliminarEmpleado(@PathVariable("id") int id)
    {
        return empleadoServices.eliminarEmpleado(id);

    }
    @PostMapping("/users")
    public String agregarEmpleado(@RequestBody Empleado empleado)
    {
        return empleadoServices.agregarEmpleado(empleado);
    }




}
