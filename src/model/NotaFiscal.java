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
    private Funcionario barbeiroResponsavel;
    private LocalDateTime dataEmissao;
    private double valorTotal;
    private String formaPagamento;
    
    
    public NotaFiscal(int idNotaFiscal, Cliente cliente, List<Servico> servicos, List<Produto> produtos, Funcionario barbeiroResponsavel, LocalDateTime dataEmissao) {
        this.idNotaFiscal = idNotaFiscal;
        this.cliente = cliente;
        this.servicos = servicos != null ? new ArrayList<>(servicos) : new ArrayList<>();
        this.produtos = produtos != null ? new ArrayList<>(produtos) : new ArrayList<>();
        this.barbeiroResponsavel = barbeiroResponsavel;
        this.dataEmissao = dataEmissao;
        this.valorTotal = calcularTotal();
        this.formaPagamento = "Não foi informada"; 
    }
    
    public int getIdNotaFiscal() {
        return idNotaFiscal;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public List<Servico> getServicos() {
        return new ArrayList<>(servicos);
    }
    
    public List<Produto> getProdutos() {
        return new ArrayList<>(produtos);
    }
    
    public Funcionario getBarbeiroResponsavel() {
        return barbeiroResponsavel;
    }
    
    public LocalDateTime getDataEmissao() {
        return dataEmissao;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public void setIdNotaFiscal(int idNotaFiscal) {
        this.idNotaFiscal = idNotaFiscal;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void setServicos(List<Servico> servicos) {
        this.servicos = servicos != null ? new ArrayList<>(servicos) : new ArrayList<>();
        this.valorTotal = calcularTotal();
    }
    
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos != null ? new ArrayList<>(produtos) : new ArrayList<>();
        this.valorTotal = calcularTotal();
    }
    
    public void setBarbeiroResponsavel(Funcionario barbeiroResponsavel) {
        this.barbeiroResponsavel = barbeiroResponsavel;
    }
    
    public void setDataEmissao(LocalDateTime dataEmissao) {
        this.dataEmissao = dataEmissao;
    }
    
    
    public void adicionarServico(Servico servico) {
        if (servico != null) {
            this.servicos.add(servico);
            this.valorTotal = calcularTotal();
        }
    }
    
  
    public void adicionarProduto(Produto produto) {
        if (produto != null) {
            this.produtos.add(produto);
            this.valorTotal = calcularTotal();
        }
    }
    
    
    public double calcularTotal() {
        double total = 0.0;
        for (Servico s : servicos) {
            total += s.getPreco();
        }
        for (Produto p : produtos) {
            total += p.getValorUnitario() * p.getQuantidadeEstoque();
        }
        return total;
    }
    
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder sb = new StringBuilder();
        
        sb.append("============================================================\n");
        sb.append("                    NOTA FISCAL #").append(idNotaFiscal).append("\n");
        sb.append("============================================================\n");
        sb.append("Cliente: ").append(cliente.getNome()).append(" (CPF: ").append(cliente.getCpf().getNumeroCpf()).append(")\n");
        sb.append("Barbeiro Responsável: ").append(barbeiroResponsavel.getNome()).append("\n");
        sb.append("Data de Emissão: ").append(dataEmissao.format(formatter)).append("\n");
        sb.append("------------------------------------------------------------\n");
        
        if (!servicos.isEmpty()) {
            sb.append("SERVIÇOS:\n");
            for (Servico servico : servicos) {
                sb.append("- ").append(servico.getNomeServico()).append(" (R$ ").append(String.format("%.2f", servico.getPreco())).append(")\n");
            }
            sb.append("------------------------------------------------------------\n");
        }
        
        if (!produtos.isEmpty()) {
            sb.append("PRODUTOS:\n");
            for (Produto produto : produtos) {
                sb.append("- ").append(produto.getNome()).append(" (Qtde: ").append(produto.getQuantidadeEstoque()).append(", R$ ").append(String.format("%.2f", produto.getPrecoUnidade())).append(" cada)\n");
            }
            sb.append("------------------------------------------------------------\n");
        }
        
        sb.append("Forma de Pagamento: ").append(formaPagamento).append("\n");
        sb.append("VALOR TOTAL: R$ ").append(String.format("%.2f", valorTotal)).append("\n");
        sb.append("============================================================\n");
        
        return sb.toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        NotaFiscal that = (NotaFiscal) obj;
        return idNotaFiscal == that.idNotaFiscal;
    }
    
    @Override
    public int hashCode() {
        return Integer.hashCode(idNotaFiscal);
    }
}

