package view;

import java.util.Scanner;

public class ViewPrincipal {

    Scanner leituraDados = new Scanner(System.in);
    

    public int mostraOpcoesDisponiveis(){
        System.out.println("1  - Cadastro de Clientes");
        System.out.println("2  - Cadastro de Funcionários/Barbeiros");
        System.out.println("3  - Controle de Estoque (Produtos)");
        System.out.println("4  - Agendamentos");
        System.out.println("5  - Notas Fiscais");
        System.out.println("6  - Controle Financeiro");
        System.out.println("7  - Cadastro de Serviços");
        System.out.println("8  - Sistema de Ponto"); 
        System.out.println("9  - Sair"); //sair do painel inicial e fechar o programa todo
        System.out.println("Digite para qual espaço deseja ser redirecionado \n");
        
        return leituraDados.nextInt();
    }
    
    @Override
    public String toString(){
        return "- Interface da Tela Inicial -";
    }
}

