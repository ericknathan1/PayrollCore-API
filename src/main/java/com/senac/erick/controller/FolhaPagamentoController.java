package com.senac.erick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.erick.DTO.request.FolhaPagamentoRequest;
import com.senac.erick.DTO.response.FolhaPagamentoResponse;
import com.senac.erick.service.FolhaPagamentoService;



@RestController
@RequestMapping("/folhapagamento")
public class FolhaPagamentoController {

    @Autowired
    private FolhaPagamentoService folhaPagamentoService;

    @PostMapping("/criar")
    public ResponseEntity<FolhaPagamentoResponse> criarFolhaPagamento(@RequestBody FolhaPagamentoRequest folhaPagamento) {
        FolhaPagamentoResponse response = folhaPagamentoService.criarFolhaPagamento(folhaPagamento);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<FolhaPagamentoResponse>> listarFolhaPorFuncionario(@PathVariable("id") Integer funcionarioId) {
        List<FolhaPagamentoResponse> responses = folhaPagamentoService.listarFolhaPorFuncionario(funcionarioId);
        return ResponseEntity.ok(responses);
    }
    
    
}
