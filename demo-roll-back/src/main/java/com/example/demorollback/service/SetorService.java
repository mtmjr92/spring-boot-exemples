package com.example.demorollback.service;

import com.example.demorollback.domain.Empresa;
import com.example.demorollback.domain.Setor;
import com.example.demorollback.repository.EmpresaRepository;
import com.example.demorollback.repository.SetorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SetorService {

    @Autowired
    private SetorRepository repository;

    public List<Setor> buscarTodos() {
        return repository.findAll();
    }

    @Transactional
    public Setor salvar(Setor setor) {
        return repository.save(setor);
    }

    public void deletar(Setor setor) {
        repository.delete(setor);
    }
}
