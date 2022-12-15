package com.example.demorollback.controller;

import com.example.demorollback.domain.Setor;
import com.example.demorollback.service.SetorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/setor")
public class SetorController {

    @Autowired
    private SetorService service;

    @GetMapping
    public ResponseEntity<List<Setor>> buscarTodos() {
        return ResponseEntity.ok(service.buscarTodos());
    }

}
