package model;

public class Produto {
    
    private String nome;
    private String descricao;
    private String idproduto;
    private double precounidade;
    private int quantidadeestoque;
    
    
    public Produto(String nome, String descricao, String idproduto, double precounidade, int quantidadeestoque){
        this.nome = nome;
        this.descricao = descricao;
        this.idproduto = idproduto;
        this.precounidade = precounidade;
        this.quantidadeestoque = quantidadeestoque;
        
        
        
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
    
    
    public String getIdProduto(){
        return idproduto;
    }
    
    public void setIdProduto(String idproduto){
        this.idproduto = idproduto;
    }
    
    
    public double getPrecoUnidade(){
        return precounidade;
    }
    
    public void setPrecoUnidade(double precounidade){
        this.precounidade = precounidade;
    }
    
    
    public int getQuantidadeEstoque(){
        return quantidadeestoque;
    }
    
    public void setQuantidadeEstoque(int quantidadeestoque){
        this.quantidadeestoque = quantidadeestoque;
    }
}

