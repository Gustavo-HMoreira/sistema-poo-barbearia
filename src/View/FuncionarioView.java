package view;

import model.Funcionario;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelas interações com o usuário relacionadas aos funcionários.
 * Realiza entradas e saídas de dados para operações de funcionário.
 */
public class FuncionarioView {
    
    /**
     * Scanner para leitura de dados inseridos pelo usuário.
     */
    Scanner leituraDados = new Scanner(System.in);

    /**
     * Exibe as opções disponíveis no menu de funcionário e retorna a opção escolhida.
     *
     * @return um número inteiro correspondente à opção selecionada pelo usuário
     */
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

    /**
     * Solicita e retorna o nome do funcionário.
     *
     * @return Nome do funcionário
     */
    public String getNomeFuncionario(){
        System.out.println("Digite o nome do funcionário: ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna o endereço do funcionário.
     *
     * @return Endereço do funcionário
     */
    public String getEnderecoFuncionario(){
        System.out.println("Digite o endereço do funcionário: ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna o telefone do funcionário.
     *
     * @return Telefone do funcionário
     */
    public String getFoneFuncionario(){
        System.out.println("Digite o telefone do funcionário: ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna o email do funcionário.
     *
     * @return Email do funcionário
     */
    public String getEmailFuncionario(){
        System.out.println("Digite o email do funcionário: ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna o CPF do funcionário.
     *
     * @return CPF do funcionário
     */
    public String getCpfFuncionario(){
        System.out.println("Digite o CPF do funcionário (XXX.XXX.XXX-XX): ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna o usuário do funcionário para login.
     *
     * @return Usuário do funcionário
     */
    public String getUsuarioFuncionario(){
        System.out.println("Digite o usuário do funcionário: ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna a senha do funcionário para login.
     *
     * @return Senha do funcionário
     */
    public String getSenhaFuncionario(){
        System.out.println("Digite a senha do funcionário: ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna o cargo do funcionário.
     *
     * @return Cargo do funcionário
     */
    public String getCargoFuncionario(){
        System.out.println("Digite o cargo do funcionário: ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna o salário do funcionário.
     *
     * @return Salário do funcionário
     */
    public double getSalarioFuncionario(){
        System.out.println("Digite o salário do funcionário: ");
        double salario = leituraDados.nextDouble();
        leituraDados.nextLine();
        return salario;
    }



    /**
     * Solicita e retorna o ID para um novo funcionário.
     *
     * @return ID do novo funcionário
     */
    public int getNewFuncionarioId(){
      System.out.println("Digite o ID para o novo funcionário: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }

    /**
     * Exibe os dados de um funcionário.
     *
     * @param funcionario Funcionário a ser exibido
     */
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

    /**
     * Exibe as opções de edição para um funcionário e retorna a opção escolhida.
     *
     * @return Opção de edição
     */
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

    /**
     * Solicita confirmação para exclusão de funcionário.
     *
     * @return String com a confirmação do usuário
     */
    public String confirmaExclusaoFuncionario(){
        System.out.println("Tem certeza que deseja remover este funcionário? [S/N]: ");
        return leituraDados.nextLine().trim().toUpperCase();
    }

    /**
     * Exibe uma lista de funcionários com seus IDs.
     *
     * @param funcionarios Lista de funcionários a ser exibida
     */
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
        return "-- Interface do Funcionário --";
    }
    
    /**
     * Solicita e retorna o nome do funcionário para busca.
     *
     * @return Nome do funcionário para busca
     */
    public String getNomeFuncionarioParaBusca(){
        System.out.println("Digite o nome do funcionário para busca: ");
        return leituraDados.nextLine();
    }
}