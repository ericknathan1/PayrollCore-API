package com.senac.erick.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.senac.erick.DTO.request.FuncionarioCadastrarRequest;
import com.senac.erick.DTO.request.FuncionarioLoginRequest;
import com.senac.erick.DTO.request.FuncionarioStatusRequest;
import com.senac.erick.DTO.response.FolhaPagamentoResponse;
import com.senac.erick.DTO.response.FuncionarioResponse;
import com.senac.erick.DTO.response.TokenSecurityResponse;
import com.senac.erick.config.SecurityConfig;
import com.senac.erick.entity.Funcionario;
import com.senac.erick.entity.Role;
import com.senac.erick.enums.RoleName;
import com.senac.erick.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired 
    private RoleService roleService;

    @Autowired
    private SecurityConfig securityConfiguration;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private JwtTokenService jwtTokenService;

    public void criarFuncionario (FuncionarioCadastrarRequest request){
        Funcionario funcionario = modelMapper.map(request,Funcionario.class);
        funcionario.setChaveAcesso(securityConfiguration.passwordEncoder().encode(request.getChaveAcesso()));
        funcionario.setStatus(1);
        List<Role> roles = roleService.getRolesByName(request.getRoles());
        funcionario.setRoles(roles);
        this.funcionarioRepository.save(funcionario);
    }

    public TokenSecurityResponse loginFuncionario(FuncionarioLoginRequest request){
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                new UsernamePasswordAuthenticationToken(request.getMatricula(), request.getChaveAcesso());
        Authentication authentication = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        return new TokenSecurityResponse(jwtTokenService.generateToken(userDetails));
    }

    public List<FuncionarioResponse> listarFuncionarios(){
        List<Funcionario> funcionarios = this.funcionarioRepository.findAll();
        List<FuncionarioResponse> response = new ArrayList<>();
        for (Funcionario funcionario : funcionarios) {

            FuncionarioResponse funcionarioResponse = modelMapper.map(funcionario, FuncionarioResponse.class);
            

            List<RoleName> roles = funcionario.getRoles().stream()
                    .map(role -> role.getName())
                    .collect(Collectors.toList());
            
            if(!roles.isEmpty()){
                funcionarioResponse.setRoles(roles);
            }
            

            List<FolhaPagamentoResponse> folhas = funcionario.getFolhas().stream()
                    .map(folha -> modelMapper.map(folha, FolhaPagamentoResponse.class))
                    .collect(Collectors.toList());

            if(!folhas.isEmpty()){
                funcionarioResponse.setFolhas(folhas);
            }

            response.add(funcionarioResponse);
        }
        return response;
    }

    public FuncionarioResponse mudarStatus(FuncionarioStatusRequest request, Integer id){
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(id);
        funcionario.setStatus(request.getStatus());
        funcionarioRepository.save(funcionario);
        FuncionarioResponse response = modelMapper.map(funcionario, FuncionarioResponse.class);
        return response;
    }

}
