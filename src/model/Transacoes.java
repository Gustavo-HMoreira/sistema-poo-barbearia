package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacoes {
    public enum TipoTransacao {
        RECEITA("Receita"),
        DESPESA("Despesa");

        private String descricao;

        TipoTransacao(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }

    private String descricao;
    private TipoTransacao tipo;
    private double valor;
    private LocalDate data;
    private String formaPagamento;
    
    
    public Transacoes(String descricao, double valor, LocalDate data, TipoTransacao tipo) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.formaPagamento = "Não Aplicável";
    }

    public Transacoes(String descricao, double valor, LocalDate data, TipoTransacao tipo, String formaPagamento) {
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
        this.formaPagamento = formaPagamento;
    }
    
 
    public String getDescricao() {
        return descricao;
    }
    
   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
   
    public TipoTransacao getTipo() {
        return tipo;
    }
    
   
    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }
    
  
    public double getValor() {
        return valor;
    }
    

    public void setValor(double valor) {
        this.valor = valor;
    }
    
  
    public LocalDate getData() {
        return data;
    }
    
  
    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
  
    @Override
    public String toString() {
        return String.format("Descrição: %s | Tipo: %s | Valor: R$ %.2f | Data: %s | Forma Pagamento: %s",
                descricao, tipo.getDescricao(), valor,
                data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), formaPagamento);
    }
}

