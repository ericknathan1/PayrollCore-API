package com.senac.erick.DTO.request;

import java.time.LocalDate;
import java.util.List;

import com.senac.erick.enums.RoleName;

public class FuncionarioCadastrarRequest {
    private String matricula;
    private String nome;
    private LocalDate dataNascimento;
    private String chaveAcesso;
    private List<RoleName> roles;

    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getChaveAcesso() {
        return chaveAcesso;
    }
    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }
    public List<RoleName> getRoles() {
        return roles;
    }
    public void setRoles(List<RoleName> roles) {
        this.roles = roles;
    }

    

    
}
