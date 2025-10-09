package com.senac.erick.DTO.request;

public class FuncionarioLoginRequest {
    private String matricula;
    private String chaveAcesso;
    
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getChaveAcesso() {
        return chaveAcesso;
    }
    public void setChaveAcesso(String chaveAcesso) {
        this.chaveAcesso = chaveAcesso;
    }

    
}
