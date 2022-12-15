package com.example.demorollback.repository;

import com.example.demorollback.domain.Pessoa;
import com.example.demorollback.domain.Setor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SetorRepository extends JpaRepository<Setor, Long> {

}
