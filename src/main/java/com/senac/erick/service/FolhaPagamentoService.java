package com.senac.erick.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.senac.erick.DTO.request.FolhaPagamentoRequest;
import com.senac.erick.DTO.response.FolhaPagamentoResponse;
import com.senac.erick.entity.FolhaPagamento;
import com.senac.erick.entity.Funcionario;
import com.senac.erick.repository.FolhaPagamentoRepository;
import com.senac.erick.repository.FuncionarioRepository;

@Service
public class FolhaPagamentoService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private FolhaPagamentoRepository folhaPagamentoRepository;
    @Autowired
    private ModelMapper modelMapper;

    public FolhaPagamentoResponse criarFolhaPagamento(FolhaPagamentoRequest request) {
        FolhaPagamento folhaPagamento = new FolhaPagamento();
        folhaPagamento.setMes(request.getMes());
        folhaPagamento.setAno(request.getAno());
        folhaPagamento.setSalario(request.getSalario());
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(request.getFuncionarioId());
        folhaPagamento.setFuncionario(funcionario);
        folhaPagamentoRepository.save(folhaPagamento);
        return modelMapper.map(folhaPagamento, FolhaPagamentoResponse.class);
    }
    
    public List<FolhaPagamentoResponse> listarFolhaPorFuncionario(Integer funcionarioId) {
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(funcionarioId);
        List<FolhaPagamento> folhas = funcionario.getFolhas();
        List<FolhaPagamentoResponse> responses = folhas.stream().map(folha -> modelMapper.map(folha, FolhaPagamentoResponse.class))
        .collect(Collectors.toList());
        return responses;
    }

}
