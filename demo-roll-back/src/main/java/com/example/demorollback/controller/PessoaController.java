package com.example.demorollback.controller;

import com.example.demorollback.domain.Pessoa;
import com.example.demorollback.dto.PessoaDTO;
import com.example.demorollback.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/pessoa")
public class PessoaController {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

    @PostMapping
    public ResponseEntity<Pessoa> salvar(@RequestBody Pessoa pessoa) {
        return ResponseEntity.ok(service.salvar(pessoa));
    }

    @PutMapping("{id}")
    public ResponseEntity<PessoaDTO> atualizar(@RequestBody final PessoaDTO pessoa, @PathVariable("id") Long id) {
        return ResponseEntity.ok(service.atualizar(id, pessoa));
    }

}
