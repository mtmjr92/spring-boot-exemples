package com.example.demorollback.service;

import com.example.demorollback.domain.Erro;
import com.example.demorollback.repository.ErroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErroService {

    @Autowired
    private ErroRepository repository;

    @Transactional
    public Erro salvar(Erro erro) {
        return repository.save(erro);
    }

}
