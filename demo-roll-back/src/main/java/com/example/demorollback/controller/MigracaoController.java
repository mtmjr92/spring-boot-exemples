package com.example.demorollback.controller;

import com.example.demorollback.domain.Pessoa;
import com.example.demorollback.dto.MigracaoDTO;
import com.example.demorollback.repository.EmpresaRepository;
import com.example.demorollback.repository.PessoaRepository;
import com.example.demorollback.repository.SetorRepository;
import com.example.demorollback.service.MigracaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/migracao/pessoa")
public class MigracaoController {

    @Autowired
    private MigracaoService service;

    @Autowired
    private PessoaRepository repository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Autowired
    private SetorRepository setorRepository;

    @PostMapping
    public ResponseEntity<MigracaoDTO> salvar(@RequestBody MigracaoDTO migracao) {
        return ResponseEntity.ok(service.salvar(migracao));
    }

    @PostMapping("try-catch")
    public ResponseEntity<MigracaoDTO> salvarTryCatch(@RequestBody List<MigracaoDTO> dto) {
        return ResponseEntity.ok(service.salvarTryCatch(dto));
    }

}
