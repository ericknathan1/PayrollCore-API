package com.senac.erick.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.senac.erick.DTO.request.FuncionarioCadastrarRequest;
import com.senac.erick.DTO.request.FuncionarioLoginRequest;
import com.senac.erick.DTO.request.FuncionarioStatusRequest;
import com.senac.erick.DTO.response.FuncionarioResponse;
import com.senac.erick.DTO.response.TokenSecurityResponse;
import com.senac.erick.config.SecurityConfig;
import com.senac.erick.entity.Funcionario;
import com.senac.erick.entity.Role;
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

    public List<Funcionario> listarFuncionarios(){
        List<Funcionario> funcionarios = funcionarioRepository.findAll();
        return funcionarios;
    }

    public FuncionarioResponse mudarStatus(FuncionarioStatusRequest request, Integer id){
        Funcionario funcionario = funcionarioRepository.funcionarioPorId(id);
        funcionario.setStatus(request.getStatus());
        funcionarioRepository.save(funcionario);
        FuncionarioResponse response = modelMapper.map(funcionario, FuncionarioResponse.class);
        return response;
    }

}
