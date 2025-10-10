
package model;

import java.time.LocalDateTime;

public class Agendamento {
    
    private int idAgendamento;
    private Cliente cliente;
    private Servico servico;
    private Funcionario barbeiroResponsavel;
    private LocalDateTime dataHora;
    private StatusAgendamento statusAgendamento;
    
    
    public Agendamento(int idAgendamento, Cliente cliente, Servico servico, Funcionario barbeiroResponsavel, LocalDateTime dataHora, StatusAgendamento statusAgendamento){
        this.idAgendamento = idAgendamento;
        this.cliente = cliente;
        this.servico = servico;
        this.barbeiroResponsavel = barbeiroResponsavel;
        this.dataHora = dataHora;
        this.statusAgendamento = statusAgendamento;
    }
    
    public int getIdAgendamento(){
        return idAgendamento;
    }
    
    public void setIdAgendamento(int idagendamento){
        this.idAgendamento = idagendamento;
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
        return barbeiroResponsavel;
    }
    
    public void setBarbeiroResponsavel(Funcionario barbeiroresponsavel){
        this.barbeiroResponsavel = barbeiroresponsavel;
    }
    
    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
    public StatusAgendamento getStatusAgendamento(){
        return statusAgendamento;
    }
    
    public void setStatusAgendamento(StatusAgendamento statusagendamento){
        this.statusAgendamento = statusagendamento;
    }    

    @Override
    public String toString() {
        return "Agendamento ID: " + idAgendamento + ", Cliente: " + cliente.getNome() + ", Serviço: " + servico.getNomeServico() + ", Barbeiro: " + barbeiroResponsavel.getNome() + ", Data/Hora: " + dataHora + ", Status: " + statusAgendamento.getDescricao();
    }
    
}
