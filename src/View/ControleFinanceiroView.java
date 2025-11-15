package view;

import model.Transacoes;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelas interações com o usuário relacionadas ao sistema financeiro.
 * Realiza entradas e saídas de dados para operações financeiras.
 */
public class ControleFinanceiroView {
    
    /**
     * Scanner para leitura de dados inseridos pelo usuário.
     */
    Scanner leituraDados = new Scanner(System.in);

    /**
     * Exibe as opções disponíveis no menu de controle financeiro e retorna a opção escolhida.
     *
     * @return um número inteiro correspondente à opção selecionada pelo usuário
     */
    public int mostraOpcoesControleFinanceiro(){
        System.out.println("Digite a opção que deseja executar:");
        System.out.println("1 - Adicionar Receita");
        System.out.println("2 - Adicionar Despesa");
        System.out.println("3 - Gerar Relatório Mensal");
        System.out.println("4 - Gerar Balanço Mensal");
        System.out.println("5 - Sair");

        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }

    /**
     * Solicita e retorna a descrição da transação.
     *
     * @return Descrição da transação
     */
    public String getDescricaoTransacao(){
        System.out.println("Digite a descrição da transação: ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna o valor da transação.
     *
     * @return Valor da transação
     */
    public double getValorTransacao(){
        System.out.println("Digite o valor da transação: R$ ");
        double valor = leituraDados.nextDouble();
        leituraDados.nextLine();
        return valor;
    }

    /**
     * Solicita e retorna a data da transação.
     *
     * @return Data da transação
     */
    public LocalDate getDataTransacao(){
        System.out.println("Digite a data da transação (dd/MM/yyyy): ");
        String dataStr = leituraDados.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(dataStr, formatter);
    }

    /**
     * Solicita e retorna o mês para relatórios.
     *
     * @return Mês (1-12)
     */
    public int getMesRelatorio(){
        System.out.println("Digite o mês (1-12) para o relatório: ");
        int mes = leituraDados.nextInt();
        leituraDados.nextLine();
        return mes;
    }

    /**
     * Solicita e retorna o ano para relatórios.
     *
     * @return Ano
     */
    public int getAnoRelatorio(){
        System.out.println("Digite o ano para o relatório: ");
        int ano = leituraDados.nextInt();
        leituraDados.nextLine();
        return ano;
    }



    /**
     * Exibe o relatório mensal de transações.
     *
     * @param transacoes Lista de transações do mês
     * @param mes Mês do relatório
     * @param ano Ano do relatório
     */
    public void mostraRelatorioMensal(List<Transacoes> transacoes, int mes, int ano) {
        System.out.println("\n========================================");
        System.out.println("  RELATÓRIO MENSAL - " + String.format("%02d", mes) + "/" + ano);
        System.out.println("========================================");
        if (transacoes.isEmpty()) {
            System.out.println("Nenhuma transação registrada para este mês.");
            return;
        }

        double totalReceitas = 0;
        double totalDespesas = 0;

        System.out.println("\n--- Receitas ---");
        for (Transacoes t : transacoes) {
            if (t.getTipo() == Transacoes.TipoTransacao.RECEITA) {
                System.out.println(t.toString());
                totalReceitas += t.getValor();
            }
        }
        System.out.println("Total de Receitas: R$ " + String.format("%.2f", totalReceitas));

        System.out.println("\n--- Despesas ---");
        for (Transacoes t : transacoes) {
            if (t.getTipo() == Transacoes.TipoTransacao.DESPESA) {
                System.out.println(t.toString());
                totalDespesas += t.getValor();
            }
        }
        System.out.println("Total de Despesas: R$ " + String.format("%.2f", totalDespesas));
        System.out.println("========================================\n");
    }

    /**
     * Exibe o balanço mensal.
     *
     * @param totalReceitas Total de receitas
     * @param totalDespesas Total de despesas
     * @param mes Mês do balanço
     * @param ano Ano do balanço
     */
    public void mostraBalancoMensal(double totalReceitas, double totalDespesas, int mes, int ano) {
        System.out.println("\n========================================");
        System.out.println("  BALANÇO MENSAL - " + String.format("%02d", mes) + "/" + ano);
        System.out.println("========================================");
        System.out.println("Total de Receitas: R$ " + String.format("%.2f", totalReceitas));
        System.out.println("Total de Despesas: R$ " + String.format("%.2f", totalDespesas));
        System.out.println("Saldo: R$ " + String.format("%.2f", (totalReceitas - totalDespesas)));
        System.out.println("========================================\n");
    }

    @Override 
    public String toString(){
        return "- Interface Financeira -";
    }
}

