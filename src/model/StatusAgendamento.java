package model;

/**
 * Enum que representa os possíveis status de uma Ordem de Serviço.
 */
public enum StatusAgendamento {
    PENDENTE(1, "Pendente"),
    CANCELADO(2, "Cancelado"),
    CONFIRMADO(3, "Confirmado");
    
    private final int codigo;
    private final String descricao;
    
    StatusAgendamento(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
    
    public int getCodigo() {
        return codigo;
    }
    
    public String getDescricao() {
        return descricao;
    }
    
    /**
     * Converte um código numérico para o enum correspondente.
     * 
     * @param codigo Código numérico do status
     * @return StatusAgendamento correspondente ou null se inválido
     */
    public static StatusAgendamento converteCodigo(int codigo) {
        for (StatusAgendamento status : StatusAgendamento.values()) {
            if (status.getCodigo() == codigo) {
                return status;
            }
        }
        return null;
    }
    
    @Override
    public String toString() {
        return descricao;
    }
}