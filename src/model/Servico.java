package model;

public class Servico {
    
    private String nomeservico;
    private String descricao;
    private int idservico;
    private double preco;
    private TipoServico tiposervico;
            
    public Servico(String nomeservico, String descricao, int idservico, double preco, TipoServico tiposervico){
        this.nomeservico = nomeservico;
        this.descricao = descricao;
        this.idservico = idservico;
        this.preco = preco;
        this.tiposervico = tiposervico;
    }
    
    
    public String getNomeServico(){
        return nomeservico;
    }
    
    public void setNomeServico(String nomeservico){
        this.nomeservico = nomeservico;
    }
    
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    
    public int getIdServico(){
        return idservico;
    }
    
    public void setIdServico(int idservico){
        this.idservico = idservico;
    }
    
    
    public double getPreco(){
        return preco;
    }
     
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    
    public TipoServico getTipoServico(){
        return tiposervico;
    }
    
    public void setTipoServico(TipoServico tiposervico){
        this.tiposervico = tiposervico;
    }

}
