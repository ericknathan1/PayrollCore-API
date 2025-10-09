package com.senac.erick.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="funcionario")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
    private int id;
    @Column(name="funcionario_matricula")
    private String matricula;
    @Column(name="funcionario_nome")
    private String nome;
    @Column(name="funcionario_data_nascimento")
    private LocalDate dataNascimento;
    @Column(name="funcionario_chave_acesso")
    private String chaveAcesso;
    @Column(name="funcionario_status")
    private int status;
    @OneToMany(mappedBy="funcionario")
    @JsonIgnore
    private List<FolhaPagamento> folhas;


    @ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.PERSIST)
    @JoinTable(name="funcionario_role",
           joinColumns = @JoinColumn(name = "funcionario_id"),
           inverseJoinColumns = @JoinColumn(name="role_id"))
    @JsonIgnore
    private List<Role> roles;


    

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
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public List<Role> getRoles() {
        return roles;
    }
    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
    public List<FolhaPagamento> getFolhas() {
        return folhas;
    }
    public void setFolhas(List<FolhaPagamento> folhas) {
        this.folhas = folhas;
    }
}
