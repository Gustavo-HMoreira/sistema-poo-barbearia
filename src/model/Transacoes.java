package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Classe auxiliar para representar uma transação financeira.
 */
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
    
    /**
     * Construtor que cria uma nova instância de Transacao.
     * 
     * @param descricao Descrição da transação
     * @param valor Valor da transação
     * @param data Data da transação
     * @param tipo Tipo da transação (RECEITA ou DESPESA)
     */
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
    
    /**
     * Retorna a descrição da transação.
     * 
     * @return A descrição da transação
     */
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Define a descrição da transação.
     * 
     * @param descricao A nova descrição da transação
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    /**
     * Retorna o tipo da transação.
     * 
     * @return O tipo da transação
     */
    public TipoTransacao getTipo() {
        return tipo;
    }
    
    /**
     * Define o tipo da transação.
     * 
     * @param tipo O novo tipo da transação
     */
    public void setTipo(TipoTransacao tipo) {
        this.tipo = tipo;
    }
    
    /**
     * Retorna o valor da transação.
     * 
     * @return O valor da transação
     */
    public double getValor() {
        return valor;
    }
    
    /**
     * Define o valor da transação.
     * 
     * @param valor O novo valor da transação
     */
    public void setValor(double valor) {
        this.valor = valor;
    }
    
    /**
     * Retorna a data da transação.
     * 
     * @return A data da transação
     */
    public LocalDate getData() {
        return data;
    }
    
    /**
     * Define a data da transação.
     * 
     * @param data A nova data da transação
     */
    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    /**
     * Retorna uma representação em String desta transação financeira.
     * O formato inclui descrição, tipo, valor e data.
     * 
     * @return Uma representação em String da transação
     */
    @Override
    public String toString() {
        return String.format("Descrição: %s | Tipo: %s | Valor: R$ %.2f | Data: %s | Forma Pagamento: %s",
                descricao, tipo.getDescricao(), valor,
                data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), formaPagamento);
    }
}

