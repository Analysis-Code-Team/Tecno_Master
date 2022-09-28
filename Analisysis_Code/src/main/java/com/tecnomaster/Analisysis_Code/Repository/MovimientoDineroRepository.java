package com.tecnomaster.Analisysis_Code.Repository;



import com.tecnomaster.Analisysis_Code.Entities.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface MovimientoDineroRepository extends JpaRepository<MovimientoDinero, Integer> {
    //@Query(value ="select * from movimiento_dinero where empleado= ?", nativeQuery = true)
    ArrayList<MovimientoDinero> findByUsuarioId(Integer id);


    //@Query(value ="select * from movimiento_dinero where empresa= ?", nativeQuery = true)
    ArrayList<MovimientoDinero> findByEmpresaId(Integer id);

}