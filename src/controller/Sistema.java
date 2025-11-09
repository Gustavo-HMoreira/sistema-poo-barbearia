package controller;

import repository.RepositorioGeral;
import view.ViewPrincipal;

public class Sistema {

    protected static int clientesRegistro = 0;

    private LoginController loginController = new LoginController();
    private ViewPrincipal telaInicial = new ViewPrincipal();
    private ClienteController clienteController = new ClienteController();
    private FuncionarioController funcionarioController = new FuncionarioController();
    private EstoqueController estoqueController = new EstoqueController();
    private AgendamentoController agendamentoController = new AgendamentoController();
    private ControleFinanceiroController controleFinanceiroController = new ControleFinanceiroController();
    private NotaFiscalController notaFiscalController = new NotaFiscalController();
    private ServicoController servicoController = new ServicoController();
    private PontoController pontoController = new PontoController(); 

  
    public static int getQuantClientesProtegido() {
        return clientesRegistro;
    }

   
    public static void setQuantClientesProtegido(int clientesRegistro) {
        Sistema.clientesRegistro = clientesRegistro;
    }

    public void iniciaSistema() {
        RepositorioGeral.carregarDados(); 

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
                    funcionarioController.executaMenuFuncionario();
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
                    System.out.println("Encerrando sistema!");
                    System.out.println("Análise pós ecerramento do sistema:");
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
        
        return "Sistema da Barbearia POO - Usuário logado: "+ (loginController.getUsuarioLogado() != null
                ? loginController.getUsuarioLogado().getNome() : "Nenhum")+ " | Clientes: " + clientesRegistro;
                       
    }
}

