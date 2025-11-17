package view;

import model.Funcionario;
import java.util.Scanner;

/**
 * Interface simplificada para login.
 */
public class LoginView {
    private Scanner leituraDados = new Scanner(System.in);
    
    public void exibeTelaBemVindo() {
        System.out.println(":=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:");
        System.out.println("          Bem-vindo!");
        System.out.println(":=:=:=:=:=:=:=:=:=:=:=:=:=:=:=:");
    }
    
    public String getUsuario() {
        System.out.println("Usuario: ");
        return leituraDados.nextLine().trim();//trim remove espaços em branco, é bom usar.
    }
    
    public String getSenha() {
        System.out.println("Senha: ");
        return leituraDados.nextLine().trim();
    }
    
    public void exibeSucessoLogin(Funcionario funcionario) {
        System.out.println("\nLOGIN REALIZADO COM SUCESSO!");
        System.out.println("Bem-vindo(a), " + funcionario.getNome() + "!");
        
        if (funcionario.getCargo().toUpperCase().contains("GERENTE")) {
            System.out.println("Nívelde acesso: GERENTE (Acesso total)\n");
        } else {
            System.out.println("Nível de acesso: FUNCIONÁRIO (Acesso nornal)\n");
        }
    }
    
    public void exibeErroLogin() {
        System.out.println("\nUsuário ou senha inválidos! Tente novamente mais tarde.\n");
    }
    
    public void exibeAcessoNegado() {
        System.out.println("\nACESSO NEGADO! Apenas gerentes podem acessar esssa funcionalidade.\n");
    }
    
    @Override
    public String toString(){
        return "-- Interface de Login --";
    }
}