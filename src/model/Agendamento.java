package model;

import java.time.LocalDateTime;

/**
 * Representa um agendamento de serviço na barbearia.
 */
public class Agendamento {
    
    private int idAgendamento;
    private Cliente cliente;
    private Servico servico;
    private Funcionario barbeiroResponsavel;
    private LocalDateTime dataHora;
    private StatusAgendamento statusAgendamento;
    
    /**
     * Construtor da classe Agendamento.
     * Inicializa um novo agendamento com as informações necessárias.
     *
     * @param idAgendamento         Código do agendamento.
     * @param cliente               Cliente que agendou o serviço.
     * @param servico               Serviço agendado.
     * @param barbeiroResponsavel   Barbeiro que realizará o serviço.
     * @param dataHora              Data e hora do agendamento.
     * @param statusAgendamento     Situação em que se encontra o agendamento.
     */
    public Agendamento(int idAgendamento, Cliente cliente, Servico servico, Funcionario barbeiroResponsavel, LocalDateTime dataHora, StatusAgendamento statusAgendamento){
        this.idAgendamento = idAgendamento;
        this.cliente = cliente;
        this.servico = servico;
        this.barbeiroResponsavel = barbeiroResponsavel;
        this.dataHora = dataHora;
        this.statusAgendamento = statusAgendamento;
    }
    
    /**
     * Obtém o número de agendamento.
     * 
     * @return Número de agendamento.
     */
    public int getIdAgendamento(){
        return idAgendamento;
    }
    
    /**
     * Define um número de agendamento.
     * 
     * @param idAgendamento Novo número de agendamento.
     */
    public void setIdAgendamento(int idAgendamento){
        this.idAgendamento = idAgendamento;       
    }
    
    /**
     * Obtém o cliente do agendamento.
     * 
     * @return Cliente do agendamento.
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * Define o cliente do agendamento.
     * 
     * @param cliente Novo cliente do agendamento.
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * Obtém o serviço agendado.
     * 
     * @return Serviço agendado.
     */
    public Servico getServico() {
        return servico;
    }

    /**
     * Define o serviço agendado.
     * 
     * @param servico Novo serviço agendado.
     */
    public void setServico(Servico servico) {
        this.servico = servico;
    }

    /**
     * Obtém o barbeiro responsável pelo agendamento.
     * 
     * @return Barbeiro responsável.
     */
    public Funcionario getBarbeiroResponsavel(){
        return barbeiroResponsavel;
    }
    
    /**
     * Define o barbeiro responsável pelo agendamento.
     * 
     * @param barbeiroResponsavel Novo barbeiro responsável.
     */
    public void setBarbeiroResponsavel(Funcionario barbeiroResponsavel){
        this.barbeiroResponsavel = barbeiroResponsavel;
    }
    
    /**
     * Obtém a data e a hora do agendamento.
     * 
     * @return Data e Hora do agendamento.
     */
    public LocalDateTime getDataHora(){
        return dataHora;
    } 
    
    /**
     * Define a data e a hora do agendamento.
     * 
     * @param dataHora Nova data e hora do agendamento.
     */
    public void setDataHora(LocalDateTime dataHora){
        this.dataHora = dataHora;
    }
    
    /**
     * Obtém o status atual do agendamento.
     * 
     * @return Status do agendamento.
     */
    public StatusAgendamento getStatusAgendamento(){
        return statusAgendamento;
    }
    
    /**
     * Define o status do agendamento.
     * 
     * @param statusAgendamento Novo status do agendamento.
     */
    public void setStatusAgendamento(StatusAgendamento statusAgendamento){
        this.statusAgendamento = statusAgendamento;
    }
    
    /**
     * Sobrescreve o método toString para mostrar uma mensagem confirmando o agendamento.
     * 
     * @return Mensagem com detalhes do agendamento.
     */
    @Override
    public String toString() {
        return "Agendamento ID: " + idAgendamento + ", Cliente: " + cliente.getNome() + ", Serviço: " + servico.getNomeServico() 
               + ", Barbeiro: " + barbeiroResponsavel.getNome() + ", Data/Hora: " + dataHora + ", Status: " + statusAgendamento.getDescricao();
    }
}

