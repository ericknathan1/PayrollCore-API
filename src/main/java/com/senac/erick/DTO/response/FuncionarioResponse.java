package com.senac.erick.DTO.response;

import java.util.List;

import com.senac.erick.enums.RoleName;

public class FuncionarioResponse {

    private int id;
    private String matricula;
    private String nome;
    private String dataNascimento;
    private int status;
    private List<FolhaPagamentoResponse> folhas;
    private List<RoleName> roles;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public List<RoleName> getRoles() {
        return roles;
    }
    public void setRoles(List<RoleName> roles) {
        this.roles = roles;
    }
    public List<FolhaPagamentoResponse> getFolhas() {
        return folhas;
    }
    public void setFolhas(List<FolhaPagamentoResponse> folhas) {
        this.folhas = folhas;
    }
    
}
