package view;

import model.Cliente;
import model.Funcionario;
import model.NotaFiscal;
import model.Produto;
import model.Servico;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class NotaFiscalView {
    private Scanner leituraDados = new Scanner(System.in);

    public int mostraOpcoesNotaFiscal() {
        System.out.println("\n--- Menu de Notas Fiscais ---");
        System.out.println("1 - Gerar Nova Nota Fiscal");
        System.out.println("2 - Mostrar Nota Fiscal por ID");
        System.out.println("3 - Listar Todas as Notas Fiscais");
        System.out.println("4 - Buscar Notas Fiscais por Cliente");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine(); // Consumir a nova linha
        return opcao;
    }

    public int getIdNotaFiscal() {
        System.out.print("Digite o ID da Nota Fiscal: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }

    public int getIdCliente() {
        System.out.print("Digite o ID do Cliente: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }

    public int getIdFuncionario() {
        System.out.print("Digite o ID do Barbeiro Responsável: ");
        int id = leituraDados.nextInt();
        leituraDados.nextLine();
        return id;
    }

    /**
     * Exibe o menu de formas de pagamento e retorna a opção escolhida.
     *
     * @return O número da opção escolhida (1, 2 ou 3).
     */
    public int getFormaPagamento() {
        System.out.println("\n--- Selecionar Forma de Pagamento ---");
        System.out.println("1 - Pix");
        System.out.println("2 - Cartão de Crédito");
        System.out.println("3 - Dinheiro");
        System.out.print("Escolha uma opção: ");
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }

    public List<Servico> getServicos(List<Servico> servicosDisponiveis) {
        List<Servico> servicosSelecionados = new ArrayList<>();
        System.out.println("\n--- Selecionar Serviços ---");
        if (servicosDisponiveis.isEmpty()) {
            System.out.println("Nenhum serviço disponível para seleção.");
            return servicosSelecionados;
        }

        System.out.println("Serviços disponíveis:");
        servicosDisponiveis.forEach(System.out::println);

        while (true) {
            System.out.print("Digite o ID do serviço a adicionar (ou 0 para finalizar): ");
            int idServico = leituraDados.nextInt();
            leituraDados.nextLine();

            if (idServico == 0) {
                break;
            }

            Optional<Servico> servicoOptional = servicosDisponiveis.stream()
                    .filter(s -> s.getIdServico() == idServico)
                    .findFirst();

            if (servicoOptional.isPresent()) {
                servicosSelecionados.add(servicoOptional.get());
                System.out.println("Serviço adicionado.");
            } else {
                System.out.println("Serviço não encontrado.");
            }
        }
        return servicosSelecionados;
    }

    public List<Produto> getProdutos(List<Produto> produtosDisponiveis) {
        List<Produto> produtosSelecionados = new ArrayList<>();
        System.out.println("\n--- Selecionar Produtos ---");
        if (produtosDisponiveis.isEmpty()) {
            System.out.println("Nenhum produto disponível para seleção.");
            return produtosSelecionados;
        }

        System.out.println("Produtos disponíveis:");
        produtosDisponiveis.forEach(System.out::println);

        while (true) {
            System.out.print("Digite o ID do produto a adicionar (ou 0 para finalizar): ");
            int idProduto = leituraDados.nextInt();
            leituraDados.nextLine();

            if (idProduto == 0) {
                break;
            }

            Optional<Produto> produtoOptional = produtosDisponiveis.stream()
                    .filter(p -> p.getIdProduto() == idProduto)
                    .findFirst();

            if (produtoOptional.isPresent()) {
                System.out.print("Digite a quantidade: ");
                int quantidade = leituraDados.nextInt();
                leituraDados.nextLine();
                Produto produtoOriginal = produtoOptional.get();
                produtosSelecionados.add(new Produto(produtoOriginal.getIdProduto(), produtoOriginal.getNome(),
                        produtoOriginal.getDescricao(), produtoOriginal.getValorUnitario(), quantidade));
                System.out.println("Produto adicionado.");
            } else {
                System.out.println("Produto não encontrado.");
            }
        }
        return produtosSelecionados;
    }

    public void mostraNotaFiscal(NotaFiscal nf) {
        System.out.println(nf.toString());
    }

    public void mostraListaNotasFiscais(List<NotaFiscal> notasFiscais) {
        if (notasFiscais.isEmpty()) {
            System.out.println("Nenhuma nota fiscal registrada.");
            return;
        }
        System.out.println("\n--- Lista de Notas Fiscais ---");
        notasFiscais.forEach(nf -> System.out.println("ID: " + nf.getIdNotaFiscal() + ", Cliente: " + nf.getCliente().getNome() + ", Valor Total: R$ " + String.format("%.2f", nf.getValorTotal())));
        System.out.println("------------------------------");
    }

    @Override
    public String toString() {
        return "- Interface de Notas Fiscais -";
    }
}

