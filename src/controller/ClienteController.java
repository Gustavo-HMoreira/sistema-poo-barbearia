package controller;

import model.Cliente;
import model.Cpf;
import repository.RepositorioGeral;
import view.ClienteView;
import model.OrdemDeServico;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável pela gerência dos clientes.
 * Fornece métodos para adicionar, remover, buscar e exibir informações dos clientes.
 */
public class ClienteController {
    private ClienteView viewCliente = new ClienteView();
    private OrdemDeServicoController osController = new OrdemDeServicoController();
     
    /**
     * Exibe o menu de opções do cliente e executa a ação selecionada pelo usuário.
     * O menu permanece ativo até que o usuário escolha a opção de sair.
     */
    public void executaMenuCliente(){
        int opcao = 0; 
        
        while(opcao != 7){
            opcao = viewCliente.mostraOpcoesCliente();
            
            if (opcao == 7) {
                System.out.println("Saindo do menu de clientes...");
                break; 
            }
            
            switch (opcao){
                case 1: {
                    adicionaCliente();
                }
                break;
                case 2: {
                    editarCliente();
                }
                break;
                case 3: {
                    removeCliente();
                }
                break;
                case 4: {
                    mostrarCliente();
                }
                break;
                case 5: {
                    listarClientes();
                }
                break;
                case 6: {
                    imprimirOrdensDeServico();
                }
                break;
                
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }
    
    /**
     * Questão 8: Imprime as ordens de serviço de um cliente.
     */
    private void imprimirOrdensDeServico() {
        int id = viewCliente.getIdCliente();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream()
                                                    .filter(c -> c.getIdCliente() == id)
                                                    .findFirst();
        
        if (clienteOptional.isPresent()) {
            osController.imprimirOrdensPorCliente(id);
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private void adicionaCliente() {
        int idCliente = viewCliente.getNewClienteId(); // Solicita o ID manualmente
        // Verificar se o ID já existe
        if (RepositorioGeral.getClientes().stream().anyMatch(c -> c.getIdCliente() == idCliente)) {
            System.out.println("Erro: Já existe um cliente com este ID. Por favor, escolha outro ID.");
            return;
        }

        String nome = viewCliente.getNomeCliente();
        String endereco = viewCliente.getEnderecoCliente();
        String telefone = viewCliente.getFoneCliente();
        String email = viewCliente.getEmailCliente();
        String codigoCpf = viewCliente.getCpfCliente();
        if (!Cpf.validaCPF(codigoCpf)) {
            System.out.println("CPF inválido!!");
            return;
        }
        
        Cpf cpf = new Cpf(codigoCpf); 

        Cliente novoCliente = new Cliente(nome, endereco, telefone, email, cpf, idCliente);
            
        RepositorioGeral.getClientes().add(novoCliente);
        RepositorioGeral.salvarDados();
        System.out.println("Cliente adicionado com sucesso! ID: " + idCliente);
    }

    private void editarCliente() {
        String nome = viewCliente.getNomeClienteParaBusca();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream()
                                                    .filter(c -> c.getNome().equalsIgnoreCase(nome))
                                                    .findFirst();

        if (!clienteOptional.isPresent()) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        Cliente cliente = clienteOptional.get();

        viewCliente.mostraCliente(cliente);
        int opcao = viewCliente.editaCliente();
        
        switch (opcao){
            case 1: 
                cliente.setEndereco(viewCliente.getEnderecoCliente());
                break;
            case 2: 
                cliente.setTelefone(viewCliente.getFoneCliente());
                break;
            case 3: 
                cliente.setEmail(viewCliente.getEmailCliente());
                break;
            default: {
                System.out.println("Opção inválida! Nenhuma alteração realizada.");
                return;
            }
        }
        RepositorioGeral.salvarDados();
        System.out.println("Cliente editado com sucesso!");
    }

    private void removeCliente() {
        String nome = viewCliente.getNomeClienteParaBusca();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream()
                                                    .filter(c -> c.getNome().equalsIgnoreCase(nome))
                                                    .findFirst();
        
        if (!clienteOptional.isPresent()){
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        Cliente cliente = clienteOptional.get();
        viewCliente.mostraCliente(cliente);
        
        String opcaoConfirmacao = viewCliente.confirmaExclusaoCliente();
        if (!opcaoConfirmacao.equalsIgnoreCase("S")) {
            System.out.println("Operação abortada!!");
            return;
        }
        
        if (RepositorioGeral.getClientes().remove(cliente)) {
            RepositorioGeral.salvarDados();
            System.out.println("Cliente removido com sucesso!");
        } 
        else {
            System.out.println("Falha ao remover cliente! :(");
        }       
    }

    private void mostrarCliente() {
        String nome = viewCliente.getNomeClienteParaBusca();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream()
                                                    .filter(c -> c.getNome().equalsIgnoreCase(nome))
                                                    .findFirst();
        if (clienteOptional.isPresent()) {
            viewCliente.mostraCliente(clienteOptional.get());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private void listarClientes() {
        viewCliente.mostraListaClientes(RepositorioGeral.getClientes());
    }
    
    // O método gerarProximoIdCliente() não é mais necessário, pois o ID será inserido manualmente.

    @Override
    public String toString(){
        return String.format("ClienteController: %d clientes registrados.", RepositorioGeral.getClientes().size());
    }
}
