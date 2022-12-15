package com.example.demorollback.repository;

import com.example.demorollback.domain.Erro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ErroRepository extends JpaRepository<Erro, Long> {
}
