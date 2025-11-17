package controller;

import model.Servico;
import repository.RepositorioGeral;
import model.TipoServico;
import view.ServicoView;

import java.util.List;
import java.util.Optional;

public class ServicoController {
    private ServicoView viewServico = new ServicoView();

    public void executaMenuServico() {
        int opcao = 0;

        while (opcao != 6) {
            opcao = viewServico.mostraOpcoesServico();

            if (opcao == 6) {
                System.out.println("Saindo do menu de serviços...");
                break;
            }

            switch (opcao) {
                case 1: {
                    adicionaServico();
                }
                break;
                case 2: {
                    editaServico();
                }
                break;
                case 3: {
                    removeServico();
                }
                break;
                case 4: {
                    mostrarServico();
                }
                break;
                case 5: {
                    listarServicos();
                }
                break;
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }

    private void adicionaServico() {
        int idServico = gerarProximoIdServico();
        String nome = viewServico.getNomeServico();
        String descricao = viewServico.getDescricaoServico();
        double preco = viewServico.getPrecoServico();
        TipoServico tipo = viewServico.getTipoServico();

        Servico novoServico = new Servico(idServico, nome, descricao, preco, tipo);
        RepositorioGeral.getServicos().add(novoServico);
        
        
        Sistema.incrementarQuantidadeServicos(); //1 = private com getter/setter
        Sistema.incrementarQuantidadeServicosProtegido(); //2 = protected
        
        RepositorioGeral.salvarDados();
        System.out.println("Serviço adicionado com sucesso!");
    }

    private void editaServico() {
        int id = viewServico.getIdServico();
        Optional<Servico> servicoOptional = RepositorioGeral.getServicos().stream()
                                      .filter(s -> s.getIdServico() == id).findFirst();                                                    

        if (!servicoOptional.isPresent()) {
            System.out.println("Serviço não encontrado!");
            return;
        }

        Servico servico = servicoOptional.get();
        viewServico.mostraServico(servico);
        int opcao = viewServico.editaServico();

        switch (opcao) {
            case 1: servico.setNomeServico(viewServico.getNomeServico());
                break;
            case 2: servico.setDescricao(viewServico.getDescricaoServico());
                break;
            case 3: servico.setPreco(viewServico.getPrecoServico());
                break;
            case 4: servico.setTipoServico(viewServico.getTipoServico());
                break;
            default: {
                System.out.println("Opção inválida! Nenhuma alteração realizada.");
                return;
            }
        }
        RepositorioGeral.salvarDados();
        System.out.println("Serviço editado com sucesso!");
    }

    private void removeServico() {
        int id = viewServico.getIdServico();
        Optional<Servico> servicoOptional = RepositorioGeral.getServicos().stream()
                                        .filter(s -> s.getIdServico() == id).findFirst();
                                                    
        if (!servicoOptional.isPresent()) {
            System.out.println("Serviço não encontrado!");
            return;
        }

        Servico servico = servicoOptional.get();
        viewServico.mostraServico(servico);
        String confirmacao = viewServico.confirmaExclusaoServico();

        if (!confirmacao.equalsIgnoreCase("S")) {
            System.out.println("Operação abortada!!");
            return;
        }

        if (RepositorioGeral.getServicos().remove(servico)) {
            RepositorioGeral.salvarDados();
            System.out.println("Serviço removido com sucesso!");
        } else {
            System.out.println("Falha ao remover serviço! :(");
        }
    }

    private void mostrarServico() {
        int id = viewServico.getIdServico();
        Optional<Servico> servicoOptional = RepositorioGeral.getServicos().stream()
                                        .filter(s -> s.getIdServico() == id).findFirst();
                                                    
        if (servicoOptional.isPresent()) {
            viewServico.mostraServico(servicoOptional.get());
        } else {
            System.out.println("Serviço não encontrado!");
        }
    }

    private void listarServicos() {
        List<Servico> servicos = RepositorioGeral.getServicos();
        viewServico.mostraListaServicos(servicos);
    }

    private int gerarProximoIdServico() {
        return RepositorioGeral.getServicos().stream()
                .mapToInt(Servico::getIdServico).max().orElse(0) + 1;
            
    }

    @Override
    public String toString() {
        return String.format("ServicoController: %d serviços registrados.", RepositorioGeral.getServicos().size());
    }
}

