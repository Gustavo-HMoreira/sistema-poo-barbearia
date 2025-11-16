package poobarbearia;

import controller.Sistema;
import repository.RepositorioGeral;



public class Poobarbearia {
    public static void main(String[] args) {
        System.out.println("< SISTEMA DE GERENCIAMENTO DA BARBEARIA >");
        System.out.println("Iniciando sistema da barbearia!\n");
        
        try {
            // Carrega os dados persistidos ao iniciar o sistema
            RepositorioGeral.carregarDados();
            Sistema sistema = new Sistema();
            sistema.iniciaSistema();
        } catch (Exception e) {
            System.out.println("Erro ao iniciar o sistema: " + e.getMessage());
            e.printStackTrace();
        }
        
        System.out.println("\nSistema encerrado com sucesso!");
    }
}

