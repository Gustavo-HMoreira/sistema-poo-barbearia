package controller;

import model.Funcionario;
import model.Cpf;
import repository.RepositorioGeral;
import view.FuncionarioView;
import java.util.List;
import java.util.Optional;


public class FuncionarioController {
    private FuncionarioView viewFuncionario = new FuncionarioView();

    
    public void executaMenuFuncionario(){
        int opcao = 0;

        while(opcao != 6){
            opcao = viewFuncionario.mostraOpcoesFuncionario();

            if (opcao == 6) {
                System.out.println("Saindo do menu de funcionários...");
                break;
            }

            switch (opcao){
                case 1: {
                    adicionaFuncionario();
                }
                break;
                case 2: {
                    editarFuncionario();
                }
                break;
                case 3: {
                    removeFuncionario();
                }
                break;
                case 4: {
                    mostrarFuncionario();
                }
                break;
                case 5: {
                    listarFuncionarios();
                }
                break;

                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }

    private void adicionaFuncionario() {
        int idFuncionario = viewFuncionario.getNewFuncionarioId(); 
        
        if (RepositorioGeral.getFuncionarios().stream().anyMatch(f -> f.getIdFuncionario() == idFuncionario)) {
            System.out.println("Erro: Já existe um funcionário com este ID. Por favor, escolha outro ID.");
            return;
        }

        String nome = viewFuncionario.getNomeFuncionario();
        String endereco = viewFuncionario.getEnderecoFuncionario();
        String telefone = viewFuncionario.getFoneFuncionario();
        String email = viewFuncionario.getEmailFuncionario();
        String codigoCpf = viewFuncionario.getCpfFuncionario();
        
        if (!Cpf.validaCPF(codigoCpf)) {
            System.out.println("CPF inválido!!");
            return;
        }
        Cpf cpf = new Cpf(codigoCpf);

        String usuario = viewFuncionario.getUsuarioFuncionario();
        String senha = viewFuncionario.getSenhaFuncionario();
        String cargo = viewFuncionario.getCargoFuncionario();
        double salario = viewFuncionario.getSalarioFuncionario();

        Funcionario novoFuncionario = new Funcionario(nome, endereco, telefone, email, cpf, usuario, senha, cargo, salario, idFuncionario);

        RepositorioGeral.getFuncionarios().add(novoFuncionario);
        RepositorioGeral.salvarDados();
        System.out.println("Funcionário adicionado com sucesso! ID: " + idFuncionario);
    }

    private void editarFuncionario() {
        String nome = viewFuncionario.getNomeFuncionarioParaBusca();
        Optional<Funcionario> funcionarioOptional = RepositorioGeral.getFuncionarios().stream()
                                                    .filter(f -> f.getNome().equalsIgnoreCase(nome)).findFirst();
                                                        

        if (!funcionarioOptional.isPresent()) {
            System.out.println("Funcionário não encontrado!");
            return;
        }

        Funcionario funcionario = funcionarioOptional.get();

        viewFuncionario.mostraFuncionario(funcionario);
        int opcao = viewFuncionario.editaFuncionario();

        
        
        switch (opcao){
            case 1:
                funcionario.setEndereco(viewFuncionario.getEnderecoFuncionario());
                break;
            case 2:
                funcionario.setTelefone(viewFuncionario.getFoneFuncionario());
                break;
            case 3:
                funcionario.setEmail(viewFuncionario.getEmailFuncionario());
                break;
            case 4:
                funcionario.setSenha(viewFuncionario.getSenhaFuncionario());
                break;
            case 5:
                funcionario.setCargo(viewFuncionario.getCargoFuncionario());
                break;
            case 6:
                funcionario.setSalario(viewFuncionario.getSalarioFuncionario());
                break;
            default: {
                System.out.println("Opção inválida! Nenhuma alteração realizada.");
                return;
            }
        }
        
        RepositorioGeral.salvarDados();
        System.out.println("Funcionário editado com sucesso!");
    }

    private void removeFuncionario() {
        String nome = viewFuncionario.getNomeFuncionarioParaBusca();
        Optional<Funcionario> funcionarioOptional = RepositorioGeral.getFuncionarios().stream()
                                                    .filter(f -> f.getNome().equalsIgnoreCase(nome)).findFirst();
                                                        

        if (!funcionarioOptional.isPresent()){
            System.out.println("Funcionário não encontrado!");
            return;
        }

        Funcionario funcionario = funcionarioOptional.get();
        viewFuncionario.mostraFuncionario(funcionario);

        String opcaoConfirmacao = viewFuncionario.confirmaExclusaoFuncionario();
        if (!opcaoConfirmacao.equalsIgnoreCase("S")) {
            System.out.println("Operação abortada!!");
            return;
        }

        if (RepositorioGeral.getFuncionarios().remove(funcionario)) {
            RepositorioGeral.salvarDados();
            System.out.println("Funcionário removido com sucesso!");
        }
        else {
            System.out.println("Falha ao remover funcionário! :(");
        }
    }

    private void mostrarFuncionario() {
        String nome = viewFuncionario.getNomeFuncionarioParaBusca();
        Optional<Funcionario> funcionarioOptional = RepositorioGeral.getFuncionarios().stream()
                                                    .filter(f -> f.getNome().equalsIgnoreCase(nome)).findFirst();
                                                        
        if (funcionarioOptional.isPresent()) {
            viewFuncionario.mostraFuncionario(funcionarioOptional.get());
        } else {
            System.out.println("Funcionário não encontrado!");
        }
    }

    private void listarFuncionarios() {
        viewFuncionario.mostraListaFuncionarios(RepositorioGeral.getFuncionarios());
    }

  

    @Override
    public String toString(){
        return String.format("FuncionarioController: %d funcionários registrados.", RepositorioGeral.getFuncionarios().size());
    }
}
