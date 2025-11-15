package model;

/**
 * Enum que representa os tipos de serviços disponíveis na barbearia.
 */
public enum TipoServico {
    CORTE_CABELO(1, "Corte de Cabelo", 30.00),
    BARBA(2, "Barba", 25.00),
    CORTE_E_BARBA(3, "Corte e Barba", 50.00),
    COLORACAO(4, "Coloração", 80.00),
    TRATAMENTO(5, "Tratamento Capilar", 60.00),
    OUTRO(6, "Outro", 0.00);
    
    private final int codigo;
    private final String descricao;
    private final double preco;
    
    TipoServico(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
    
    /**
     * Converte um código numérico para o enum correspondente.
     * 
     * @param codigo Código numérico do tipo de serviço
     * @return TipoServico correspondente ou null se inválido
     */
    public static TipoServico converteCodigo(int codigo) {
        for (TipoServico tipo : TipoServico.values()) {
            if (tipo.getCodigo() == codigo) {
                return tipo;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}

