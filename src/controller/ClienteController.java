package controller;

import model.Cliente;
import model.Cpf;
import repository.RepositorioGeral;
import view.ClienteView;

import java.util.List;
import java.util.Optional;




public class ClienteController {
    private ClienteView viewCliente = new ClienteView();
     
    
    public void executaMenuCliente(){
        int opcao = 0; 
        
        while(opcao != 6){
            opcao = viewCliente.mostraOpcoesCliente();
            
            if (opcao == 6) {
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
                
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }

    private void adicionaCliente() {
        int idCliente = viewCliente.getNewClienteId();
       
        if (RepositorioGeral.getClientes().stream().anyMatch(c -> c.getIdCliente() == idCliente)) {
            System.out.println("Erro: Já existe um cliente com este ID. Por favor, escolha outro ID.");
            return;
        }

        String nome = viewCliente.getNomeCliente();
        String endereco = viewCliente.getNomeCliente();
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
        int id = viewCliente.getIdCliente();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream()
                                            .filter(c -> c.getIdCliente() == id).findFirst();
                                                    

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
        int id = viewCliente.getIdCliente();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream()
                                            .filter(c -> c.getIdCliente() == id).findFirst();
                                                    
     
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
        int id = viewCliente.getIdCliente();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream()
                                            .filter(c -> c.getIdCliente() == id).findFirst()
                                                    ;
        if (clienteOptional.isPresent()) {
            viewCliente.mostraCliente(clienteOptional.get());
        } else {
            System.out.println("Cliente não encontrado!");
        }
    }

    private void listarClientes() {
        viewCliente.mostraListaClientes(RepositorioGeral.getClientes());
    }

    @Override
    public String toString(){
        return String.format("ClienteController: %d clientes registrados.", RepositorioGeral.getClientes().size());
    }
}
