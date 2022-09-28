package com.tecnomaster.Analisysis_Code.Services;


import com.tecnomaster.Analisysis_Code.Entities.MovimientoDinero;
import com.tecnomaster.Analisysis_Code.Repository.MovimientoDineroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.Optional;


@Service
public class MovimientoDineroServicios {

    //Servico de empleado
    @Autowired
    EmpleadoServices serviEmpleado;

    //Instanciar Repositorio
    @Autowired
    MovimientoDineroRepository movimientoDineroRepository;

    //Todos los movimientos
    public ArrayList<MovimientoDinero> movimientos(){
        return (ArrayList<MovimientoDinero>) movimientoDineroRepository.findAll();
    }

    //Servicio para consultar todos los movimientos de dinero por Empleado
    public ArrayList<MovimientoDinero> buscarMovimientosDinero(Integer idEmpleado){
        return (ArrayList<MovimientoDinero>) movimientoDineroRepository.findByUsuarioId(idEmpleado);
    }


    //Servicio para consultar todos los movimientos de dinero por empresa
    public ArrayList<MovimientoDinero> buscarPorEmpresa(Integer idEmpleado){
        return (ArrayList<MovimientoDinero>) movimientoDineroRepository.findByEmpresaId(idEmpleado);
    }


    //   //Servicio para consultar 1 solo movimientos de dinero por ID
    public Optional<MovimientoDinero> consultaMovimientoDineroID(int id){
        return movimientoDineroRepository.findById(id);
    }



    //Servicio para crear movimientos de dinero
    public String crearMovimientoDinero(MovimientoDinero newmd, int idEmpleado){
        newmd.setUsuario(serviEmpleado.buscarEmpleado(idEmpleado).get());
        newmd.setEmpresa(serviEmpleado.buscarEmpleado(idEmpleado).get().getEmpresa());
        movimientoDineroRepository.save(newmd);
        return "Movimiento creado Exitosamente";
    }


//    Servicio para actualizar movimiento de dinero

    public String actualizarMovimientoDinero(int id, Map<Object, Object> actuMD){
        if (movimientoDineroRepository.findById(id).isPresent()){
            MovimientoDinero md = movimientoDineroRepository.findById(id).get();
            actuMD.forEach((key, value)->{
                Field campo= ReflectionUtils.findField(MovimientoDinero.class,(String) key);
                campo.setAccessible(true);
                ReflectionUtils.setField(campo, md, value);
            });

            md.setFechaActualizacion(new Date());
            movimientoDineroRepository.save(md);
            return "Movimiento Actualizado con Exito";
        }else {return "Movimiento de dinero no existe";}
    }

//    Servicio para eliminar movimiento de dinero

    public String eliminarMd(int id){
        if(movimientoDineroRepository.findById(id).isPresent()){
            movimientoDineroRepository.deleteById(id);
            return "Movimiento Eliminado Correctamente";
        }else{return "Movimiento de dinero no existe";}
    }

    public String actulizar(MovimientoDinero mvActu){
        movimientoDineroRepository.save(mvActu);
        return "Cambios guardados";
    }

}
