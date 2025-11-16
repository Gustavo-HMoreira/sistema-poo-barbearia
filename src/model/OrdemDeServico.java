package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa uma Ordem de Serviço na barbearia.
 * A ordem de serviço registra todos os serviços realizados para um cliente específico,
 * incluindo os produtos utilizados, o barbeiro responsável e o status da ordem.
 */
public class OrdemDeServico {
    private int id;
    private int clienteId;
    private List<ServicoRealizado> servicosRealizados;
    private LocalDateTime dataHora;
    private double valorTotal;
    private String status; // "ABERTA", "EM_ANDAMENTO", "CONCLUIDA", "CANCELADA"
    
    /**
     * Classe interna para representar um serviço realizado dentro da ordem.
     */
    public static class ServicoRealizado {
        private Servico servico;
        private Funcionario barbeiro;
        private List<Produto> produtosUtilizados;
        
        /**
         * Construtor do ServicoRealizado.
         * 
         * @param servico Serviço que foi realizado.
         * @param barbeiro Funcionário que realizou o serviço.
         */
        public ServicoRealizado(Servico servico, Funcionario barbeiro) {
            this.servico = servico;
            this.barbeiro = barbeiro;
            this.produtosUtilizados = new ArrayList<>();
        }
        
        /**
         * Obtém o serviço realizado.
         * 
         * @return Objeto Servico.
         */
        public Servico getServico() {
            return servico;
        }
        
        /**
         * Define o serviço realizado.
         * 
         * @param servico Novo serviço.
         */
        public void setServico(Servico servico) {
            this.servico = servico;
        }
        
        /**
         * Obtém o barbeiro que realizou o serviço.
         * 
         * @return Objeto Funcionario.
         */
        public Funcionario getBarbeiro() {
            return barbeiro;
        }
        
        /**
         * Define o barbeiro responsável pelo serviço.
         * 
         * @param barbeiro Novo barbeiro.
         */
        public void setBarbeiro(Funcionario barbeiro) {
            this.barbeiro = barbeiro;
        }
        
        /**
         * Obtém a lista de produtos utilizados no serviço.
         * 
         * @return Lista de produtos.
         */
        public List<Produto> getProdutosUtilizados() {
            return new ArrayList<>(produtosUtilizados);
        }
        
        /**
         * Adiciona um produto à lista de produtos utilizados.
         * 
         * @param produto Produto a ser adicionado.
         */
        public void adicionarProduto(Produto produto) {
            if (produto != null) {
                this.produtosUtilizados.add(produto);
            }
        }
        
        @Override
        public String toString() {
            return "Servico: " + servico.getNomeServico() + ", Barbeiro: " + barbeiro.getNome() + ", Produtos: " + produtosUtilizados.size();
        }
    }
    
    /**
     * Construtor da classe OrdemDeServico.
     * Inicializa uma nova ordem de serviço com ID, cliente e data/hora.
     * 
     * @param id ID único da ordem de serviço.
     * @param clienteId ID do cliente para quem a ordem foi criada.
     * @param dataHora Data e hora de criação da ordem.
     */
    public OrdemDeServico(int id, int clienteId, LocalDateTime dataHora) {
        this.id = id;
        this.clienteId = clienteId;
        this.dataHora = dataHora;
        this.servicosRealizados = new ArrayList<>();
        this.valorTotal = 0.0;
        this.status = "ABERTA";
    }
    
    /**
     * Obtém o ID da ordem de serviço.
     * 
     * @return ID da ordem.
     */
    public int getId() {
        return id;
    }
    
    /**
     * Define o ID da ordem de serviço.
     * 
     * @param id Novo ID da ordem.
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Obtém o ID do cliente.
     * 
     * @return ID do cliente.
     */
    public int getClienteId() {
        return clienteId;
    }
    
    /**
     * Define o ID do cliente.
     * 
     * @param clienteId Novo ID do cliente.
     */
    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
    
    /**
     * Obtém a lista de serviços realizados.
     * 
     * @return Lista de serviços realizados.
     */
    public List<ServicoRealizado> getServicosRealizados() {
        return new ArrayList<>(servicosRealizados);
    }
    
    /**
     * Obtém a data e hora da ordem de serviço.
     * 
     * @return Data e hora da ordem.
     */
    public LocalDateTime getDataHora() {
        return dataHora;
    }
    
    /**
     * Define a data e hora da ordem de serviço.
     * 
     * @param dataHora Nova data e hora.
     */
    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
    /**
     * Obtém o valor total da ordem de serviço.
     * 
     * @return Valor total.
     */
    public double getValorTotal() {
        return valorTotal;
    }
    
    /**
     * Obtém o status da ordem de serviço.
     * 
     * @return Status da ordem.
     */
    public String getStatus() {
        return status;
    }
    
    /**
     * Define o status da ordem de serviço.
     * 
     * @param status Novo status.
     */
    public void setStatus(String status) {
        this.status = status;
    }
    
    /**
     * Adiciona um serviço realizado à ordem.
     * Atualiza automaticamente o valor total.
     * 
     * @param servicoRealizado Serviço realizado a ser adicionado.
     */
    public void adicionarServicoRealizado(ServicoRealizado servicoRealizado) {
        if (servicoRealizado != null) {
            this.servicosRealizados.add(servicoRealizado);
            calcularValorTotal();
        }
    }
    
    /**
     * Calcula o valor total da ordem de serviço.
     * Soma o preço de todos os serviços realizados.
     */
    private void calcularValorTotal() {
        this.valorTotal = 0.0;
        for (ServicoRealizado sr : servicosRealizados) {
            this.valorTotal += sr.getServico().getPreco();
        }
    }
    
    /**
     * Finaliza a ordem de serviço, alterando seu status para CONCLUIDA.
     */
    public void finalizar() {
        this.status = "CONCLUIDA";
    }
    
    /**
     * Cancela a ordem de serviço, alterando seu status para CANCELADA.
     */
    public void cancelar() {
        this.status = "CANCELADA";
    }
    
    /**
     * Inicia o atendimento da ordem, alterando seu status para EM_ANDAMENTO.
     */
    public void iniciarAtendimento() {
        this.status = "EM_ANDAMENTO";
    }
    
    /**
     * Retorna uma representação em String da ordem de serviço.
     * 
     * @return String formatada com os detalhes da ordem.
     */
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        StringBuilder sb = new StringBuilder();
        
        sb.append("========================================\n");
        sb.append("       ORDEM DE SERVIÇO #").append(id).append("\n");
        sb.append("========================================\n");
        sb.append("Cliente ID: ").append(clienteId).append("\n");
        sb.append("Data/Hora: ").append(dataHora.format(formatter)).append("\n");
        sb.append("Status: ").append(status).append("\n");
        sb.append("----------------------------------------\n");
        
        if (!servicosRealizados.isEmpty()) {
            sb.append("SERVIÇOS REALIZADOS:\n");
            for (ServicoRealizado sr : servicosRealizados) {
                sb.append("- ").append(sr.getServico().getNomeServico());
                sb.append(" (R$ ").append(String.format("%.2f", sr.getServico().getPreco())).append(")");
                sb.append(" - Barbeiro: ").append(sr.getBarbeiro().getNome()).append("\n");
                
                if (!sr.getProdutosUtilizados().isEmpty()) {
                    sb.append("  Produtos utilizados: ");
                    for (Produto p : sr.getProdutosUtilizados()) {
                        sb.append(p.getNome()).append(", ");
                    }
                    sb.setLength(sb.length() - 2); // Remove última vírgula
                    sb.append("\n");
                }
            }
            sb.append("----------------------------------------\n");
        }
        
        sb.append("VALOR TOTAL: R$ ").append(String.format("%.2f", valorTotal)).append("\n");
        sb.append("========================================\n");
        
        return sb.toString();
    }
}
