package view;

import model.Cliente;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelas interações com o usuário relacionadas aos clientes.
 * Realiza entradas e saídas de dados para operações de cliente.
 */
public class ClienteView {
    
    /**
     * Scanner para leitura de dados inseridos pelo usuário.
     */
    Scanner leituraDados = new Scanner(System.in);
    
    /**
     * Exibe as opções disponíveis no menu de cliente e retorna a opção escolhida.
     *
     * @return um número inteiro correspondente à opção selecionada pelo usuário
     */
    public int mostraOpcoesCliente(){
          System.out.println("Digite a opção que deseja exucutar: ");
          System.out.println("1 - Incluir Cliente");
          System.out.println("2 - Editar Cliente");
          System.out.println("3 - Remover Cliente");
	  System.out.println("4 - Mostrar dados de um Cliente");
	  System.out.println("5 - Listar Todos os Clientes");
	  System.out.println("6 - Imprimir Ordens de Serviço do Cliente");
	  System.out.println("7 - Sair");
        
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }
    
    /**
     * Solicita e retorna o nome do cliente.
     *
     * @return Nome do cliente
     */
    public String getNomeCliente(){
        System.out.println("Digite o nome do cliente: ");
        return leituraDados.nextLine();
    }
    
    /**
     * Solicita e retorna o endereço do cliente.
     *
     * @return Endereço do cliente
     */
    public String getEnderecoCliente(){
        System.out.println("Digite o endereço do cliente: ");
        return leituraDados.nextLine();
    }
    
    /**
     * Solicita e retorna o telefone do cliente.
     *
     * @return Telefone do cliente
     */
    public String getFoneCliente(){
        System.out.println("Digite o telefone do cliente: ");
        return leituraDados.nextLine();
    }
    
    /**
     * Solicita e retorna o email do cliente.
     *
     * @return Email do cliente
     */
    public String getEmailCliente(){
        System.out.println("Digite o email do cliente: ");
        return leituraDados.nextLine();
    }
    
    /**
     * Solicita e retorna o CPF do cliente.
     *
     * @return CPF do cliente
     */
    public String getCpfCliente(){
        System.out.println("Digite o CPF do cliente (Formato: XXX.XXX.XXX-XX): ");
        return leituraDados.nextLine();
    }
    
    /**
     * Solicita e retorna o ID para um novo cliente.
     *
     * @return ID do novo cliente
     */
    public int getNewClienteId(){
        System.out.println("Digite o ID para o novo cliente: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }
    
    /**
     * Solicita e retorna o ID de um cliente existente.
     *
     * @return ID do cliente
     */
    public int getIdCliente(){
        System.out.println("Digite o ID do cliente: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }
    
    /**
     * Exibe os dados de um cliente.
     *
     * @param cliente Cliente a ser exibido
     */
    public void mostraCliente(Cliente cliente){
        System.out.println("\n--- Dados do Cliente ---");
        System.out.println("ID: " + cliente.getIdCliente());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("CPF: " + cliente.getCpf().getNumeroCpf()); // Exibe o CPF completo para consulta
        System.out.println("------------------------\n");
    }
    
    /**
     * Exibe as opções de edição para um cliente e retorna a opção escolhida.
     *
     * @return Opção de edição
     */
    public int editaCliente(){
        System.out.println("O que deseja editar?");
        System.out.println("1 - Endereço");
        System.out.println("2 - Telefone");
        System.out.println("3 - Email");
        
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }
    
    /**
     * Solicita confirmação para exclusão de cliente.
     * 
     * @return String com a confirmação do usuário
     */
    public String confirmaExclusaoCliente(){
        System.out.println("Tem certeza que deseja remover este cliente? [S/N]: ");
        return leituraDados.nextLine().trim().toUpperCase();   //; trim = tirar espaço e toUpperCase para deixar todas letras maiúculas 
    }

    /**
     * Exibe uma lista de clientes com seus IDs.
     *
     * @param clientes Lista de clientes a ser exibida
     */
    public void mostraListaClientes(List<Cliente> clientes) {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Clientes ---");
        for (Cliente cliente : clientes) {
            System.out.println("ID: " + cliente.getIdCliente() + ", Nome: " + cliente.getNome() + ", CPF: " + cliente.getCpf().getNumeroCpf());
        }
        System.out.println("-------------------------\n");
    }
    
    @Override
    public String toString(){
        return "- Interface do Cliente -";
    }
    /**
     * Solicita e retorna o nome do cliente para busca.
     *
     * @return Nome do cliente para busca
     */
    public String getNomeClienteParaBusca(){
        System.out.println("Digite o nome do cliente para busca: ");
        return leituraDados.nextLine();
    }
}