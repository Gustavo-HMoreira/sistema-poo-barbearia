package view;

import model.RegistroPonto;
import model.RegistroPonto;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class PontoView {
    private Scanner leituraDados = new Scanner(System.in);

    public int mostraOpcoesPonto() {
         System.out.println("\n-  Sistema de Ponto  -");
         System.out.println("1 - Registrar Entrada");
         System.out.println("2 - Registrar Saída");
         System.out.println("3 - Consultar Registros de Ponto (por funcionário)");
         System.out.println("4 - Consultar Todos os Registros de Ponto");
         System.out.println("5 - Sair");
         System.out.print("Escolha uma opção: ");
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine(); // Consumir a linha
        return opcao;
    }

    public int getIdFuncionarioParaRegistro() {
         System.out.print("Digite o ID do funcionário para registrar o ponto: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }

    public int getIdFuncionarioParaConsulta() {
       System.out.print("Digite o ID do funcionário para consultar os registros de ponto (0 para todos): ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }

    public void mostraRegistrosPonto(List<RegistroPonto> registros) {
        if (registros.isEmpty()) {
            System.out.println("Nenhum registro de ponto encontrado.");
            return;
        }
        System.out.println("\n -- Registros de Ponto  --");
        for (RegistroPonto registro : registros) {
            System.out.println(registro.toString());
        }
        System.out.println("--------------------------\n");
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}

