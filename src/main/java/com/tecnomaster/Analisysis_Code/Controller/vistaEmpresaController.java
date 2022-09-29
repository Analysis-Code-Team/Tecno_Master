package com.tecnomaster.Analisysis_Code.Controller;

import com.tecnomaster.Analisysis_Code.Entities.Empresa;
import com.tecnomaster.Analisysis_Code.Services.EmpresaServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class vistaEmpresaController {
    @Autowired
    EmpresaServices servicio;

    //Listar todos los empleados
    @GetMapping("/Empresa")
    public String verEmpresa(Model model){
        model.addAttribute("nEmpresa", servicio.listEnterprise());
        model.addAttribute("empresa", new Empresa());
        return "Empresa";
    }

    //Agregar Empresas
    @PostMapping("/Empresa")
    public String nuevaEmpresa(@ModelAttribute("nwEmpresa") Empresa nwEmpresa){
        servicio.create_ActualizarEnterprise(nwEmpresa);
        return "redirect:/Empresa";
    }

    //Editar Empresa
    @GetMapping("/Empresa/editar/{id}")
    public String obtenerEmpresa(@PathVariable("id") int id, Model model){
        model.addAttribute("empresaEditar", servicio.buscarEmpresa(id).get());
        return "editarEmpresa";
    }

    @PostMapping("/Empresa/actualizar/{id}")
    public String actualizarEmpresa(@PathVariable("id") int id, @ModelAttribute("empresaEditar") Empresa empresa){
        Empresa empr = servicio.buscarEmpresa(id).get();
        empr.setNombre(empresa.getNombre());
        empr.setDireccion(empresa.getDireccion());
        empr.setTelefono(empresa.getTelefono());
        empr.setNit(empresa.getNit());
        servicio.create_ActualizarEnterprise(empr);
        return "redirect:/Empresa";
    }

    //Eliminar Empresa
    @GetMapping("/Empresa/eliminar/{id}")
    public String eliminarEmpresa(@PathVariable("id") int id, Model model){
        servicio.eliminarEmpresa(id);
        return "redirect:/Empresa";
    }
}
