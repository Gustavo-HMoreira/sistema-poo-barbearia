package model;

public enum StatusAgendamento {
    
    CONFIRMADO(1, "Agendamento Confirmado"),
    PEDENTE(3, "Agendamento Pendente"),
    CANCELADO(2, "Agendamento Cancelado");
    
    private final int codigo;
    private final String descricao;
    
    StatusAgendamento(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public int getCodigo(){
        return codigo;
    }
    public String getDescricao(){
        return descricao;
    }
        
    public static StatusAgendamento converteCodigo(int codigo){
        for(StatusAgendamento statusAtual : StatusAgendamento.values() ){
            
            if(statusAtual.getCodigo() == codigo){
                return statusAtual;
            }
     
        }
            return null;
    }
    
    @Override
    public String toString(){
        return descricao;
    }
  
}
