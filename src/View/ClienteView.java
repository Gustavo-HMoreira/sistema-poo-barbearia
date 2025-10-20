package view;

import model.Cliente;
import java.util.List;
import java.util.Scanner;


public class ClienteView {
    
   
    Scanner leituraDados = new Scanner(System.in);
    public int mostraOpcoesCliente(){
        System.out.println("Digite a opção que deseja exucutar: ");
        System.out.println("1 - Incluir Cliente");
        System.out.println("2 - Editar Cliente");
        System.out.println("3 - Remover Cliente");
        System.out.println("4 - Mostrar dados de um Cliente");
        System.out.println("5 - Listar Todos os Clientes"); 
        System.out.println("6 - Sair");
        
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }

    public String getNomeCliente(){
        System.out.println("Digite o nome do cliente: ");
        return leituraDados.nextLine();
    }

    public String getEnderecoCliente(){
        System.out.println("Digite o endereço do cliente: ");
        return leituraDados.nextLine();
    }

    public String getFoneCliente(){
        System.out.println("Digite o telefone do cliente: ");
        return leituraDados.nextLine();
    }
    
 
    public String getEmailCliente(){
        System.out.println("Digite o email do cliente: ");
        return leituraDados.nextLine();
    }
    
  
    
    public String getCpfCliente(){
        System.out.println("Digite o CPF do cliente: ");
        return leituraDados.nextLine();
    }
  
    public int getIdCliente(){
        System.out.println("Digite o ID do cliente: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }

   
    
    
    
    public int getNewClienteId(){
        System.out.println("Digite o ID para o novo cliente: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }
    
  
    public void mostraCliente(Cliente cliente){
        System.out.println("\n--- Dados do Cliente ---");
        System.out.println("ID: " + cliente.getIdCliente());
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("Endereço: " + cliente.getEndereco());
        System.out.println("Telefone: " + cliente.getTelefone());
        System.out.println("Email: " + cliente.getEmail());
        System.out.println("CPF: " + cliente.getCpf().getNumeroCpf()); 
        System.out.println("------------------------\n");
    }
    
   
    public int editaCliente(){
        System.out.println("O que deseja editar?");
        System.out.println("1 - Endereço");
        System.out.println("2 - Telefone");
        System.out.println("3 - Email");
        
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }
    
   
    public String confirmaExclusaoCliente(){
        System.out.println("Tem certeza que deseja remover este cliente? [S/N]: ");
        return leituraDados.nextLine().trim().toUpperCase();
    }

  
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
}

