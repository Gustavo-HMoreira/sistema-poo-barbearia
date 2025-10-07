/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/*incluir o import java.time.LocalDateTime*/

public class Agendamento {
    
    private int idagendamento;
    private Cliente cliente;
    private Servico servico;
    private Funcionario barbeiroresponsavel;
    private StatusAgendamento statusagendamento;
    
    
    public Agendamento(int idagendamento, Cliente cliente, Servico servico, Funcionario barbeiroresponsavel, StatusAgendamento statusagendamento){
        this.idagendamento = idagendamento;
        this.cliente = cliente;
        this.servico = servico;
        this.barbeiroresponsavel = barbeiroresponsavel;
        this.statusagendamento = statusagendamento;
    }
    
    public int getIdAgendamento(){
        return idagendamento;
    }
    
    public void setIdAgendamento(int idagendamento){
        this.idagendamento = idagendamento;
    }
    
    
    public Cliente getCliente(){
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    
    
    public Servico getServico(){
        return servico;
    }
    
    public void setServico(Servico servico){
        this.servico = servico;
    }
    
    
    public Funcionario getBarbeiroResponsavel(){
        return barbeiroresponsavel;
    }
    
    public void setBarbeiroResponsavel(Funcionario barbeiroresponsavel){
        this.barbeiroresponsavel = barbeiroresponsavel;
    }
    
    
    public StatusAgendamento getStatusAgendamento(){
        return statusagendamento;
    }
    
    public void setStatusAgendamento(StatusAgendamento statusagendamento){
        this.statusagendamento = statusagendamento;
    }    
    
}
