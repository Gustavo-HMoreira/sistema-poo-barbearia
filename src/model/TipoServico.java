
package model;

public enum TipoServico {
    
    CORTE_CABELO(1, "Corte de Cabelo", 50.00),
    BARBA(2, "Barba", 25.00),
    CORTE_BARBA(3, "Corte de Cabelo e Barba", 65.00),
    HIDRATACAO(4, "Hidratação de Cabelo", 20.00),
    PIGMENTACAO(5, "Pigmentação Capilar ou da Barba", 120.00),
    OUTRO(6, "Outro", 0.00);
    
    private final int codigo;
    private final String descricao;
    private final double valor;
    
    TipoServico(int codigo, String descricao, double valor){
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor; 
  
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    //conversão de enums para codigo
    public static TipoServico cerverteCodigo(int codigo){
        
        for(TipoServico servico : TipoServico.values()){ //value retorna as constantes do enum
           if(servico.getCodigo() == codigo){ 
               return servico;
        }   
      }    
        return null;
    }
        
        
        
    @Override       
    public String toString(){
        return descricao;
    }  
}
