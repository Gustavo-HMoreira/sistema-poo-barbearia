package view;

import model.Produto;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável pelas interações com o usuário relacionadas aos produtos em estoque.
 * Realiza entradas e saídas de dados para operações como incluir, editar, remover, e mostrar dados do produto.
 */
public class EstoqueView {
    
    /**
     * Scanner para leitura de dados inseridos pelo usuário.
     */
    Scanner leituraDados = new Scanner(System.in);
    
    /**
     * Exibe as opções disponíveis no menu de estoque e retorna a opção escolhida.
     * 
     * @return um número inteiro correspondente à opção selecionada pelo usuário.
     */
    public int mostraOpcoesEstoque(){
        System.out.println("Digite a opção que deseja executar: ");
        System.out.println("1 - Incluir produto");
        System.out.println("2 - Editar produto");
        System.out.println("3 - Remover produto");
        System.out.println("4 - Mostrar dados de um produto");
        System.out.println("5 - Alterar quantidade produto (Aumentar/diminuir)");
        System.out.println("6 - Conferir estoque completo");
        System.out.println("7 - Sair");

        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }
    
    /**
     * Solicita e retorna o ID do produto inserido pelo usuário.
     * 
     * @return ID do produto.
     */
    public int getIdProduto(){
        System.out.println("Digite o ID do produto: ");
        int idProduto = leituraDados.nextInt();
        leituraDados.nextLine();
        return idProduto;
    }
    
    /**
     * Solicita e retorna o nome do produto inserido pelo usuário.
     * 
     * @return Nome do produto.
     */
    public String getNomeProduto(){
        System.out.println("Digite o nome do produto: ");
        return leituraDados.nextLine();
    }

    /**
     * Solicita e retorna a descrição do produto inserido pelo usuário.
     * 
     * @return Descrição do produto.
     */
    public String getDescricaoProduto(){
        System.out.println("Digite a descrição do produto: ");
        return leituraDados.nextLine();
    }
    
    /**
     * Solicita e retorna a quantidade do produto.
     * 
     * @return Quantidade em estoque. 
     */
    public int getQuantidadeProduto(){
        System.out.println("Digite a quantidade do produto: ");
        int quantidadeProd = leituraDados.nextInt();
        leituraDados.nextLine();
        return quantidadeProd; 
    }
    
    /**
     * Solicita e retorna o valor do produto inserido pelo usuário.
     * 
     * @return Valor do produto.
     */
    public double getValorProduto(){
        System.out.println("Digite o valor do produto: ");
        double valorProd = leituraDados.nextDouble();
        leituraDados.nextLine();
        return valorProd;
    }
    
    /**
     * Exibe os dados de um produto.
     * 
     * @param produto Produto cujos dados serão exibidos.
     */
    public void mostraProduto(Produto produto){
        System.out.println("ID: " +  produto.getIdProduto()                     + "\n" + 
                           "Nome: " + produto.getNome()                        + "\n" +
                           "Descrição: " + produto.getDescricao()             + "\n" +
                           "Quantidade: " + produto.getQuantidadeEstoque() + "\n" +
                           "Valor: R$" + String.format("%.2f", produto.getValorUnitario())           + "\n");
    }
    
    /**
     * Solicita confirmação para exclusão do produto.
     * 
     * @return "S" para confirmar, qualquer outra tecla para cancelar.
     */
    public String confirmaExclusaoProduto(){
        System.out.println("Tem certeza que deseja remover este produto? \n"
                         + "Digite [S] para confirmar ou [N] para abortar a operação!!");
        return leituraDados.nextLine();
    }
    
    /**
     * Exibe as opções de campos que podem ser editados e retorna a escolha do usuário.
     * 
     * @return número inteiro correspondente ao campo selecionado (1 ou 2). 
     */
    public int editaProduto(){
        System.out.println("Digite o campo que você gostaria de editar!");
        System.out.println("1 - Nome");
        System.out.println("2 - Descrição");
        System.out.println("3 - Valor");
      
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }
    
    /**
     * Exibe opções para alterar a quantidade do produto (aumentar ou diminuir).
     * 
     * @param produto Produto cuja quantidade será alterada.
     * @return Número inteiro correspondente à opção selecionada.
     */
    public int editaQuantidadeProduto(Produto produto){
        System.out.println("Quantidade atual: " + produto.getQuantidadeEstoque());
        System.out.println("Como deseja alterar a quantidade do produto?");
        System.out.println("1 - Aumentar");
        System.out.println("2 - Diminuir");
        
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }
    
    /**
     * Exibe uma linha simplificada com a descrição e quantidade de um produto no estoque.
     * 
     * @param produto Produto a ser exibido.
     */
    public void mostraEstoque(Produto produto){
        System.out.println(produto.getNome() + "| Quantidade: " + produto.getQuantidadeEstoque());
    }

    /**
     * Exibe a lista de todos os produtos em estoque.
     *
     * @param produtos Lista de produtos
     */
    public void mostraListaProdutos(List<Produto> produtos) {
        if (produtos == null || produtos.isEmpty()) {
            System.out.println("Nenhum produto registrado no estoque.");
            return;
        }

        System.out.println("LISTA DE PRODUTOS EM ESTOQUE");
        for (Produto produto : produtos) {
            System.out.println("ID: " + produto.getIdProduto() + 
                             " | Nome: " + produto.getNome() + 
                             " | Quantidade: " + produto.getQuantidadeEstoque() +
                             " | Valor Unitário: R$ " + String.format("%.2f", produto.getValorUnitario()));
        }
        System.out.println("============================================================");
    }
    
    @Override
    public String toString(){
        return "- Interface do Estoque -";
    }
}

