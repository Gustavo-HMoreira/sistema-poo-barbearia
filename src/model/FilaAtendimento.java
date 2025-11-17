package model;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Representa uma fila FIFO(primeiro que chega, primeiro que sai) para gerenciar atendimentos secundários.
 * Quando um cliente desiste de um atendimento ou há uma vaga disponível,
 * O próximo cliente da fila é automaticamente alocado.
 */
public class FilaAtendimento {
    private Queue<Agendamento> fila;
    
    /**
     * Construtor da classe FilaAtendimento.
     * Inicializa uma fila vazia utilizando LinkedList como implementação de Queue.
     */
    public FilaAtendimento() {
        this.fila = new LinkedList<>();
    }
    
    /**
     * Adiciona um agendamento ao final da fila.
     * 
     * @param agendamento Agendamento a ser adicionado à fila.
     * @return true se o agendamento foi adicionado com sucesso.
     */
    public boolean adicionarNaFila(Agendamento agendamento) {
        if (agendamento != null) {
            return fila.offer(agendamento);
        }
        return false;
    }
    
    /**
     * Remove e retorna o próximo agendamento da fila (primeiro da fila).
     * 
     * @return O próximo agendamento, ou null se a fila estiver vazia.
     */
    public Agendamento proximoDaFila() {
        return fila.poll();
    }
    
    /**
     * Retorna o próximo agendamento da fila sem removê-lo.
     * 
     * @return O próximo agendamento, ou null se a fila estiver vazia.
     */
    public Agendamento verProximo() {
        return fila.peek();
    }
    
    /**
     * Verifica se a fila está vazia.
     * 
     * @return true se a fila não contém agendamentos, false caso contrário.
     */
    public boolean estaVazia() {
        return fila.isEmpty();
    }
    
    /**
     * Retorna o tamanho atual da fila.
     * 
     * @return Número de agendamentos na fila.
     */
    public int tamanho() {
        return fila.size();
    }
    
    /**
     * Remove um agendamento específico da fila.
     * 
     * @param agendamento Agendamento a ser removido.
     * @return true se o agendamento foi removido, false caso contrário.
     */
    public boolean removerDaFila(Agendamento agendamento) {
        return fila.remove(agendamento);
    }
    
    /**
     * Limpa todos os agendamentos da fila.
     */
    public void limparFila() {
        fila.clear();
    }
    
    /**
     * Retorna uma representação em String da fila de atendimento.
     * 
     * @return String contendo o tamanho da fila e os agendamentos.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fila de Atendimento - Total: ").append(fila.size()).append(" agendamentos\n");
        
        if (!fila.isEmpty()) {
            sb.append("Agendamentos na fila:\n");
            int posicao = 1;
            for (Agendamento agend : fila) {
                sb.append(posicao).append(". Cliente: ").append(agend.getCliente().getNome());
                sb.append(" - Serviço: ").append(agend.getServico().getNomeServico());
                sb.append(" - ID: ").append(agend.getIdAgendamento()).append("\n");
                posicao++;
            }
        } else {
            sb.append("Fila vazia.\n");
        }
        
        return sb.toString();
    }
}
