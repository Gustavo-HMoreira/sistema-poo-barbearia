package model;

public enum Conta {
    
    RECEITA(1 , "Conta referente Receita"),
    DESPESA(2, "Conta referente Despesas");
    
    private final int codigo;
    private final String descricao;
    
    Conta(int codigo, String descricao){
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    public static Conta converteEmCodigo(int codigo){
        for(Conta tipo : Conta.values()){
            if(tipo.getCodigo() == codigo){
                return tipo;
            }            
        }
            return null;
    }
    
    @Override
    public String toString(){
        return codigo + " - " + descricao;
    }    
}
