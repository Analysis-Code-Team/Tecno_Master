package com.tecnomaster.Analisysis_Code.Repository;

import com.tecnomaster.Analisysis_Code.Entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Integer> {


}
