package controller;

import repository.RepositorioGeral;
import model.Transacao;

import view.ControleFinanceiroView;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class ControleFinanceiroController {
    private ControleFinanceiroView viewControleFinanceiro = new ControleFinanceiroView();

    public void executaMenuControleFinanceiro() {
        int opcao = 0;

        while (opcao != 5) {
            opcao = viewControleFinanceiro.mostraOpcoesControleFinanceiro();

            if (opcao == 5) {
                System.out.println("Saindo controle financeiro!");
                break;
            }

            
            switch (opcao) {
                case 1:
                    adicionaReceita();
                    break;
                case 2:
                    adicionaDespesa();
                    break;
                case 3:
                    gerarRelatorioMensal();
                    break;
                case 4:
                    gerarBalancoMensal();
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        }
    }

    private void adicionaReceita() {
        
        String descricao = viewControleFinanceiro.getDescricaoTransacao();
        double valor = viewControleFinanceiro.getValorTransacao();
        LocalDate data = viewControleFinanceiro.getDataTransacao();
        Transacao receita = new Transacao(descricao, valor, data, Transacao.TipoTransacao.RECEITA);
        RepositorioGeral.getTransacoes().add(receita);
        RepositorioGeral.salvarDados();
        System.out.println("Receita adicionada com sucesso!");
        
    }

    private void adicionaDespesa() {
        
        String descricao = viewControleFinanceiro.getDescricaoTransacao();
        double valor = viewControleFinanceiro.getValorTransacao();
        LocalDate data = viewControleFinanceiro.getDataTransacao();
        Transacao despesa = new Transacao(descricao, valor, data, Transacao.TipoTransacao.DESPESA);
        RepositorioGeral.getTransacoes().add(despesa);
        RepositorioGeral.salvarDados();
        System.out.println("Despesa adicionada com sucesso!");
        
    }

    private void gerarRelatorioMensal() {
        int mes = viewControleFinanceiro.getMesRelatorio();
        int ano = viewControleFinanceiro.getAnoRelatorio();

        List<Transacao> transacoesDoMes = RepositorioGeral.getTransacoes().stream()
            .filter(t -> t.getData().getMonthValue() == mes && t.getData().getYear() == ano).collect(Collectors.toList());
              
        viewControleFinanceiro.mostraRelatorioMensal(transacoesDoMes, mes, ano);
    }

    private void gerarBalancoMensal() {
        int mes = viewControleFinanceiro.getMesRelatorio();
        int ano = viewControleFinanceiro.getAnoRelatorio();

        List<Transacao> transacoesDoMes = RepositorioGeral.getTransacoes().stream()
              .filter(t -> t.getData().getMonthValue() == mes && t.getData().getYear() == ano).collect(Collectors.toList());
                

        
        double totalReceitas = transacoesDoMes.stream()
                .filter(t -> t.getTipo() == Transacao.TipoTransacao.RECEITA).mapToDouble(Transacao::getValor).sum();
                
        double totalDespesas = transacoesDoMes.stream()
                .filter(t -> t.getTipo() == Transacao.TipoTransacao.DESPESA).mapToDouble(Transacao::getValor).sum();              
        viewControleFinanceiro.mostraBalancoMensal(totalReceitas, totalDespesas, mes, ano);
    }

    @Override
    public String toString() {
        return String.format("ControleFinanceiroController: %d transações registradas.", RepositorioGeral.getTransacoes().size());
    }
}

