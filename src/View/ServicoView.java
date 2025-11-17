package view;

import model.Servico;
import model.TipoServico;
import java.util.List;
import java.util.Scanner;

public class ServicoView {
    private Scanner leituraDados = new Scanner(System.in);

    public int mostraOpcoesServico() {
         System.out.println("Digite a opção que deseja executar:");
         System.out.println("1 - Incluir Serviço");
         System.out.println("2 - Editar Serviço");
         System.out.println("3 - Remover Serviço");
         System.out.println("4 - Mostrar dados de um Serviço");
         System.out.println("5 - Listar Todos os Serviços");
         System.out.println("6 - Sair");

        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }

    public int getIdServico() {
        System.out.println("Digite o ID do serviço: ");
        int idServico = leituraDados.nextInt();
        leituraDados.nextLine();
        return idServico;
    }

    public String getNomeServico() {
        System.out.println("Digite o nome do serviço: ");
        return leituraDados.nextLine();
    }

    public String getDescricaoServico() {
        System.out.println("Digite a descrição do serviço: ");
        return leituraDados.nextLine();
    }

    public double getPrecoServico() {
         System.out.println("Digite o preço do serviço: ");
        double preco = leituraDados.nextDouble();
        leituraDados.nextLine();
        return preco;
    }

    public TipoServico getTipoServico() {
         System.out.println("Selecione o tipo de serviço:");
         System.out.println("1 - Corte de Cabelo");
         System.out.println("2 - Barba");
         System.out.println("3 - Corte e Barba");
         System.out.println("4 - Outro");

        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();

        TipoServico tipo = TipoServico.converteCodigo(opcao);
        if (tipo == null) {
            System.out.println("Opção inválida! Definindo como OUTRO por padrão.");
            return TipoServico.OUTRO;
        }
        return tipo;
    }

    public void mostraServico(Servico servico) {
        System.out.println("ID: " + servico.getIdServico() + "\n" +
                  "Nome: " + servico.getNomeServico() + "\n" +
                  "Descrição: " + servico.getDescricao() + "\n" +
                  "Preço: R$" + String.format("%.2f", servico.getPreco()) + "\n" +
                  "Tipo: " + servico.getTipoServico().getDescricao() + "\n");
    }

    public String confirmaExclusaoServico() {
        System.out.println("Tem certeza que deseja remover este serviço? \n"
                    + "Digite [S] para confirmar ou [N] para abortar a operação!!");
        return leituraDados.nextLine();
    }

    public int editaServico() {
        System.out.println("Digite o campo que você gostaria de editar!");
        System.out.println("1 - Nome");
        System.out.println("2 - Descrição");
        System.out.println("3 - Preço");
        System.out.println("4 - Tipo");

        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }

    public void mostraListaServicos(List<Servico> servicos) {
        if (servicos == null || servicos.isEmpty()) {
            System.out.println("Nenhum serviço registrado.");
            return;
        }

        System.out.println("LISTA DE SERVIÇOS");
        for (Servico servico : servicos) {
            System.out.println("ID: " + servico.getIdServico() + 
            " | Nome: " + servico.getNomeServico() + 
            " | Preço: R$ " + String.format("%.2f", servico.getPreco()) +
            " | Tipo: " + servico.getTipoServico().getDescricao());
        }
        System.out.println("------------------------------------------------------------");
    }                       

    @Override
    public String toString() {
        return "-  Interface de Serviços  -";
    }
}

