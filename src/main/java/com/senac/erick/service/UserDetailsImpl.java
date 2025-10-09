package com.senac.erick.service;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.senac.erick.entity.Funcionario;

public class UserDetailsImpl implements UserDetails{
    private Funcionario funcionario;

    public UserDetailsImpl(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

     @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return funcionario.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }

    public Integer getId() {
        return this.funcionario.getId();
    }

    public Funcionario getFuncionario() {
        return this.funcionario;
    }

    @Override
    public String getPassword() {
        return funcionario.getChaveAcesso();
    }
    @Override
    public String getUsername() {
        return funcionario.getMatricula();
    }
    
    
}
