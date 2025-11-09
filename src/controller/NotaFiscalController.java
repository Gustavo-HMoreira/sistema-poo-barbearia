package controller;

import model.NotaFiscal;
import model.Cliente;
import repository.RepositorioGeral;
import model.Funcionario;
import model.Servico;
import model.Produto;
import model.pagamento.*;
import model.Transacoes;
import java.time.LocalDate;
import view.NotaFiscalView;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class NotaFiscalController {
    private NotaFiscalView viewNotaFiscal = new NotaFiscalView();
     
    
    public void executaMenuNotaFiscal(){
        int opcao = 0; 
        
        while(opcao != 5){
            opcao = viewNotaFiscal.mostraOpcoesNotaFiscal();
            
            if (opcao == 5) {
                System.out.println("Saindo do menu de Notas Fiscais!");
                break; 
            }
            
            switch (opcao){
                case 1: {
                    gerarNotaFiscal();
                }break;
                
                case 2: {
                    mostrarNotaFiscal();
                }break;
                
                case 3: {
                    listarNotasFiscais();
                }break;
                
                case 4: {
                    buscarNotasFiscaisPorCliente();
                }break;
                
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }

    private void gerarNotaFiscal() {
        int idNotaFiscal = gerarProximoIdNotaFiscal();
        
        int idCliente = viewNotaFiscal.getIdCliente();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream()
                                        .filter(c -> c.getIdCliente() == idCliente).findFirst();
                                                    
        if (!clienteOptional.isPresent()) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        Cliente cliente = clienteOptional.get();

        List<Servico> servicosSelecionados = viewNotaFiscal.getServicos(RepositorioGeral.getServicos());
        if (servicosSelecionados.isEmpty()) {
            System.out.println("Nenhum serviço selecionado. Nota fiscal não gerada.");
            return;
        }

        List<Produto> produtosSelecionados = viewNotaFiscal.getProdutos(RepositorioGeral.getProdutos());
        int idBarbeiro = viewNotaFiscal.getIdFuncionario();
        Optional<Funcionario> barbeiroOptional = RepositorioGeral.getFuncionarios().stream()
                                                   .filter(f -> f.getIdFuncionario() == idBarbeiro).findFirst();
                                                        
        if (!barbeiroOptional.isPresent()) {
            System.out.println("Barbeiro não encontrado!");
            return;
        }
        Funcionario barbeiro = barbeiroOptional.get();

        LocalDateTime dataEmissao = LocalDateTime.now(); 

        NotaFiscal novaNotaFiscal = new NotaFiscal(idNotaFiscal, cliente, servicosSelecionados, produtosSelecionados, barbeiro, dataEmissao);
        
        
        int opcaoPagamento = viewNotaFiscal.getFormaPagamento();
        FormaDePagamento forma;
        String descricaoFormaPagamento;
        
        switch (opcaoPagamento) {
            case 1:
                forma = new Pix();
                break;
            case 2:
                forma = new CartaoCreditoDebito();
                break;
            case 3:
                forma = new Dinheiro();
                break;
            default:
                System.out.println("Opção de pagamento inválida. Usando Dinheiro como padrão.");
                forma = new Dinheiro();
                break;
        }
        
        Pagamento pagamento = new PagamentoTransacao(forma);
        double valorTotal = novaNotaFiscal.getValorTotal();
        
        
        pagamento.processarPagamento(valorTotal);
        descricaoFormaPagamento = pagamento.getDescricaoFormaPagamento();
        
        
        novaNotaFiscal.setFormaPagamento(descricaoFormaPagamento);
        
        
        Transacoes receita = new Transacoes("Venda Nota Fiscal #" + idNotaFiscal, valorTotal, LocalDate.now(), Transacoes.TipoTransacao.RECEITA, descricaoFormaPagamento);
        RepositorioGeral.getTransacoes().add(receita);
        
        
        RepositorioGeral.getNotasFiscais().add(novaNotaFiscal);
        RepositorioGeral.salvarDados();
        System.out.println("Nota Fiscal gerada com sucesso! Forma do Pagamento: " + descricaoFormaPagamento);
    }

    private void mostrarNotaFiscal() {
        int id = viewNotaFiscal.getIdNotaFiscal();
        Optional<NotaFiscal> nfOptional = RepositorioGeral.getNotasFiscais().stream()
                                         .filter(nf -> nf.getIdNotaFiscal() == id).findFirst();
                                                  
        if (nfOptional.isPresent()) {
            viewNotaFiscal.mostraNotaFiscal(nfOptional.get());
        } else {
            System.out.println("Nota Fiscal não encontrada!");
        }
    }

    private void listarNotasFiscais() {
        List<NotaFiscal> notas = RepositorioGeral.getNotasFiscais();
        viewNotaFiscal.mostraListaNotasFiscais(notas);
    }

    private void buscarNotasFiscaisPorCliente() {
        int idCliente = viewNotaFiscal.getIdCliente();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream()
                                          .filter(c -> c.getIdCliente() == idCliente).findFirst();
                                                    
        if (!clienteOptional.isPresent()) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        Cliente cliente = clienteOptional.get();

        List<NotaFiscal> notas = RepositorioGeral.getNotasFiscais().stream()
                               .filter(nf -> nf.getCliente().equals(cliente)).collect(Collectors.toList());
                                            
        viewNotaFiscal.mostraListaNotasFiscais(notas);
    }
    
    private int gerarProximoIdNotaFiscal() {
        return RepositorioGeral.getNotasFiscais().stream().mapToInt(NotaFiscal::getIdNotaFiscal)
                .max().orElse(0) + 1; //calcula o próximo ID automaticmaente             
    }

    @Override 
    public String toString(){
        return String.format("NotaFiscalController: %d Notas Fiscais registradas.", RepositorioGeral.getNotasFiscais().size());
    }
}

