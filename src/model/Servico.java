package model;


public class Servico {
    private int idServico;
    private String nomeServico;
    private double preco;
    private String descricao;
    private TipoServico tipoServico;

    
    public Servico(int idServico, String nomeServico, String descricao, double preco, TipoServico tipoServico) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.preco = preco;
        this.descricao = descricao;
        this.tipoServico = tipoServico;
    }

    
    public int getIdServico() {
        return idServico;
    }

    
    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

   
    public String getNomeServico() {
        return nomeServico;
    }

    
    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

   
    public double getPreco() {
        return preco;
    }

    
    public void setPreco(double preco) {
        this.preco = preco;
    }

    
    public String getDescricao() {
        return descricao;
    }

   
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

   
    public TipoServico getTipoServico() {
        return tipoServico;
    }

    
    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

   
    @Override
    public String toString() {
        return "ID: " + idServico + ", Serviço: " + nomeServico + ", Preço: R$ " + String.format("%.2f", preco) + 
               ", Descrição: " + descricao + ", Tipo: " + tipoServico.getDescricao();
    }
}

