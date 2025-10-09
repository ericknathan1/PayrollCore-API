package com.senac.erick.DTO.request;

public class FolhaPagamentoRequest {

    private String mes;
    private String ano;
    private int salario;
    private int funcionarioId;
    
    public String getMes() {
        return mes;
    }
    public void setMes(String mes) {
        this.mes = mes;
    }
    public String getAno() {
        return ano;
    }
    public void setAno(String ano) {
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
