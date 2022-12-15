package com.example.demorollback.repository;

import com.example.demorollback.domain.Empresa;
import com.example.demorollback.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

}
