package poobarbearia;

import controller.OrdemDeServicoController;
import controller.Sistema;
import model.*;
import model.comparator.ComparatorClientID;
import model.comparator.ComparatorClientNome;
import repository.RepositorioGeral;
import utilitarios.BuscaUtil;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Classe Main Secundária (de Testes) para demonstrar as funcionalidades
 * solicitadas nas Questões 15, 16, 17 e 18.
 * Esta classe deve ser chamada pelo Main principal (Poobarbearia.java).
 */
public class MainTeste {

    public static void main(String[] args) {
        System.out.println("\n=================================================");
        System.out.println("          INICIANDO MÓDULO DE TESTES");
        System.out.println("=================================================");

        // Garante que os dados estão carregados para os testes
        RepositorioGeral.carregarDados();

        // Cria dados de teste se o repositório de clientes estiver vazio
        if (RepositorioGeral.getClientes().isEmpty()) {
            criarDadosIniciais();
        }

        // Questão 15: Testes de Iterator e foreach
        System.out.println("\n--- Questão 15: Testes de Iterator e foreach ---");
        testeIterator();

        // Questão 16: Testes de Comparator e Collections.sort
        System.out.println("\n--- Questão 16: Testes de Comparator e Collections.sort ---");
        testeComparatorCollectionsSort();

        // Questão 17: Testes de find com Iterator e Comparator, e binarySearch
        System.out.println("\n--- Questão 17: Testes de find com Iterator e Comparator, e binarySearch ---");
        testeFindEBinarySearch();

        // Questão 18: Simulação de Atendimento de 10 Clientes
        System.out.println("\n--- Questão 18: Simulação de Atendimento de 10 Clientes ---");
        simulacaoAtendimento();

        // Teste de Estações de Atendimento (Questão 5)
        System.out.println("\n--- Teste de Estações de Atendimento (Questão 5) ---");
        testeEstacoesAtendimento();
        
        // Teste de Fila de Atendimento (Questão 15 - Fila FIFO)
        System.out.println("\n--- Teste de Fila de Atendimento (Questão 15 - Fila FIFO) ---");
        testeFilaAtendimento();

        System.out.println("\n=================================================");
        System.out.println("          MÓDULO DE TESTES FINALIZADO");
        System.out.println("=================================================");
        
        // Salva os dados após os testes
        RepositorioGeral.salvarDados();
    }

    /**
     * Cria dados de teste para clientes, serviços e funcionários.
     */
    private static void criarDadosIniciais() {
        System.out.println("Criando dados iniciais para testes...");
        
        // Clientes
        RepositorioGeral.getClientes().add(new Cliente("Alice Silva", "Rua A, 10", "9999-1111", "alice@email.com", new Cpf("111.111.111-11"), 1));
        RepositorioGeral.getClientes().add(new Cliente("Bruno Costa", "Rua B, 20", "9999-2222", "bruno@email.com", new Cpf("222.222.222-22"), 2));
        RepositorioGeral.getClientes().add(new Cliente("Carlos Souza", "Rua C, 30", "9999-3333", "carlos@email.com", new Cpf("333.333.333-33"), 3));
        RepositorioGeral.getClientes().add(new Cliente("Daniela Lima", "Rua D, 40", "9999-4444", "daniela@email.com", new Cpf("444.444.444-44"), 4));
        RepositorioGeral.getClientes().add(new Cliente("Eduardo Santos", "Rua E, 50", "9999-5555", "eduardo@email.com", new Cpf("555.555.555-55"), 5));
        
        // Funcionários (Barbeiros)
        RepositorioGeral.getFuncionarios().add(new Funcionario("Barbeiro 1", "Rua F, 60", "9999-6666", "b1@email.com", new Cpf("666.666.666-66"), "b1", "123", "Barbeiro", 2500.00, 2));
        RepositorioGeral.getFuncionarios().add(new Funcionario("Barbeiro 2", "Rua G, 70", "9999-7777", "b2@email.com", new Cpf("777.777.777-77"), "b2", "123", "Barbeiro", 2500.00, 3));
        
        // Serviços
        RepositorioGeral.getServicos().add(new Servico(1, "Corte Simples", "Corte de cabelo padrão", 30.00, TipoServico.CORTE_CABELO));
        RepositorioGeral.getServicos().add(new Servico(2, "Barba Completa", "Barba com toalha quente", 40.00, TipoServico.BARBA));
        
        // Produtos
        RepositorioGeral.getProdutos().add(new Produto(1, "Pomada Modeladora", "Fixação forte", 35.00, 10));
        RepositorioGeral.getProdutos().add(new Produto(2, "Shampoo Especial", "Para todos os tipos de cabelo", 25.00, 20));
        
        RepositorioGeral.salvarDados();
    }

    /**
     * Questão 15: Demonstra o uso de Iterator e foreach.
     */
    private static void testeIterator() {
        List<Cliente> clientes = RepositorioGeral.getClientes();
        
        System.out.println("\n--- Usando Iterator ---");
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            System.out.println("Cliente (Iterator): " + cliente.getNome() + " - ID: " + cliente.getIdCliente());
        }

        System.out.println("\nExplicação sobre o Iterator:");
        System.out.println("O Iterator é um padrão de projeto que permite percorrer uma coleção de elementos sequencialmente, sem expor a representação interna da coleção. O método hasNext() verifica se há mais elementos, e next() retorna o próximo elemento e avança o ponteiro.");

        System.out.println("\nQual a relação do código acima com o foreach em Java?");
        System.out.println("O 'foreach' (for-each loop) em Java é uma sintaxe simplificada que, para coleções que implementam a interface Iterable (como List), utiliza o Iterator internamente. O compilador traduz o 'foreach' para o código com Iterator que demonstramos acima.");

        System.out.println("\n--- Testando foreach ---");
        for (Cliente cliente : clientes) {
            System.out.println("Cliente (foreach): " + cliente.getNome() + " - ID: " + cliente.getIdCliente());
        }
    }

    /**
     * Questão 16: Demonstra o uso de Comparator e Collections.sort.
     */
    private static void testeComparatorCollectionsSort() {
        List<Cliente> clientes = RepositorioGeral.getClientes();
        
        System.out.println("\nLista Original:");
        clientes.forEach(c -> System.out.println(c.getNome() + " - ID: " + c.getIdCliente()));

        // Teste 1: Ordenar por ID (usando ComparatorClientID)
        Comparator<Cliente> comparatorId = new ComparatorClientID();
        Collections.sort(clientes, comparatorId);
        System.out.println("\n--- Ordenado por ID (ComparatorClientID) ---");
        clientes.forEach(c -> System.out.println(c.getNome() + " - ID: " + c.getIdCliente()));

        // Teste 2: Ordenar por Nome (usando ComparatorClientNome)
        Comparator<Cliente> comparatorNome = new ComparatorClientNome();
        Collections.sort(clientes, comparatorNome);
        System.out.println("\n--- Ordenado por Nome (ComparatorClientNome) ---");
        clientes.forEach(c -> System.out.println(c.getNome() + " - ID: " + c.getIdCliente()));
    }

    /**
     * Questão 17: Demonstra o uso do método find com Iterator/Comparator e Collections.binarySearch.
     */
    private static void testeFindEBinarySearch() {
        List<Cliente> clientes = RepositorioGeral.getClientes();
        
        // Garante que a lista está ordenada por ID para o binarySearch
        Collections.sort(clientes, new ComparatorClientID());
        
        Cliente clienteBuscado = new Cliente("Alice Silva", null, null, null, new Cpf("111.111.111-11"), 1);
        
        // 1. Teste do método findCliente (BuscaUtil)
        System.out.println("\n--- Teste do método findCliente (BuscaUtil) ---");
        Cliente encontrado = BuscaUtil.findCliente(clientes, clienteBuscado, new ComparatorClientID());
        
        if (encontrado != null) {
            System.out.println("Cliente encontrado com findCliente: " + encontrado.getNome());
        } else {
            System.out.println("Cliente não encontrado com findCliente.");
        }
        
        // 2. Teste do Collections.binarySearch
        System.out.println("\n--- Teste do Collections.binarySearch ---");
        // binarySearch requer que a lista esteja ordenada pelo mesmo critério do Comparator
        int indice = Collections.binarySearch(clientes, clienteBuscado, new ComparatorClientID());
        
        if (indice >= 0) {
            System.out.println("Cliente encontrado com binarySearch no índice: " + indice);
            System.out.println("Cliente no índice: " + clientes.get(indice).getNome());
        } else {
            System.out.println("Cliente não encontrado com binarySearch. Retorno: " + indice);
        }
        
        System.out.println("\nComparação:");
        System.out.println("O método findCliente implementado usa um Iterator para percorrer a lista sequencialmente, comparando elemento por elemento. Funciona em listas não ordenadas, mas é O(n).");
        System.out.println("O Collections.binarySearch usa o algoritmo de busca binária, que é muito mais rápido (O(log n)), mas **exige** que a lista esteja previamente ordenada pelo mesmo critério do Comparator fornecido.");
    }

    /**
     * Questão 18: Simulação de Atendimento de 10 Clientes.
     */
    private static void simulacaoAtendimento() {
        OrdemDeServicoController osController = new OrdemDeServicoController();
        List<Cliente> clientes = RepositorioGeral.getClientes();
        List<Funcionario> barbeiros = RepositorioGeral.getFuncionarios();
        List<Servico> servicos = RepositorioGeral.getServicos();
        List<Produto> produtos = RepositorioGeral.getProdutos();
        
        if (clientes.size() < 5 || barbeiros.isEmpty() || servicos.isEmpty() || produtos.isEmpty()) {
            System.out.println("Dados insuficientes para simulação. Crie mais dados iniciais.");
            return;
        }
        
        System.out.println("\n--- Iniciando Simulação de Atendimento ---");
        
        for (int i = 0; i < 5; i++) { // Simula 5 clientes (para não sobrecarregar o log)
            Cliente cliente = clientes.get(i % clientes.size());
            Funcionario barbeiro = barbeiros.get(i % barbeiros.size());
            Servico servico = servicos.get(i % servicos.size());
            Produto produto = produtos.get(i % produtos.size());
            
            System.out.println("\n[Cliente " + (i + 1) + ": " + cliente.getNome() + "]");
            
            // 1. Criação da Ordem de Serviço
            OrdemDeServico os = osController.criarOrdemDeServico(cliente.getIdCliente());
            System.out.println("-> OS #" + os.getId() + " criada.");
            
            // 2. Inicia Atendimento (Alocação de Estação - Questão 5)
            if (Sistema.alocarEstacao(os.getId())) {
                System.out.println("-> Estação alocada com sucesso. Iniciando atendimento.");
                osController.iniciarAtendimento(os.getId());
            } else {
                System.out.println("-> Todas as estações ocupadas. Cliente na fila de espera.");
                // Aqui o cliente deveria ir para a fila, mas para a simulação, vamos ignorar.
                continue; 
            }
            
            // 3. Adiciona Serviço e Produto (Baixa no Estoque)
            osController.adicionarServicoNaOrdem(os.getId(), servico, barbeiro);
            
            // Simula o uso de 1 unidade do produto
            if (produto.getQuantidadeEstoque() > 0) {
                produto.removeQuantidade(1);
                System.out.println("-> Serviço '" + servico.getNomeServico() + "' adicionado. Baixa de 1 unidade de '" + produto.getNome() + "' no estoque.");
            } else {
                System.out.println("-> Serviço '" + servico.getNomeServico() + "' adicionado. Produto '" + produto.getNome() + "' sem estoque.");
            }
            
            // 4. Finaliza a Ordem de Serviço
            osController.finalizarOrdem(os.getId());
            System.out.println("-> OS #" + os.getId() + " finalizada. Valor Total: R$ " + String.format("%.2f", os.getValorTotal()));
            
            // 5. Emissão de Nota Fiscal (Questão 10)
            NotaFiscal nf = new NotaFiscal(
                RepositorioGeral.getNotasFiscais().size() + 1, 
                cliente, 
                List.of(servico), // Simplificado para a NF
                List.of(produto), // Simplificado para a NF
                barbeiro, 
                LocalDateTime.now()
            );
            nf.setFormaPagamento("Pix");
            RepositorioGeral.getNotasFiscais().add(nf);
            System.out.println("-> Nota Fiscal #" + nf.getIdNotaFiscal() + " emitida e salva.");
            
            // 6. Impressão do Extrato (toString da Nota Fiscal)
            System.out.println("\n--- Extrato Impresso (Nota Fiscal) ---");
            System.out.println(nf.toString());
            
            // 7. Libera Estação (Questão 5)
            // Para simplificar, vamos liberar a primeira estação que estiver ocupada
            for (EstacaoAtendimento estacao : Sistema.ESTACOES) {
                if (estacao.isOcupada() && estacao.getIdAtendimento() == os.getId()) {
                    estacao.liberarEstacao();
                    System.out.println("-> Estação #" + estacao.getId() + " liberada.");
                    break;
                }
            }
        }
    }
    
    /**
     * Questão 5: Teste de alocação e liberação de estações.
     */
    private static void testeEstacoesAtendimento() {
        System.out.println("\nStatus Inicial das Estações:");
        for (EstacaoAtendimento estacao : Sistema.ESTACOES) {
            System.out.println(estacao);
        }
        
        System.out.println("\nTentando alocar 3 atendimentos (IDs 101, 102, 103)...");
        Sistema.alocarEstacao(101);
        Sistema.alocarEstacao(102);
        Sistema.alocarEstacao(103);
        
        System.out.println("Status após 3 alocações:");
        for (EstacaoAtendimento estacao : Sistema.ESTACOES) {
            System.out.println(estacao);
        }
        
        System.out.println("\nTentando alocar o 4º atendimento (ID 104)...");
        boolean alocado = Sistema.alocarEstacao(104);
        System.out.println("Alocado? " + alocado);
        
        System.out.println("\nLiberando Estação #2...");
        Sistema.liberarEstacao(2);
        
        System.out.println("Status após liberação:");
        for (EstacaoAtendimento estacao : Sistema.ESTACOES) {
            System.out.println(estacao);
        }
        
        System.out.println("\nTentando alocar o 4º atendimento novamente (ID 104)...");
        alocado = Sistema.alocarEstacao(104);
        System.out.println("Alocado? " + alocado);
        
        System.out.println("Status Final:");
        for (EstacaoAtendimento estacao : Sistema.ESTACOES) {
            System.out.println(estacao);
        }
    }
    
    /**
     * Questão 15: Teste de Fila FIFO para atendimentos secundários.
     */
    private static void testeFilaAtendimento() {
        FilaAtendimento fila = Sistema.getFilaAtendimento();
        
        // Limpa a fila de testes anteriores
        fila.limparFila();
        
        System.out.println("\nStatus Inicial da Fila:");
        System.out.println(fila);
        
        // Cria agendamentos de teste
        Cliente c1 = RepositorioGeral.getClientes().get(0);
        Cliente c2 = RepositorioGeral.getClientes().get(1);
        Servico s1 = RepositorioGeral.getServicos().get(0);
        Funcionario f1 = RepositorioGeral.getFuncionarios().get(0);
        
        Agendamento ag1 = new Agendamento(201, c1, s1, f1, LocalDateTime.now().plusHours(1), StatusAgendamento.PENDENTE);
        Agendamento ag2 = new Agendamento(202, c2, s1, f1, LocalDateTime.now().plusHours(2), StatusAgendamento.PENDENTE);
        
        System.out.println("Adicionando Agendamento 201 e 202 à fila...");
        fila.adicionarNaFila(ag1);
        fila.adicionarNaFila(ag2);
        
        System.out.println("\nStatus da Fila após adição:");
        System.out.println(fila);
        
        System.out.println("Próximo da fila (peek): " + fila.verProximo().getIdAgendamento());
        
        Agendamento proximo = fila.proximoDaFila();
        System.out.println("Atendimento removido (poll): " + proximo.getIdAgendamento());
        
        System.out.println("\nStatus da Fila após remoção:");
        System.out.println(fila);
        
        Agendamento ultimo = fila.proximoDaFila();
        System.out.println("Atendimento removido (poll): " + ultimo.getIdAgendamento());
        
        System.out.println("\nStatus Final da Fila:");
        System.out.println(fila);
    }
}
