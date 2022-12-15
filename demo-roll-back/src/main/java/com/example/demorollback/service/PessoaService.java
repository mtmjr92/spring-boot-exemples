package com.example.demorollback.service;

import com.example.demorollback.domain.Empresa;
import com.example.demorollback.domain.Pessoa;
import com.example.demorollback.domain.Setor;
import com.example.demorollback.dto.PessoaDTO;
import com.example.demorollback.mapper.PessoaMapper;
import com.example.demorollback.repository.EmpresaRepository;
import com.example.demorollback.repository.PessoaRepository;
import com.example.demorollback.repository.SetorRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.List;
import java.util.Set;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private SetorRepository setorRepository;

    @Autowired
    private PessoaMapper pessoaMapper;

    public List<Pessoa> buscarTodos() {
        return repository.findAll();
    }

    @Transactional
    public Pessoa salvar(Pessoa pessoa) {
        return repository.save(pessoa);
    }

    public PessoaDTO atualizar(Long id, PessoaDTO dto) {
        Pessoa pessoa = repository.findById(id).orElseThrow();
        Pessoa pessoaToEntity = pessoaMapper.toEntity(dto);

        BeanUtils.copyProperties(pessoaToEntity, pessoa, "id");

        return pessoaMapper.toDTO(repository.save(pessoa));
    }

    public void deletar(Pessoa pessoa) {
        repository.delete(pessoa);
    }

}
