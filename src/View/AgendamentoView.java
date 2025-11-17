package view;

import model.Agendamento;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

/**
 * Classe responsável por interações com o usuário relacionadas ao agendamento de serviços.
 * Exibe menus, solicita dados e apresenta informações sobre agendamentos.
 */
public class AgendamentoView {
    Scanner leituraDados = new Scanner(System.in);
    
    /**
     * Exibe as opções disponíveis para o usuário e retorna a opção escolhida.
     * 
     * @return Número da opção escolhida. 
     */
    public int mostraOpcoesAgendamento(){
        System.out.println("Digite a opção que deseja executar: ");
        System.out.println("1 - Realizar Agendamento");
        System.out.println("2 - Confirmar Agendamento");
        System.out.println("3 - Cancelar Agendamento");
        System.out.println("4 - Editar Agendamento");
        System.out.println("5 - Mostrar Agendamento");
        System.out.println("6 - Listar Agendamentos");
        System.out.println("7 - Sair");

        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
        
    }
    
    /**
     * Solicita o ID do agendamento ao usuário.
     * 
     * @return ID do agendamento informado. 
     */
    public int getIdAgendamento(){
        System.out.println("Digite o ID do agendamento: ");
        return leituraDados.nextInt();
        }
    
    /** 
     * Solicita o nome do cliente ao usuário.
     * 
     * @return Nome do cliente informado.
     */
    public String getNomeCliente(){
        System.out.println("Digite o nome do cliente: ");
        return leituraDados.nextLine();
    }
    
    /**
     * Solicita o nome do cliente ao usuário para fins de busca.
     * 
     * @return Nome do cliente informado.
     */
    public String getNomeClienteParaBusca(){
        System.out.println("Digite o nome do cliente para busca: ");
        return leituraDados.nextLine();
    }
    
    /**
     *  
     * @return Nome do profissional informado. 
     */
    public String getBarbeiroResponsavel(){
        System.out.println("Digite o nome do barbeiro responsável: ");
        return leituraDados.nextLine();
    }
    
    /**
     * Solicita a data e o horário do agendamento.
     * O formato esperado é: "DD/MM/AAAA HH:MM".
     * 
     * @return String com a dara e hora digitados.
     */
    public String getDataHoraAgendamento(){
        System.out.println("Digite a data e hora do agendamento (dd/MM/yyyy HH:mm): ");
        return leituraDados.nextLine();
    }
    
    /**
     * Exibe e solicita o tipo do agendamento ao usuário.
     * 
     * @return Código do tipo selecionado (1, 2 ou 3).
     */
    public int getTipoServico(){
        System.out.println("Digite a opção do tipo de serviço:");
        System.out.println("1 - Corte de Cabelo");
        System.out.println("2 - Barba");
        System.out.println("3 - Corte e Barba");
        System.out.println("4 - Outro");
        
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }
    
    /**
     * Caso o tipo de agendamento seja "Outro", solicita uma descrição ao usuário, para que ele mesma insira manualmente.
     * 
     * @return Descrição personalizada do tipo de agendamento ou null se não aplicável.
     */
    public String getDescricaoOutro(){
        int opcao = getTipoServico();
        if (opcao == 4) { // Se a opção for 'Outro'
            System.out.println("Você selecionou a opção 'outro', favor escrever a descrição do serviço manualmente: ");
            return leituraDados.nextLine(); 
        }
        return null;
    }
    
    /**
     * Solicita ao usuário o ID do elevador desejado para o serviço.
     * 
     * @return Número do elevador escolhido.
     */

    
    /**
     * Exibe todos os detalhes de um agendamento.
     * 
     * @param agendamento Objeto Agendamento a ser exibido.
     */
    public void mostraAgendamento(Agendamento agendamento){
        System.out.println("ID do agendamento: " + agendamento.getIdAgendamento() + "\n" + 
        "ID do cliente: " + agendamento.getCliente().getIdCliente() + "\n" +
        "Barbeiro responsável: " + agendamento.getBarbeiroResponsavel().getNome() + "\n" +
        "Status agendamento: " + agendamento.getStatusAgendamento().getDescricao() + "\n" +
        "Agendamento marcado para: " + agendamento.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) + "\n" +
        "Tipo do serviço: " + agendamento.getServico().getNomeServico() + "\n" +       
        "Valor do serviço: R$ " + String.format("%.2f", agendamento.getServico().getPreco()) + "\n");
    }
    
    /**
     * Solicita confirmação de cancelamento do agendamento ao usuário.
     * 
     * @return String com a resposta do usuário (S/N).
     */
    /**
     * Solicita confirmação de agendamento ao usuário.
     * 
     * @return String com a resposta do usuário (S/N).
     */
    public String confirmaConfirmacaoAgendamento(){
        System.out.println("Tem certeza que deseja confirmar este agendamento? \n"
        + "Digite [S] para confirmar ou [N] para abortar a operação!! \n");
        return leituraDados.nextLine();
    }

    /**
     * Solicita confirmação de cancelamento do agendamento ao usuário.
     * 
     * @return String com a resposta do usuário sim/não (S/N).
     */
    public String confirmaExclusaoDoAgendamento(){
        System.out.println("Tem certeza que deseja cancelar este agendamento? \n"
        + "Digite [S] para confirmar ou [N] para abortar a operação!! \n");
        return leituraDados.nextLine();
    }

    /**
     * Exibe a lista de todos os agendamentos.
     *
     * @param agendamentos Lista de agendamentos
     */
    public void mostraListaAgendamentos(List<Agendamento> agendamentos) {
        if (agendamentos == null || agendamentos.isEmpty()) {
            System.out.println("Nenhum agendamento registrado.");
            return;
        }

        System.out.println("LISTA DE AGENDAMENTOS");
        for (Agendamento agendamento : agendamentos) {
            System.out.println("ID: " + agendamento.getIdAgendamento() + 
                  " | Cliente: " + agendamento.getCliente().getNome() + 
           " | Barbeiro: " + agendamento.getBarbeiroResponsavel().getNome() +
            " | Data: " + agendamento.getDataHora().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")) +
            " | Serviço: " + agendamento.getServico().getNomeServico() +
            " | Status: " + agendamento.getStatusAgendamento().getDescricao());
        }
        System.out.println("------------------------------------------------------------");
    }                       
    
    /**
     * Exibe opções de edição do agendamento e retorna a escolhida.
     * 
     * @return Número da opção escolhida para a edição. 
     */
    public int editaAgendamento(){
        System.out.println("Digite o campo que você gostaria de editar:");
        System.out.println("1 - Data e Hora");
        System.out.println("2 - Barbeiro responsável");
        System.out.println("3 - Serviço");
      
        int opcao = leituraDados.nextInt();
        leituraDados.nextLine();
        return opcao;
    }
    
    @Override
    public String toString(){
        return "- Interface do Agendamento -";
    }
    
}
