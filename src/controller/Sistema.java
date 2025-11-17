package controller;

import model.EstacaoAtendimento;
import model.FilaAtendimento;
import repository.RepositorioGeral;
import view.ViewPrincipal;

/**
 * A classe Sistema é a classe principal de controle e gerenciamento da barbearia.
 * Ela coordena a interação entre as diferentes funcionalidades (clientes,
 * funcionários, agendamentos, produtos, notas fiscais, financeiro) e gerencia o fluxo geral do sistema,
 * exibindo o menu principal e delegando as operações para os respectivos
 * controladores. O sistema carrega os dados persistidos no início e salva-os ao
 * ser encerrado.
 */
public class Sistema {

    // Q11: Contador de serviços usando protected (acesso protegido)
    protected static int quantidadeServicosProtegido = 0;
    
    // Q11: Contador de serviços usando encapsulamento (private com getters/setters)
    private static int quantidadeServicos = 0;
    
    // Q5: Vetor estático de 3 estações de atendimento (tamanho fixo)
    public static final EstacaoAtendimento[] ESTACOES = new EstacaoAtendimento[3];
    
    // Q15: Fila FIFO para atendimentos secundários
    private static FilaAtendimento filaAtendimento = new FilaAtendimento();
    
    protected static int quantClientesProtegido = 0;
    
    // Bloco estático para inicializar as 3 estações
    static {
        for (int i = 0; i < 3; i++) {
            ESTACOES[i] = new EstacaoAtendimento(i + 1);
        }
    }

    
     private LoginController loginController = new LoginController();
     private ViewPrincipal telaInicial = new ViewPrincipal();
     private ClienteController clienteController = new ClienteController();
     private FuncionarioController funcionarioController = new FuncionarioController();
     private EstoqueController estoqueController = new EstoqueController();
     private AgendamentoController agendamentoController = new AgendamentoController();
     private ControleFinanceiroController controleFinanceiroController = new ControleFinanceiroController();
     private NotaFiscalController notaFiscalController = new NotaFiscalController();
     private ServicoController servicoController = new ServicoController();
     private PontoController pontoController = new PontoController(); // Instancia o PontoController

    
    
    /**
     * Obtém a quantidade de clientes cadastrados no sistema.
     * 
     * @return Quantidade de clientes protegidos.
     */
    public static int getQuantClientesProtegido() {
        return quantClientesProtegido;
    }

    /**
     * Define a quantidade de clientes cadastrados no sistema.
     * 
     * @param quantClientesProtegido Nova quantidade de clientes.
     */
    public static void setQuantClientesProtegido(int quantClientesProtegido) {
        Sistema.quantClientesProtegido = quantClientesProtegido;
    }
    
    /**
     * Questão 11a: Obtém a quantidade de serviços criados (encapsulamento private).
     * Esta é a primeira estratégia usando private com getter/setter.
     * 
     * Vantagens: Maior controle e segurança, permite validação e lógica adicional.
     * Desvantagens: Requer métodos acessores, mais verboso.
     * 
     * @return Quantidade de serviços criados.
     */
    public static int getQuantidadeServicos() {
        return quantidadeServicos;
    }
    
    /**
     * Questão 11a: Define a quantidade de serviços criados (encapsulamento private).
     * 
     * @param quantidade Nova quantidade de serviços.
     */
    public static void setQuantidadeServicos(int quantidade) {
        quantidadeServicos = quantidade;
    }
    
    /**
     * Questão 11a: Incrementa o contador de serviços (encapsulamento private).
     */
    public static void incrementarQuantidadeServicos() {
        quantidadeServicos++;
    }
    
    /**
     * Questão 11b: Incrementa o contador de serviços protegido.
     * Esta é a segunda estratégia usando protected (acesso direto em subclasses/mesmo pacote).
     * 
     * Vantagens: Acesso mais direto, menos verboso, útil para herança.
     * Desvantagens: Menos controle, qualquer classe do mesmo pacote pode modificar.
     */
    public static void incrementarQuantidadeServicosProtegido() {
        quantidadeServicosProtegido++;
    }
    
    /**
     * Questão 12: Retorna a quantidade de instâncias de OrdemDeServico criadas.
     * 
     * @return Quantidade de ordens de serviço no repositório.
     */
    public static int getQuantidadeOrdensDeServico() {
        return RepositorioGeral.getOrdensDeServico().size();
    }
    
    /**
     * Questão 5: Tenta alocar um atendimento em uma estação disponível.
     * 
     * @param idAtendimento ID do atendimento a ser alocado.
     * @return true se conseguiu alocar, false se todas as estações estão ocupadas.
     */
    public static boolean alocarEstacao(int idAtendimento) {
        for (EstacaoAtendimento estacao : ESTACOES) {
            if (estacao.alocarAtendimento(idAtendimento)) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Questão 5: Libera uma estação específica.
     * 
     * @param idEstacao ID da estação a ser liberada (1, 2 ou 3).
     */
    public static void liberarEstacao(int idEstacao) {
        if (idEstacao >= 1 && idEstacao <= 3) {
            ESTACOES[idEstacao - 1].liberarEstacao();
        }
    }
    
    /**
     * Questão 15: Obtém a fila de atendimento.
     * 
     * @return FilaAtendimento do sistema.
     */
    public static FilaAtendimento getFilaAtendimento() {
        return filaAtendimento;
    }

    /**
     * Inicia o sistema com tela de login.
     */
    public void iniciaSistema() {
        RepositorioGeral.carregarDados(); // Carrega todos os dados ao iniciar o sistema!

        if (!loginController.realizarLogin()) {
            System.out.println("Falha no login. Sistema encerrado.");
            return;
        }

        boolean rodando = true;

        while (rodando) {
            int opcaoDisponivel = telaInicial.mostraOpcoesDisponiveis();

            switch (opcaoDisponivel) {
                case 1:
                    clienteController.executaMenuCliente();
                break;
                case 2:
                    if(loginController.podeCadastrarFuncionario()){ //verificação se é gerente ou funcionário
                    funcionarioController.executaMenuFuncionario();
                    }
                break;
                case 3:
                    estoqueController.executaMenuEstoque();
                break;
                case 4:
                    agendamentoController.executaMenuAgendamento();
                break;
                case 5:
                    notaFiscalController.executaMenuNotaFiscal();
                break;
                case 6:
                    controleFinanceiroController.executaMenuControleFinanceiro();
                break;
                case 7:
                    servicoController.executaMenuServico();
                break;
                case 8:
                    pontoController.executaMenuPonto();
                break;
                case 9: { 
                   System.out.println("Encerrando sistema...");
                   System.out.println("Estatísticas do sistema:");
                   System.out.println("Total de clientes cadastrados: " + RepositorioGeral.getClientes().size());
                   System.out.println("Total de funcionários cadastrados: " + RepositorioGeral.getFuncionarios().size());
                   System.out.println("Total de produtos em estoque: " + RepositorioGeral.getProdutos().size());
                   System.out.println("Total de agendamentos: " + RepositorioGeral.getAgendamentos().size());
                   System.out.println("Total de notas fiscais emitidas: " + RepositorioGeral.getNotasFiscais().size());
                   System.out.println("Total de transações financeiras: " + RepositorioGeral.getTransacoes().size());
                   System.out.println("Total de serviços cadastrados: " + RepositorioGeral.getServicos().size());
                   System.out.println("Total de registros de ponto: " + RepositorioGeral.getRegistrosPonto().size());
                   System.out.println("Total de ordens de serviço: " + RepositorioGeral.getOrdensDeServico().size());
                   System.out.println("Contador de serviços (private): " + Sistema.getQuantidadeServicos());
                   System.out.println("Contador de serviços (protected): " + Sistema.quantidadeServicosProtegido);
                    
                    RepositorioGeral.salvarDados(); 
                    rodando = false;
                }
                break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                break;
            }
        }
    }

    @Override
    public String toString() {
        return "Sistema da Barbearia POO - Usuário logado: "
             + (loginController.getUsuarioLogado() != null
             ? loginController.getUsuarioLogado().getNome() : "Nenhum")+ " | Clientes: " + quantClientesProtegido;              
    }
}

