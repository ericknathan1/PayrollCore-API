package com.senac.erick.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.senac.erick.DTO.request.FuncionarioCadastrarRequest;
import com.senac.erick.DTO.request.FuncionarioLoginRequest;
import com.senac.erick.DTO.request.FuncionarioStatusRequest;
import com.senac.erick.DTO.response.FuncionarioResponse;
import com.senac.erick.DTO.response.TokenSecurityResponse;
import com.senac.erick.service.FuncionarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    @Autowired
    private FuncionarioService funcionarioService;

   @PostMapping("/login")
    public ResponseEntity<TokenSecurityResponse> logarUsuario(@Valid @RequestBody FuncionarioLoginRequest request){
        TokenSecurityResponse token = funcionarioService.loginFuncionario(request);
        return new ResponseEntity<>(token,HttpStatus.OK);
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Void> cadastroAdmin(@RequestBody @Valid FuncionarioCadastrarRequest request) {        
        this.funcionarioService.criarFuncionario(request);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioResponse>> listarFuncionarios() {
        return ResponseEntity.ok(funcionarioService.listarFuncionarios());
    }

    @PatchMapping("/status/{id}")
    public ResponseEntity<FuncionarioResponse> mudarStatus(@RequestBody @Valid FuncionarioStatusRequest request, @PathVariable("id")Integer id) {
        FuncionarioResponse response = funcionarioService.mudarStatus(request, id);
        return ResponseEntity.ok(response);
    }
    
}
