package com.tecnomaster.Analisysis_Code.Services;
import com.tecnomaster.Analisysis_Code.Entities.Empleado;
import com.tecnomaster.Analisysis_Code.Repository.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoServices {
    @Autowired
     EmpleadoRepositorio empleadoRepositorio;



//Método para ver todos los empleados registrados
    public List<Empleado> getAllEmpleado(){
        List<Empleado> empleadosList   = new ArrayList<>();
        empleadoRepositorio.findAll().forEach(empleado -> empleadosList.add(empleado));
        return empleadosList;
    }

    //Método para buscar empleado por el ID
    public Optional<Empleado> buscarEmpleado(int id)
    {
        return  empleadoRepositorio.findById(id);
    }




    public  ArrayList<Empleado> buscarNombreEmpleado(String nombreEmpleado)
    {
        //return  repositorio.findByNombre(nombre);
        return empleadoRepositorio.findByNombreEmpleado(nombreEmpleado);
    }

    //Método para buscar empleado por empresa
    public ArrayList<Empleado>BuscarEmpPorEmpresa(int id){
        return empleadoRepositorio.findByEmpresa(id);
    }

    //Método para guardar o actualizar registro en Empleados


    public Empleado guardar_ActualizarEmpleado(Empleado empleado){
        return empleadoRepositorio.save(empleado);
    }

//Método para eliminar Empleado
    public String eliminarEmpleado(int id)
    {
        if(buscarEmpleado(id).isPresent())
        {
            empleadoRepositorio.deleteById(id);
            return "Empleado eliminado";
        }
        else
        {
            return "Empleado no eliminado";
        }

    }

    public String agregarEmpleado(Empleado empleado){
        if(!buscarEmpleado(empleado.getId()).isPresent()) {
            empleadoRepositorio.save(empleado);
            return "Empleado  Registrado exitosamente.";
        }else{
            return "El Empleado ya existe. " ;
        }
    }

    public String actualizar(Empleado eplActual){
        empleadoRepositorio.save(eplActual);
        return "Guardado";
    }

}
