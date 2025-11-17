package controller;

import repository.RepositorioGeral;
import model.Funcionario;
import model.RegistroPonto;
import model.TipoPonto;
import view.PontoView;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PontoController {
    private PontoView pontoView = new PontoView();

    public void executaMenuPonto() {
        int opcao = 0;
        while (opcao != 5) {
            opcao = pontoView.mostraOpcoesPonto();

            switch (opcao) {
                case 1:
                    registrarPonto(TipoPonto.ENTRADA);
                    break;
                case 2:
                    registrarPonto(TipoPonto.SAIDA);
                    break;
                case 3:
                    consultarRegistrosPorFuncionario();
                    break;
                case 4:
                    consultarTodosRegistros();
                    break;
                case 5:
                    pontoView.exibirMensagem("Saindo do sistema de ponto...");
                    break;
                default:
                    pontoView.exibirMensagem("Opção inválida! Tente novamente.");
            }
        }
    }

    private void registrarPonto(TipoPonto tipo) {
        int idFuncionario = pontoView.getIdFuncionarioParaRegistro();
        Optional<Funcionario> funcionarioOptional = RepositorioGeral.getFuncionarios().stream()
                .filter(f -> f.getIdFuncionario() == idFuncionario).findFirst();
                

        if (funcionarioOptional.isPresent()) {
            RegistroPonto novoRegistro = new RegistroPonto(idFuncionario, LocalDateTime.now(), tipo);
            RepositorioGeral.getRegistrosPonto().add(novoRegistro);
            RepositorioGeral.salvarDados();
            pontoView.exibirMensagem("Ponto de " + tipo.getDescricao() + " registrado com sucesso para o funcionário ID: " + idFuncionario);
        } else {
            pontoView.exibirMensagem("Funcionário com ID " + idFuncionario + " não encontrado.");
        }
    }

    private void consultarRegistrosPorFuncionario() {
        int idFuncionario = pontoView.getIdFuncionarioParaConsulta();
        List<RegistroPonto> registrosFiltrados;

        if (idFuncionario == 0) { // 0 para todos os funcionários
            registrosFiltrados = RepositorioGeral.getRegistrosPonto();
        } else {
            registrosFiltrados = RepositorioGeral.getRegistrosPonto().stream()
                .filter(r -> r.getIdFuncionario() == idFuncionario).collect(Collectors.toList());
                    
        }
        pontoView.mostraRegistrosPonto(registrosFiltrados);
    }

    private void consultarTodosRegistros() {
        pontoView.mostraRegistrosPonto(RepositorioGeral.getRegistrosPonto());
    }
}

