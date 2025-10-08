package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Transacoes {
    public enum TipoDeTransacao{
        RECEITA("Receitas"),
        DESPESAS("Despesas");
        
        private String descricao;
        
        TipoDeTransacao(String descricao){
            this.descricao = descricao;
        }
        
        public String getDescricao(){
            return descricao;
        }
        
        
    }
    
    private String descricao;
    private TipoDeTransacao tipo;
    private double valor; 
    private LocalDate data;
    
    
    public Transacoes(String descricao, double valor, LocalDate data, TipoDeTransacao tipo){
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public TipoDeTransacao getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setTipo(TipoDeTransacao tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }
    
    @Override
    public String toString(){
        return String.format("Descrição: %s | Tipo da transação: %s | Valor: R$ %.2f | Data: %s",
                descricao, tipo.getDescricao(), valor,
                data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
    }   
    
}
