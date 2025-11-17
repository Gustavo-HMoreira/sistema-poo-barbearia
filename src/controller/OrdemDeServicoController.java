package controller;

import model.*;
import repository.RepositorioGeral;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Controlador responsável pelo gerenciamento de Ordens de Serviço.
 * 
 */
public class OrdemDeServicoController {
    
    /**
     * Cria uma nova ordem de serviço para um cliente.
     * 
     * @param clienteId ID do cliente.
     * @return A ordem de serviço criada.
     */
    public OrdemDeServico criarOrdemDeServico(int clienteId) {
        int novoId = gerarProximoId();
        OrdemDeServico ordem = new OrdemDeServico(novoId, clienteId, LocalDateTime.now());
        RepositorioGeral.getOrdensDeServico().add(ordem);
        RepositorioGeral.salvarDados();
        return ordem;
    }
    
    /**
     * Adiciona um serviço realizado a uma ordem existente.
     * 
     * @param ordemId ID da ordem de serviço.
     * @param servico Serviço realizado.
     * @param barbeiro Funcionário que realizou o serviço.
     * @return true se adicionado com sucesso, false caso contrário.
     */
    public boolean adicionarServicoNaOrdem(int ordemId, Servico servico, Funcionario barbeiro) {
        Optional<OrdemDeServico> ordemOpt = buscarOrdemPorId(ordemId);
        
        if (ordemOpt.isPresent()) {
            OrdemDeServico ordem = ordemOpt.get();
            OrdemDeServico.ServicoRealizado servicoRealizado = 
                          new OrdemDeServico.ServicoRealizado(servico, barbeiro);
            ordem.adicionarServicoRealizado(servicoRealizado);
            RepositorioGeral.salvarDados();
            return true;
        }
        
        return false;
    }
    
    /**
     * Busca uma ordem de serviço por ID.
     * 
     * @param id ID da ordem de serviço.
     * @return Optional contendo a ordem se encontrada.
     */
    public Optional<OrdemDeServico> buscarOrdemPorId(int id) {
        return RepositorioGeral.getOrdensDeServico().stream()
                .filter(ordem -> ordem.getId() == id).findFirst();
               
    }
    
    /**
     * 
     * @param clienteId ID do cliente.
     * @return Lista de ordens de serviço do cliente.
     */
    public List<OrdemDeServico> buscarOrdensPorCliente(int clienteId) {
        return RepositorioGeral.getOrdensDeServico().stream()
                .filter(ordem -> ordem.getClienteId() == clienteId).toList();
                
    }
    
    /**
     * 
     * @param clienteId ID do cliente.
     */
    public void imprimirOrdensPorCliente(int clienteId) {
        List<OrdemDeServico> ordens = buscarOrdensPorCliente(clienteId);
        
        if (ordens.isEmpty()) {
            System.out.println("Nenhuma ordem de serviço encontrada para o cliente ID: " + clienteId);
            return;
        }
        
        System.out.println("\n========================================");
        System.out.println("ORDENS DE SERVIÇO DO CLIENTE ID: " + clienteId);
        System.out.println("========================================\n");
        
        for (OrdemDeServico ordem : ordens) {
            System.out.println(ordem.toString());
        }
    }
    
    /**
     * Finaliza uma ordem de serviço.
     * 
     * @param ordemId ID da ordem de serviço.
     * @return true se finalizada com sucesso, false caso contrário.
     */
    public boolean finalizarOrdem(int ordemId) {
        Optional<OrdemDeServico> ordemOpt = buscarOrdemPorId(ordemId);
        
        if (ordemOpt.isPresent()) {
            ordemOpt.get().finalizar();
            RepositorioGeral.salvarDados();
            return true;
        }
        
        return false;
    }
    
    /**
     * Cancela uma ordem de serviço.
     * 
     * @param ordemId ID da ordem de serviço.
     * @return true se cancelada com sucesso, false caso contrário.
     */
    public boolean cancelarOrdem(int ordemId) {
        Optional<OrdemDeServico> ordemOpt = buscarOrdemPorId(ordemId);
        
        if (ordemOpt.isPresent()) {
            ordemOpt.get().cancelar();
            RepositorioGeral.salvarDados();
            return true;
        }
        
        return false;
    }
    
    /**
     * Inicia o atendimento de uma ordem de serviço.
     * 
     * @param ordemId ID da ordem de serviço.
     * @return true se iniciada com sucesso, false caso contrário.
     */
    public boolean iniciarAtendimento(int ordemId) {
        Optional<OrdemDeServico> ordemOpt = buscarOrdemPorId(ordemId);
        
        if (ordemOpt.isPresent()) {
            ordemOpt.get().iniciarAtendimento();
            RepositorioGeral.salvarDados();
            return true;
        }
        
        return false;
    }
    
    /**
     * Lista todas as ordens de serviço do sistema.
     */
    public void listarTodasOrdens() {
        List<OrdemDeServico> ordens = RepositorioGeral.getOrdensDeServico();
        
        if (ordens.isEmpty()) {
            System.out.println("Nenhuma ordem de serviço cadastrada.");
            return;
        }
        
        System.out.println("\n========================================");
        System.out.println("TODAS AS ORDENS DE SERVIÇO");
        System.out.println("========================================\n");
        
        for (OrdemDeServico ordem : ordens) {
            System.out.println(ordem.toString());
        }
    }
    
    /**
     * Gera o próximo ID disponível para ordem de serviço.
     * 
     * @return Próximo ID.
     */
    private int gerarProximoId() {
        List<OrdemDeServico> ordens = RepositorioGeral.getOrdensDeServico();
        
        if (ordens.isEmpty()) {
            return 1;
        }
        
        return ordens.stream().mapToInt(OrdemDeServico::getId).max().orElse(0) + 1;
                                
    }
}
