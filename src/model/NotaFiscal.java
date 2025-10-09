package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NotaFiscal {
    
    private int idNotaFiscal;
    private Cliente cliente;
    private List<Servico> servicos;
    private List<Produto> produtos;
    private Funcionario barbeiroresponsavel;
    private LocalDateTime horarioemissao;
    private double valortotal;
    
    public NotaFiscal(int idnotafiscal, Cliente cliente, List<Servico> servicos, List<Produto> produtos, Funcionario barbeiroresponsavel, LocalDateTime horarioemissao, double valortotal){
        this.idNotaFiscal = idnotafiscal;
        this.cliente = cliente;
        this.servicos = servicos != null ? new ArrayList<>(servicos) : new ArrayList<>();
        this.produtos = produtos != null ? new ArrayList<>(produtos) : new ArrayList<>();
        this.barbeiroresponsavel = barbeiroresponsavel;
        this.horarioemissao = horarioemissao;
        this.valortotal = valortotal;
    }

    
    public int getIdNotaFiscal() {
        return idNotaFiscal;
    }
    
    public void setIdNotaFiscal(int idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }

    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public List<Servico> getServicos() {
        return servicos;
    }

    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos;
    }

    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    
    public Funcionario getBarbeiroresponsavel() {
        return barbeiroresponsavel;
    }

    public void setBarbeiroresponsavel(Funcionario barbeiroresponsavel) {
        this.barbeiroresponsavel = barbeiroresponsavel;
    }

    
    public LocalDateTime getHorarioemissao() {
        return horarioemissao;
    }

    public void setHorarioemissao(LocalDateTime horarioemissao) {
        this.horarioemissao = horarioemissao;
    }

    
    public double getValortotal() {
        return valortotal;
    }

    public void setValortotal(double valortotal) {
        this.valortotal = valortotal;
    }
   
    
}
