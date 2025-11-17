package model;

/**
 * Representa uma estação de atendimento na barbearia.
 * A barbearia possui 3 estações fixas onde os atendimentos vão ser realizados.
 * Cada estação pode estar ocupada ou disponível e pode ter um agendamento alocado.
 */
public class EstacaoAtendimento {
    private int id;
    private boolean ocupada;
    private Integer idAtendimento; // ID do agendamento/ordem alocado, se houver
    
    /**
     * Construtor da classe EstacaoAtendimento.
     * Inicializa uma estação de atendimento com ID específico.
     * Como padão vem não ocupada
     * @param id Identificador único da estação de atendimento.
     */
    public EstacaoAtendimento(int id) {
        this.id = id;
        this.ocupada = false;
        this.idAtendimento = null;
    }
    
    /**
     * Obtém o ID da estação de atendimento.
     * 
     * @return ID da estação.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Define o ID da estação de atendimento.
     * 
     * @param id Novo ID da estação.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Verifica se a estação está ocupada.
     * 
     * @return true se a estação está ocupada, false caso contrário.
     */
    public boolean isOcupada() {
        return ocupada;
    }
    
    /**
     * Define o status de ocupação da estação.
     * 
     * @param ocupada true para ocupar a estação, false para liberar.
     */
    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    /**
     * Obtém o ID do atendimento alocado nesta estação.
     * 
     * @return ID do atendimento, ou null se não houver atendimento alocado.
     */
    public Integer getIdAtendimento() {
        return idAtendimento;
    }
    
    /**
     * Define o ID do atendimento alocado nesta estação.
     * 
     * @param idAtendimento ID do atendimento a ser alocado.
     */
    public void setIdAtendimento(Integer idAtendimento) {
        this.idAtendimento = idAtendimento;
    }
    
    /**
     * Aloca um atendimento nesta estação.
     * Marca a estação como ocupada e registra o ID do atendimento.
     * 
     * @param idAtendimento ID do atendimento a ser alocado.
     * @return true se a alocação foi bem-sucedida, false se a estação já estava ocupada.
     */
    public boolean alocarAtendimento(int idAtendimento) {
        if (!this.ocupada) {
            this.ocupada = true;
            this.idAtendimento = idAtendimento;
            return true;
        }
        return false;
    }
    
    /**
     * Libera a estação de atendimento.
     * Marca a estação como disponível e remove o ID do atendimento.
     */
    public void liberarEstacao() {
        this.ocupada = false;
        this.idAtendimento = null;
    }
    
    /**
     * Retorna uma representação em String da estação de atendimento.
     * 
     * @return String contendo o ID da estação, status de ocupação e atendimento alocado.
     */
    @Override
    public String toString() {
        return "Estacao{" + "id: " + id + ", ocupada: " + ocupada + ", atendimento: " + idAtendimento + "}";
    }
}
