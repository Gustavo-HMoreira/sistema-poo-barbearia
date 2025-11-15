package controller;

import model.Produto;
import repository.RepositorioGeral;
import view.EstoqueView;

import java.util.List;
import java.util.Optional;

/**
 * Classe responsável pela gerência dos produtos da barbearia.
 * Fornecendo métodos para adicionar e acessar o menu de opções de produtos.
 */
public class EstoqueController {
    private EstoqueView viewEstoque = new EstoqueView();
     
    /**
     * Exibe o menu de opções para os Produtos e executa a ação solicitada pelo usuário.
     * O menu permanece ativo até que o usuário selecione a opção de sair.
     */
    public void executaMenuEstoque(){
        int opcao = 0; 
        
        while(opcao != 7){
            opcao = viewEstoque.mostraOpcoesEstoque();
            
            if (opcao == 7) {
                System.out.println("Saindo do controle de estoque...");
                break; 
            }
            
            switch (opcao){
                case 1: {
                    adicionaProduto();
                }
                break;
                case 2: {
                    editaProduto();
                }
                break;
                case 3: {
                    removeProduto();
                }
                break;
                case 4: {
                    mostrarProduto();
                }
                break;
                case 5: {
                    alteraQuantidadeProduto();
                }
                break;
                case 6: {
                    mostrarEstoqueCompleto();
                }
                break;
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }

    private void adicionaProduto() {
        int idProduto = gerarProximoIdProduto();
        String nome = viewEstoque.getNomeProduto();
        String descricao = viewEstoque.getDescricaoProduto();
        double valorUnitario = viewEstoque.getValorProduto();
        int quantidade = viewEstoque.getQuantidadeProduto();
        Produto novoProduto = new Produto(idProduto, nome, descricao, valorUnitario, quantidade);
        RepositorioGeral.getProdutos().add(novoProduto);
        RepositorioGeral.salvarDados();
        System.out.println("Produto adicionado com sucesso!");
    }

    private void editaProduto() {
        int id = viewEstoque.getIdProduto();
        Optional<Produto> produtoOptional = RepositorioGeral.getProdutos().stream()
                                                    .filter(p -> p.getIdProduto() == id)
                                                    .findFirst();

        if (!produtoOptional.isPresent()) {
            System.out.println("Produto não encontrado!");
            return;
        }

        Produto produto = produtoOptional.get();
        viewEstoque.mostraProduto(produto);
        int opcao = viewEstoque.editaProduto();

        switch (opcao) {
            case 1: produto.setNome(viewEstoque.getNomeProduto());
                break;
            case 2: produto.setDescricao(viewEstoque.getDescricaoProduto());
                break;
            case 3: produto.setValorUnitario(viewEstoque.getValorProduto());
                break;
            default: {
                System.out.println("Opção inválida! Nenhuma alteração realizada.");
                return;
            }
        }
        RepositorioGeral.salvarDados();
        System.out.println("Produto editado com sucesso!");
    }

    private void removeProduto() {
        int id = viewEstoque.getIdProduto();
        Optional<Produto> produtoOptional = RepositorioGeral.getProdutos().stream()
                                                    .filter(p -> p.getIdProduto() == id)
                                                    .findFirst();

        if (!produtoOptional.isPresent()) {
            System.out.println("Produto não encontrado!");
            return;
        }

        Produto produto = produtoOptional.get();
        viewEstoque.mostraProduto(produto);
        String confirmacao = viewEstoque.confirmaExclusaoProduto();
        
        if (!confirmacao.equalsIgnoreCase("S")) {
            System.out.println("Operação abortada!!");
            return;
        }

        if (RepositorioGeral.getProdutos().remove(produto)) {
            RepositorioGeral.salvarDados();
            System.out.println("Produto removido com sucesso!");
        } else {
            System.out.println("Falha ao remover produto! :(");
        }
    }

    private void mostrarProduto() {
        int id = viewEstoque.getIdProduto();
        Optional<Produto> produtoOptional = RepositorioGeral.getProdutos().stream()
                                                    .filter(p -> p.getIdProduto() == id)
                                                    .findFirst();
        if (produtoOptional.isPresent()) {
            viewEstoque.mostraProduto(produtoOptional.get());
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private void alteraQuantidadeProduto() {
        int id = viewEstoque.getIdProduto();
        Optional<Produto> produtoOptional = RepositorioGeral.getProdutos().stream()
                                                    .filter(p -> p.getIdProduto() == id)
                                                    .findFirst();

        if (!produtoOptional.isPresent()) {
            System.out.println("Produto não encontrado!");
            return;
        }

        Produto produto = produtoOptional.get();
        int opcao = viewEstoque.editaQuantidadeProduto(produto);
        int quantidade = viewEstoque.getQuantidadeProduto();

        if (opcao == 1) {
            produto.adicionaQuantidade(quantidade);
        } else if (opcao == 2) {
            produto.removeQuantidade(quantidade);
        } else {
            System.out.println("Opção inválida! Nenhuma alteração realizada.");
            return;
        }

        RepositorioGeral.salvarDados();
        System.out.println("Quantidade do produto alterada com sucesso!");
    }

    private void mostrarEstoqueCompleto() {
        List<Produto> produtos = RepositorioGeral.getProdutos();
        viewEstoque.mostraListaProdutos(produtos);
    }
    
    private int gerarProximoIdProduto() {
        return RepositorioGeral.getProdutos().stream()
                .mapToInt(Produto::getIdProduto)
                .max()
                .orElse(0) + 1;
    }

    @Override 
    public String toString(){
        return String.format("EstoqueController: %d produtos registrados.", RepositorioGeral.getProdutos().size());
    }
}

