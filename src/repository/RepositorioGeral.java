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
import java.util.Collections;

public class RepositorioGeral {

    private static final String CLIENTES_FILE = "clientes.json";
    private static final String FUNCIONARIOS_FILE = "funcionarios.json";
    private static final String SERVICOS_FILE = "servicos.json";
    private static final String AGENDAMENTOS_FILE = "agendamentos.json";
    private static final String PRODUTOS_FILE = "produtos.json";
    private static final String NOTAS_FISCAIS_FILE = "notasfiscais.json";
    private static final String TRANSACOES_FILE = "transacoes.json";
    private static final String REGISTROS_PONTO_FILE = "registrosPonto.json";

    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Funcionario> funcionarios = new ArrayList<>();
    private static List<Servico> servicos = new ArrayList<>();
    private static List<Agendamento> agendamentos = new ArrayList<>();
    private static List<Produto> produtos = new ArrayList<>();
    private static List<NotaFiscal> notasFiscais = new ArrayList<>();
    private static List<Transacoes> transacoes = new ArrayList<>();
    private static List<RegistroPonto> registrosPonto = new ArrayList<>();

    private static final Gson gson = new GsonBuilder()
            .registerTypeAdapter(LocalDateTime.class, new AdaptadorLocalDateTime())
            .registerTypeAdapter(LocalDate.class, new AdaptadorLocalDate())
            .setPrettyPrinting()
            .create();

    // Getters vão retornar views imutáveis pra não ter mudança externa no json
    public static List<Cliente> getClientes() {
        return Collections.unmodifiableList(clientes);
    }

    public static List<Funcionario> getFuncionarios() {
        return Collections.unmodifiableList(funcionarios);
    }

    public static List<Servico> getServicos() {
        return Collections.unmodifiableList(servicos);
    }

    public static List<Agendamento> getAgendamentos() {
        return Collections.unmodifiableList(agendamentos);
    }

    public static List<Produto> getProdutos() {
        return Collections.unmodifiableList(produtos);
    }

    public static List<NotaFiscal> getNotasFiscais() {
        return Collections.unmodifiableList(notasFiscais);
    }

    public static List<Transacoes> getTransacoes() {
        return Collections.unmodifiableList(transacoes);
    }

    public static List<RegistroPonto> getRegistrosPonto() {
        return Collections.unmodifiableList(registrosPonto);
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
    }

    public static void carregarDados() {
       
        List<Cliente> loadedClientes = carregarLista(CLIENTES_FILE, new TypeToken<List<Cliente>>() {}.getType());
        clientes.clear();
        clientes.addAll(loadedClientes);

        List<Funcionario> loadedFuncionarios = carregarLista(FUNCIONARIOS_FILE, new TypeToken<List<Funcionario>>() {}.getType());
        funcionarios.clear();
        funcionarios.addAll(loadedFuncionarios);

        List<Servico> loadedServicos = carregarLista(SERVICOS_FILE, new TypeToken<List<Servico>>() {}.getType());
        servicos.clear();
        servicos.addAll(loadedServicos);

        List<Agendamento> loadedAgendamentos = carregarLista(AGENDAMENTOS_FILE, new TypeToken<List<Agendamento>>() {}.getType());
        agendamentos.clear();
        agendamentos.addAll(loadedAgendamentos);

        List<Produto> loadedProdutos = carregarLista(PRODUTOS_FILE, new TypeToken<List<Produto>>() {}.getType());
        produtos.clear();
        produtos.addAll(loadedProdutos);

        List<NotaFiscal> loadedNotas = carregarLista(NOTAS_FISCAIS_FILE, new TypeToken<List<NotaFiscal>>() {}.getType());
        notasFiscais.clear();
        notasFiscais.addAll(loadedNotas);

        List<Transacoes> loadedTransacoes = carregarLista(TRANSACOES_FILE, new TypeToken<List<Transacoes>>() {}.getType());
        transacoes.clear();
        transacoes.addAll(loadedTransacoes);

        List<RegistroPonto> loadedRegistros = carregarLista(REGISTROS_PONTO_FILE, new TypeToken<List<RegistroPonto>>() {}.getType());
        registrosPonto.clear();
        registrosPonto.addAll(loadedRegistros);

        if (funcionarios.isEmpty()) {
            System.out.println("Criando funcionário administrador padrão...");
            funcionarios.add(new Funcionario("Admin", "Rua Principal, 1", "(99) 99999-9999", "adm@barbearia.com", new Cpf("000.000.000-00"), "admin", "admin", "Gerente", 5000.00 , 1));
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
