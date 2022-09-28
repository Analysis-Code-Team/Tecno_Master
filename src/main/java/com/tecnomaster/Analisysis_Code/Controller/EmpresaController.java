package com.tecnomaster.Analisysis_Code.Controller;

import com.tecnomaster.Analisysis_Code.Entities.Empresa;
import com.tecnomaster.Analisysis_Code.Services.EmpresaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class EmpresaController {
    @Autowired
    EmpresaServices empresaServices;


    //Ver todas las empresas -- Funciona correctamente
    @GetMapping("/enterprises")
    public ArrayList<Empresa> list(){
        return empresaServices.listEnterprise();
    }

    //Buscar empresa por ID -- Funciona Correctamente
    @GetMapping(path = "enterprises/{id}")
    public Empresa buscarEmpresa(@PathVariable("id") int id){
        return this.empresaServices.buscarEmpresa(id);
    }

    //Guardar o Actualizar una nueva Empresa -- Funciona Correctamente
    @PostMapping("/enterprises")
    public Empresa create_ActualizarEnterprise(@RequestBody Empresa emp){
        return this.empresaServices.create_ActualizarEnterprise(emp);
    }

    //Modificar Campos de una empresa -- Revisar Este no sirve
    @PatchMapping("/enterprises/{id}")
    public Empresa create_ActualizarEnterprise(@PathVariable("id") Integer id, @RequestBody Empresa empresa){
      /*  Empresa emp = empresaServices.buscarEmpresa(id);
        emp.setNombre(emp.getNombre());
        emp.setDireccion(emp.getDireccion());
        emp.setTelefono(emp.getTelefono());
        emp.setNit(emp.getNit());*/
        return empresaServices.create_ActualizarEnterprise(empresa);
    }

    //Eliminar una empresa por medio del ID -- Funciona Correctamente
    @DeleteMapping("/enterprises/{id}")
    public String eliminarEmpresa(@PathVariable("id") int id){
        return empresaServices.eliminarEmpresa(id);
    }
}
