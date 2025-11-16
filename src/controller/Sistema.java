package controller;

import repository.RepositorioGeral;
import view.ViewPrincipal;

/**
 * A classe Sistema é a principal classe de controle e gerenciamento da barbearia.
 * Ela orquestra a interação entre as diferentes funcionalidades (clientes,
 * funcionários, agendamentos, produtos, notas fiscais, financeiro) e gerencia o fluxo geral do sistema,
 * exibindo o menu principal e delegando as operações para os respectivos
 * controladores. O sistema carrega os dados persistidos no início e salva-os ao
 * ser encerrado.
 */
public class Sistema {

    protected static int quantClientesProtegido = 0;

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
     * Inicia o sistema com tela de login.
     */
    public void iniciaSistema() {
        RepositorioGeral.carregarDados(); // Carrega todos os dados ao iniciar o sistema

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
                    if(loginController.podeCadastrarFuncionario()){ //verificação para funcionário 
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
                ? loginController.getUsuarioLogado().getNome() : "Nenhum")
                + " | Clientes: " + quantClientesProtegido;
    }
}

