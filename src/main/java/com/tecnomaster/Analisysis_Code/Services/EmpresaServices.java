package com.tecnomaster.Analisysis_Code.Services;

import com.tecnomaster.Analisysis_Code.Entities.Empresa;
import com.tecnomaster.Analisysis_Code.Repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class EmpresaServices {
   @Autowired
    EmpresaRepository empresaRepository;


    //listar empresas
    public ArrayList<Empresa> listEnterprise(){
        return (ArrayList<Empresa>) empresaRepository.findAll();

    }
    public Optional<Empresa> buscarEmpresa(int id){
        return empresaRepository.findById(id);
    }


    //POST ENTERPRISE
    public Empresa create_ActualizarEnterprise(Empresa empresa){
        Empresa emp=empresaRepository.save(empresa);
        return emp;
    }



    //DEL RUTA ENTERPRISE/ID);
    public String eliminarEmpresa(int id){
        if(empresaRepository.findById(id).isPresent()) {
            empresaRepository.deleteById(id);
            return "Empresa eliminada";
        } else{
                return"Empresa no existe";
            }
        }


}