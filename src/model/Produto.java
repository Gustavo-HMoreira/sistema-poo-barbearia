package model;

/**
 * Representa um produto vendido na barbearia (balm, creme, shampoo, etc.).
 */
public class Produto {
    private int idProduto;
    private String nome;
    private String descricao;
    private double valorUnitario;
    private int quantidadeEstoque;
    
    /**
     * Construtor da classe {@code Produto}.
     * Inicializa um novo produto com ID, nome, descrição, valor unitário e quantidade em estoque.
     * 
     * @param idProduto             ID do produto.
     * @param nome                  Nome do produto.
     * @param descricao             Descrição do produto.
     * @param valorUnitario         Valor unitário de venda do produto.
     * @param quantidadeEstoque   Quantidade disponível no estoque.
     */
    public Produto(int idProduto, String nome, String descricao, double valorUnitario, int quantidadeEstoque){
        this.idProduto = idProduto;
        this.nome = nome;
        this.descricao = descricao;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    /**
     * Obtém o ID do produto.
     * 
     * @return ID do produto.
     */
    public int getIdProduto() {
        return idProduto;
    }

    /**
     * Define o ID do produto.
     * 
     * @param idProduto Novo ID do produto.
     */
    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    /**
     * Obtém o nome do produto.
     * 
     * @return Nome do produto.
     */
    public String getNome(){
        return nome;
    }
    
    /**
     * Define o nome do produto.
     * 
     * @param nome Novo nome do produto.
     */
    public void setNome(String nome){
        this.nome = nome;
    }
    
    /**
     * Obtém a descrição do produto.
     * 
     * @return Descrição do produto.
     */
    public String getDescricao(){
        return descricao;
    }
    
    /**
     * Define a descrição do produto.
     * 
     * @param descricao Nova descrição do produto.
     */
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    /**
     * Obtém o valor unitário do produto.
     * 
     * @return Valor unitário do produto.
     */
    public double getValorUnitario(){
        return valorUnitario;
    }
    
    /**
     * Define o valor unitário do produto.
     * 
     * @param valorUnitario Novo valor unitário do produto.
     */
    public void setValorUnitario(double valorUnitario){
        this.valorUnitario = valorUnitario;
    }
    
    /**
     * Obtém a quantidade em estoque do produto.
     * 
     * @return Quantidade em estoque do produto.
     */
    public int getQuantidadeEstoque(){
        return quantidadeEstoque;
    }
    
    /**
     * Define a quantidade em estoque do produto.
     * 
     * @param quantidadeEstoque Nova quantidade em estoque do produto.
     */
    public void setQuantidadeEstoque(int quantidadeEstoque){
        this.quantidadeEstoque = quantidadeEstoque;
    }

    /**
     * Adiciona uma quantidade ao estoque do produto.
     * @param quantidade Quantidade a ser adicionada.
     */
    public void adicionaQuantidade(int quantidade) {
        this.quantidadeEstoque += quantidade;
    }

    /**
     * Remove uma quantidade do estoque do produto.
     * @param quantidade Quantidade a ser removida.
     */
    public void removeQuantidade(int quantidade) {
        this.quantidadeEstoque -= quantidade;
    }
    
    /**
     * Sobrescrição do método toString para retornar o nome do produto.
     * 
     * @return Nome do produto.
     */
    @Override
    public String toString(){
        return "ID: " + idProduto + ", Nome: " + nome + ", Descrição: " + descricao + ", Valor Unitário: R$" + String.format("%.2f", valorUnitario) + ", Estoque: " + quantidadeEstoque;
    }
}

