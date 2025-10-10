package com.senac.erick.DTO.request;

public class FolhaPagamentoRequest {

    private int mes;
    private int ano;
    private int salario;
    private int funcionarioId;
    
    
    public int getMes() {
        return mes;
    }
    public void setMes(int mes) {
        this.mes = mes;
    }
    public int getAno() {
        return ano;
    }
    public void setAno(int ano) {
        this.ano = ano;
    }
    public int getSalario() {
        return salario;
    }
    public void setSalario(int salario) {
        this.salario = salario;
    }
    public int getFuncionarioId() {
        return funcionarioId;
    }
    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    

}
