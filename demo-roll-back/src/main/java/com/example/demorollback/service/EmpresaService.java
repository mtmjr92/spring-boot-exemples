package com.example.demorollback.service;

import com.example.demorollback.domain.Empresa;
import com.example.demorollback.domain.Pessoa;
import com.example.demorollback.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;

    public List<Empresa> buscarTodos() {
        return repository.findAll();
    }

    @Transactional
    public Empresa salvar(Empresa empresa) {
        return repository.save(empresa);
    }

    public void deletar(Empresa empresa) {
        repository.delete(empresa);
    }
}
