package controller;

import model.Agendamento;
import model.Cliente;
import repository.RepositorioGeral;
import model.Funcionario;
import model.Servico;
import model.StatusAgendamento;
import model.TipoServico;
import view.AgendamentoView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;


public class AgendamentoController {
    
    
    AgendamentoView viewAgendamento = new AgendamentoView();
    
   
    public void executaMenuAgendamento(){
        int opcao = 0;
        
        while(opcao != 7){
            opcao = viewAgendamento.mostraOpcoesAgendamento();
            
            if (opcao == 7) {
                System.out.println("Saindo do menu de agendamentos!");
                break; 
            }
            
            switch (opcao){
                case 1: {
                    adicionaAgendamento();
                }
                break;
                case 2: {
                    confirmaAgendamento();
                }
                break;
                case 3: {
                    cancelaAgendamento();
                }
                break;
                case 4: {
                    editaAgendamento();
                }
                break;
                case 5: {
                    mostrarAgendamento();
                }
                break;
                case 6: {
                    listarAgendamentos();
                }
                break;
                
                default: {
                    System.out.println("Opção inválida! Tente novamente.");
                }
            }
        }
    }

    private void adicionaAgendamento() {
        int idAgendamento = gerarProximoIdAgendamento();
        String nomeCliente = viewAgendamento.getNomeClienteParaBusca();
        Optional<Cliente> clienteOptional = RepositorioGeral.getClientes().stream().filter(c -> c.getNome().equalsIgnoreCase(nomeCliente)).findFirst();
                                            
                                                                                                           
        if (!clienteOptional.isPresent()) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        Cliente cliente = clienteOptional.get();

        String nomeBarbeiro = viewAgendamento.getBarbeiroResponsavel();
        Optional<Funcionario> barbeiroOptional = RepositorioGeral.getFuncionarios().stream()
                                                 .filter(f -> f.getNome().equalsIgnoreCase(nomeBarbeiro)).findFirst();       
                                                        
        if (!barbeiroOptional.isPresent()) {
            System.out.println("Barbeiro não encontrado!");
            return;
        }
        
        Funcionario barbeiro = barbeiroOptional.get();

        String dataHoraStr = viewAgendamento.getDataHoraAgendamento();
        LocalDateTime dataHora = LocalDateTime.parse(dataHoraStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

        int tipoServicoOpcao = viewAgendamento.getTipoServico();
        TipoServico tipoServico = TipoServico.converteCodigo(tipoServicoOpcao);
        if (tipoServico == null) {
            System.out.println("Tipo de serviço inválido!");
            return;
        }
        String descricaoServico = viewAgendamento.getDescricaoOutro();
        Servico servico = new Servico(gerarProximoIdServico(), tipoServico.getDescricao(), descricaoServico != null ? descricaoServico : tipoServico.getDescricao(), tipoServico.getPreco(), tipoServico);

        Agendamento novoAgendamento = new Agendamento(idAgendamento, cliente, servico, barbeiro, dataHora, StatusAgendamento.PENDENTE);
        RepositorioGeral.getAgendamentos().add(novoAgendamento);
        RepositorioGeral.salvarDados();
        System.out.println("Agendamento adicionado com sucesso!");
    }

    private void confirmaAgendamento() {
        int id = viewAgendamento.getIdAgendamento();
        Optional<Agendamento> agendamentoOptional = RepositorioGeral.getAgendamentos().stream().filter(a -> a.getIdAgendamento() == id).findFirst();
                                                    
                                                            
        if (!agendamentoOptional.isPresent()) {
            System.out.println("Agendamento não encontrado!");
            return;
        }
        
        Agendamento agendamento = agendamentoOptional.get();
        viewAgendamento.mostraAgendamento(agendamento);
        String confirmacao = viewAgendamento.confirmaConfirmacaoAgendamento();
        
        if (confirmacao.equalsIgnoreCase("S")) {
            agendamento.setStatusAgendamento(StatusAgendamento.CONFIRMADO);
            RepositorioGeral.salvarDados();
            System.out.println("Agendamento confirmado com sucesso!");
        } else {
            System.out.println("Operação cancelada!");
        }
    }

    private void cancelaAgendamento() {
        int id = viewAgendamento.getIdAgendamento();
        Optional<Agendamento> agendamentoOptional = RepositorioGeral.getAgendamentos().stream().filter(a -> a.getIdAgendamento() == id).findFirst();
                                                                                                                       
        if (!agendamentoOptional.isPresent()) {
            System.out.println("Agendamento não encontrado!");
            return;
        }
        Agendamento agendamento = agendamentoOptional.get();
        viewAgendamento.mostraAgendamento(agendamento);
        String confirmacao = viewAgendamento.confirmaExclusaoDoAgendamento();
        
        if (confirmacao.equalsIgnoreCase("S")) {
            agendamento.setStatusAgendamento(StatusAgendamento.CANCELADO);
            RepositorioGeral.salvarDados();
            System.out.println("Agendamento cancelado com sucesso!");
        } else {
            System.out.println("Operação cancelada!");
        }
    }

    private void editaAgendamento() {
        int id = viewAgendamento.getIdAgendamento();
        Optional<Agendamento> agendamentoOptional = RepositorioGeral.getAgendamentos().stream().filter(a -> a.getIdAgendamento() == id).findFirst();
                                                                                                                       

        if (!agendamentoOptional.isPresent()) {
            System.out.println("Agendamento não encontrado!");
            return;
        }

        Agendamento agendamento = agendamentoOptional.get();
        viewAgendamento.mostraAgendamento(agendamento);
        int opcao = viewAgendamento.editaAgendamento();

        switch (opcao) {
            case 1: {
                String novaDataHoraStr = viewAgendamento.getDataHoraAgendamento();
                agendamento.setDataHora(LocalDateTime.parse(novaDataHoraStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
            }break;
           
            case 2: {
                String novoNomeBarbeiro = viewAgendamento.getBarbeiroResponsavel();
                Optional<Funcionario> novoBarbeiroOptional = RepositorioGeral.getFuncionarios().stream()
                                                             .filter(f -> f.getNome().equalsIgnoreCase(novoNomeBarbeiro)).findFirst();       
                                                                    
                if (novoBarbeiroOptional.isPresent()) {
                    agendamento.setBarbeiroResponsavel(novoBarbeiroOptional.get());
                } else {
                    System.out.println("Barbeiro não encontrado!");
                    return;
                }
            }break;
                
            case 3: {
                int novoTipoServicoOpcao = viewAgendamento.getTipoServico();
                TipoServico novoTipoServico = TipoServico.converteCodigo(novoTipoServicoOpcao);
                
                if (novoTipoServico != null) {
                    String novaDescricaoServico = viewAgendamento.getDescricaoOutro();
                    agendamento.setServico(new Servico(gerarProximoIdServico(), novoTipoServico.getDescricao(), novaDescricaoServico != null ? novaDescricaoServico : novoTipoServico.getDescricao(), novoTipoServico.getPreco(), novoTipoServico));
                } else {
                    System.out.println("Tipo de serviço inválido!");
                    return;
                }
            }break;
                
            default: {
                System.out.println("Opção inválida! Nenhuma alteração realizada.");
                return;
            }
        }
        RepositorioGeral.salvarDados();
        System.out.println("Agendamento editado com sucesso!");
    }

    private void mostrarAgendamento() {
        int id = viewAgendamento.getIdAgendamento();
        Optional<Agendamento> agendamentoOptional = RepositorioGeral.getAgendamentos().stream()
                                                  .filter(a -> a.getIdAgendamento() == id).findFirst();        
                                                            
        if (agendamentoOptional.isPresent()) {
            viewAgendamento.mostraAgendamento(agendamentoOptional.get());
        } else {
            System.out.println("Agendamento não encontrado!");
        }
    }

    private void listarAgendamentos() {
        List<Agendamento> agendamentos = RepositorioGeral.getAgendamentos();
        viewAgendamento.mostraListaAgendamentos(agendamentos);
    }
    
    private int gerarProximoIdAgendamento() {
        return RepositorioGeral.getAgendamentos().stream().mapToInt(Agendamento::getIdAgendamento).max().orElse(0) + 1;
                          
    }

    private int gerarProximoIdServico() {
        return RepositorioGeral.getServicos().stream().mapToInt(Servico::getIdServico).max().orElse(0) + 1;
                             
    }

    @Override 
    public String toString(){
        return String.format("AgendamentoController: %d agendamentos registrados.", RepositorioGeral.getAgendamentos().size());
    }
}

