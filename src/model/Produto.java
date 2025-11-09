package model;

public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private double valorPorUnidade;
    private int quantidadeEstoque;
    
  
    public Produto(int idProduto, String nome, String descricao, double valorUnitario, int quantidadeEstoque){
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.valorPorUnidade = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    
    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public String getNome(){
        return nome;
    }
    

    public void setNome(String nome){
        this.nome = nome;
    }
    
    
    public String getDescricao(){
        return descricao;
    }
    
   
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
   
    public double getValorUnitario(){
        return valorPorUnidade;
    }
    
    
    public void setValorUnitario(double valorUnitario){
        this.valorPorUnidade = valorUnitario;
    }
    
   
    public int getQuantidadeEstoque(){
        return quantidadeEstoque;
    }
    
   
    public void setQuantidadeEstoque(int quantidadeEmEstoque){
        this.quantidadeEstoque = quantidadeEmEstoque;
    }

   
    public void adicionaQuantidade(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

  
    public void removeQuantidade(int quantidade) {
        this.quantidadeEstoque -= quantidade;
    }
    
    
    @Override
    public String toString(){
        return "ID: " + idProduto + ", Nome: " + nome + ", Descrição: " + descricao + ", Valor Unitário: R$" 
               + String.format("%.2f", valorPorUnidade) + ", Estoque: " + quantidadeEmEstoque;
    }
}

