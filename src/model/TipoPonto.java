package model;
/**
 *Status simples do ponto
 *
 */
public enum TipoPonto {
    
    ENTRADA("Entrada"),
    SAIDA("Saida");
    
    private String descricao;

    TipoPonto(String descricao){
       this.descricao = descricao;  
}

    public String getDescricao(){
       return descricao;
    }    
}
