package view;

import java.util.Scanner;

/**
 * Classe responsável pela tela inicial.
 * Definindo o menu principal que permite acesso a algumas áreas do sistema e mostrando mensagens relacionadas a manipulação dos dados.
 */
public class ViewPrincipal {
    
    /**
     * Scanner para leitura e entrada do usuário.
     */
    Scanner leituraDados = new Scanner(System.in);
    
    /**
     * Exibe o menu principal com todas as areas disponiveis do sistema.
     * Apresenta algumas funcionalidades como: cadastro de clientes, cadastro de funcionários, cadastro de peças, gerar ordem de serviço e
     * acessar a área financeira do sistema.
     * 
     * @return Número inteiro representando a área selecionada pelo usuário.
     */
    public int mostraOpcoesDisponiveis(){
        System.out.println("1  - Cadastro de Clientes");
        System.out.println("2  - Cadastro de Funcionários/Barbeiros");
        System.out.println("3  - Controle de Estoque (Produtos)");
        System.out.println("4  - Agendamentos");
        System.out.println("5  - Notas Fiscais");
        System.out.println("6  - Controle Financeiro");
        System.out.println("7  - Cadastro de Serviços");
        System.out.println("8  - Sistema de Ponto"); 
        System.out.println("9  - Sair"); // ecerra o programa
        System.out.println("Digite para qual espaço deseja ser redirecionado \n");
        
        return leituraDados.nextInt();
    }
    
    @Override
    public String toString(){
        return "- Interface da Tela Inicial -";
    }
}

