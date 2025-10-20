package view;

import model.Funcionario;
import java.util.List;
import java.util.Scanner;


public class FuncionarioView {
    
    
    Scanner leituraDados = new Scanner(System.in);

    
    public int mostraOpcoesFuncionario(){
        System.out.println("\nDigite a opção que deseja executar: ");
        System.out.println("1 - Incluir Funcionário");
        System.out.println("2 - Editar Funcionário");
        System.out.println("3 - Remover Funcionário");
        System.out.println("4 - Mostrar dados de um Funcionário");
        System.out.println("5 - Listar Todos os Funcionários");
        System.out.println("6 - Sair");

        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }

   
    public String getNomeFuncionario(){
        System.out.println("Digite o nome do funcionário: ");
        return leituraDados.nextLine();
    }

    
    public String getEnderecoFuncionario(){
        System.out.println("Digite o endereço do funcionário: ");
        return leituraDados.nextLine();
    }

   
    public String getFoneFuncionario(){
        System.out.println("Digite o telefone do funcionário: ");
        return leituraDados.nextLine();
    }

   
    public String getEmailFuncionario(){
        System.out.println("Digite o email do funcionário: ");
        return leituraDados.nextLine();
    }

    
    public String getCpfFuncionario(){
        System.out.println("Digite o CPF do funcionário (XXX.XXX.XXX-XX): ");
        return leituraDados.nextLine();
    }

   
    public String getUsuarioFuncionario(){
        System.out.println("Digite o usuário do funcionário: ");
        return leituraDados.nextLine();
    }

   
    public String getSenhaFuncionario(){
        System.out.println("Digite a senha do funcionário: ");
        return leituraDados.nextLine();
    }

    
    public String getCargoFuncionario(){
        System.out.println("Digite o cargo do funcionário: ");
        return leituraDados.nextLine();
    }

   
    public double getSalarioFuncionario(){
        System.out.println("Digite o salário do funcionário: ");
        double salario = leituraDados.nextDouble();
        leituraDados.nextLine();
        return salario;
    }

    
    public int getIdFuncionario(){
        System.out.println("Digite o ID do funcionário: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }
 
    public int getNewFuncionarioId(){
        System.out.println("Digite o ID para o novo funcionário: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }
  
    public void mostraFuncionario(Funcionario funcionario){
        System.out.println("\n--- Dados do Funcionário ---");
        System.out.println("ID: " + funcionario.getIdFuncionario());
        System.out.println("Nome: " + funcionario.getNome());
        System.out.println("Endereço: " + funcionario.getEndereco());
        System.out.println("Telefone: " + funcionario.getTelefone());
        System.out.println("Email: " + funcionario.getEmail());
        System.out.println("CPF: " + funcionario.getCpf().getNumeroCpf());
        System.out.println("Usuário: " + funcionario.getUsuario());
        System.out.println("Cargo: " + funcionario.getCargo());
        System.out.println("Salário: R$ " + String.format("%.2f", funcionario.getSalario()));
        System.out.println("----------------------------\n");
    }

    public int editaFuncionario(){
        System.out.println("O que deseja editar?");
        System.out.println("1 - Endereço");
        System.out.println("2 - Telefone");
        System.out.println("3 - Email");
        System.out.println("4 - Senha");
        System.out.println("5 - Cargo");
        System.out.println("6 - Salário");

        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }


    public String confirmaExclusaoFuncionario(){
        System.out.println("Tem certeza que deseja remover este funcionário? [S/N]: ");
        return leituraDados.nextLine().trim().toUpperCase();
    }

   
    public void mostraListaFuncionarios(List<Funcionario> funcionarios) {
        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Funcionários ---");
        for (Funcionario funcionario : funcionarios) {
            System.out.println("ID: " + funcionario.getIdFuncionario() + ", Nome: " + funcionario.getNome() + ", Cargo: " + funcionario.getCargo());
        }
        System.out.println("-----------------------------\n");
    }
    
    @Override
    public String toString(){
        return "- Interface do Funcionário -";
    }
}

