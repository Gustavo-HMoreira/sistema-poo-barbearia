package repository;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;


import model.*;
import utilitarios.AdaptadorLocalDate;
import utilitarios.AdaptadorLocalDateTime;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsável por gerenciar o repositório de dados de todas as entidades do sistema.
 * Utiliza o padrão Singleton (implícito por métodos e atributos estáticos) para manter
 * uma única fonte de verdade para todas as listas de objetos.
 * Realiza a persistência dos dados em arquivos JSON utilizando a biblioteca Gson.
 */

public class RepositorioGeral {

    private static final String CLIENTES_FILE = "clientes.json";
    private static final String FUNCIONARIOS_FILE = "funcionarios.json";
    private static final String SERVICOS_FILE = "servicos.json";
    private static final String AGENDAMENTOS_FILE = "agendamentos.json";
    private static final String PRODUTOS_FILE = "produtos.json";
    private static final String NOTAS_FISCAIS_FILE = "notasfiscais.json";
    private static final String TRANSACOES_FILE = "transacoes.json";
    private static final String REGISTROS_PONTO_FILE = "registrosPonto.json";
    private static final String ORDENS_SERVICO_FILE = "ordensservico.json";

    /**
     * Lista estática para armazenar todas as Ordens de Serviço.
     */
    
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Servico> servicos = new ArrayList<>();
    private static List<Agendamento> agendamentos = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static List<NotaFiscal> notasFiscais = new ArrayList<>();
    private static List<Transacoes> transacoes = new ArrayList<>();
    private static List<RegistroPonto> registrosPonto = new ArrayList<>();
    private static List<OrdemDeServico> ordensDeServico = new ArrayList<>();

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new AdaptadorLocalDateTime())
            .registerTypeAdapter(LocalDate.class, new AdaptadorLocalDate()).setPrettyPrinting().create();
                       

    public static List<Cliente> getClientes() {
        return clientes;
    }

    public static List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public static List<Servico> getServicos() {
        return servicos;
    }

    public static List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public static List<Produto> getProdutos() {
        return produtos;
    }

    public static List<NotaFiscal> getNotasFiscais() {
        return notasFiscais;
    }

    public static List<Transacoes> getTransacoes() {
        return transacoes;
    }

    public static List<RegistroPonto> getRegistrosPonto() {
        return registrosPonto;
    }
    
    public static List<OrdemDeServico> getOrdensDeServico() {
        return ordensDeServico;
    }

    public static void salvarDados() {
        
        salvarLista(clientes, CLIENTES_FILE, new TypeToken<List<Cliente>>() {}.getType());
        salvarLista(funcionarios, FUNCIONARIOS_FILE, new TypeToken<List<Funcionario>>() {}.getType());
        salvarLista(servicos, SERVICOS_FILE, new TypeToken<List<Servico>>() {}.getType());
        salvarLista(agendamentos, AGENDAMENTOS_FILE, new TypeToken<List<Agendamento>>() {}.getType());
        salvarLista(produtos, PRODUTOS_FILE, new TypeToken<List<Produto>>() {}.getType());
        salvarLista(notasFiscais, NOTAS_FISCAIS_FILE, new TypeToken<List<NotaFiscal>>() {}.getType());
        salvarLista(transacoes, TRANSACOES_FILE, new TypeToken<List<Transacoes>>() {}.getType());
        salvarLista(registrosPonto, REGISTROS_PONTO_FILE, new TypeToken<List<RegistroPonto>>() {}.getType());
        salvarLista(ordensDeServico, ORDENS_SERVICO_FILE, new TypeToken<List<OrdemDeServico>>() {}.getType());
    }

    public static void carregarDados() {
        clientes = carregarLista(CLIENTES_FILE, new TypeToken<List<Cliente>>() {}.getType());
        funcionarios = carregarLista(FUNCIONARIOS_FILE, new TypeToken<List<Funcionario>>() {}.getType());
        servicos = carregarLista(SERVICOS_FILE, new TypeToken<List<Servico>>() {}.getType());
        agendamentos = carregarLista(AGENDAMENTOS_FILE, new TypeToken<List<Agendamento>>() {}.getType());
        produtos = carregarLista(PRODUTOS_FILE, new TypeToken<List<Produto>>() {}.getType());
        notasFiscais = carregarLista(NOTAS_FISCAIS_FILE, new TypeToken<List<NotaFiscal>>() {}.getType());
        transacoes = carregarLista(TRANSACOES_FILE, new TypeToken<List<Transacoes>>() {}.getType());
        registrosPonto = carregarLista(REGISTROS_PONTO_FILE, new TypeToken<List<RegistroPonto>>() {}.getType());
        ordensDeServico = carregarLista(ORDENS_SERVICO_FILE, new TypeToken<List<OrdemDeServico>>() {}.getType());

        if (funcionarios.isEmpty()) {
            
            System.out.println("Criando funcionário administrador padrão...");
            funcionarios.add(new Funcionario("Admin", "Rua Principal, 1", "(99) 99999-9999", "admin@barbearia.com", new Cpf("000.000.000-00"), "admin", "admin", "Gerente", 5000.00, 1));
            salvarLista(funcionarios, FUNCIONARIOS_FILE, new TypeToken<List<Funcionario>>() {}.getType());
        }
    }

    private static <T> void salvarLista(List<T> lista, String caminhoDoJson, Type tipoDaLista) {
        try (FileWriter writer = new FileWriter(caminhoDoJson)) {
            gson.toJson(lista, tipoDaLista, writer);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados em " + caminhoDoJson + ": " + e.getMessage());
        }
    }

    private static <T> List<T> carregarLista(String caminhoDoJson, Type tipoDaLista) {
        
        try (FileReader reader = new FileReader(caminhoDoJson)) {
            List<T> dados = gson.fromJson(reader, tipoDaLista);
            return (dados != null) ? dados : new ArrayList<>();
        } catch (IOException e) {
            System.out.println("Arquivo " + caminhoDoJson + " não encontrado ou erro ao carregar: " + e.getMessage());
            return new ArrayList<>();
        } catch (Exception e) {
            System.out.println("Erro ao carregar dados de " + caminhoDoJson + ": " + e.getMessage());
            return new ArrayList<>();
        }
    }
}

