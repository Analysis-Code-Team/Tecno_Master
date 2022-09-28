package com.tecnomaster.Analisysis_Code.Repository;

import com.tecnomaster.Analisysis_Code.Entities.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface EmpleadoRepositorio extends CrudRepository<Empleado,Integer> {

    @Query(value="SELECT * FROM Empleado where id= ?1", nativeQuery=true)

    public abstract ArrayList<Empleado> findByEmpresa(int id);

    ArrayList<Empleado> findByNombreEmpleado(String nombreEmpleado);
}
