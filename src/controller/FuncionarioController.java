package controller;

import model.Funcionario;
import model.Cpf;
import model.DataStore;
import view.FuncionarioView;

public class FuncionarioController {
    
    private FuncionarioView viewFuncionario = new Funcionarioview();
    
    public void exeMenuFuncionario(){
        
        int opcao = 0;
        
        while(opcao != 6){
            
            opcao = viewFuncionario.mostraOpcoesFuncionario();
        
        
        if(opcao == 6){
            System.out.println("Saindo do menu de funcionários. \n");
            break;
        }
        
        switch(opcao){
            case 1 :{ adicionaFuncionario(); } break;
            case 2 :{ editarFuncionario(); } break;
            case 3 :{ removeFuncionario(); } break;
            case 4 :{ mostrarFuncionario(); } break;
            case 5 : listarfuncionaros(); } break;
            default : System.out.println("Opção inválida! Tente novamente"); 
            }
        }
    }
}

      private void adicionarFuncionario(){
         int idFuncionario = viewFuncionario.getNewFuncionarioId();
         if(DataStore.getfuncionarios().stream().anyMatch(f -> f.getIdfuncionario() == idFuncionario)){
         System.out.println("Funcionário com o respectivo ID já existente! Por favor, escolha outro ID.");
             return;       
        }
        
        String nome = viewFuncionario.getNomeFuncionario();
        String endereco = viewFuncionario.getEnderecoFuncionario();
        String telefone = viewFuncionario.getFoneFuncionario();
        String email = viewFuncionario.getEmailFuncionario();
        String codigoCpf = viewFuncionario.getCpfFuncionario();
        
        if(!Cpf.validarCpf(codigoCpf)){
        System.out.println("CPF inválido!!! Digite o CPF correto. \n");
        return;
       }
       
       Cpf cpf = new Cpf(codigoCpf);
       
       String user = viewFuncionario.getUsuarioFuncionario();
       String senha = viewFucnionario.getSenhaFuncionario();
       String cargo = viewFuncionario.getCargoFuncionario();
       double salario = viewfuncionario.getSalarioFuncionario();

       Funcionario novoFuncionario = new Funcionario(nome, endereco, telefone, email, cpf, usuario, senha, cargo, salario, idFuncionario);
       
       DataStore.getFuncionarios().add(novoFuncionario);
       DataStore.salvarDados();
       System.out.println("Funcionário adicionado! ID: " + idFuncionario);
}
    

    private void editarFuncionario(){

   int id = viewFuncionaro.getIdFuncionario(){
   Optional<Fucnionario> funcionarioOptional = DataStore.getFucnionario().stream().
            filter(f -> f.getIdFuncionario() == id).findFist();

        if(!funcionarioOpitional.isPresent()){
        System.out.println("Funcionário não foi encontrado no banco de dados!");
        return;
        }
    
        Funcionario funcionario = funcionario.Optional.get();
    
        viewFuncionario.mostraFuncionario(funcionario);
        int opcao = viewFuncionario.editaFuncionario();
    
    switch (opcao){
            case 1: funcionario.setEndereco(viewFuncionario.getEnderecoFuncionario()); break;   
            case 2: funcionario.setTelefone(viewFuncionario.getFoneFuncionario()); break; 
            case 3: funcionario.setEmail(viewFuncionario.getEmailFuncionario()); break;
            case 4: funcionario.setSenha(viewFuncionario.getSenhaFuncionario()); break;
            case 5: funcionario.setCargo(viewFuncionario.getCargoFuncionario()); break;
            case 6: funcionario.setSalario(viewFuncionario.getSalarioFuncionario()); break;
            default: {    
                System.out.println("Opção inválida! Nenhuma alteração realizada.");
                return;   
            }
        } 
        Datastore.salvarDados();
        System.out.println("Funcioário editado com sucesso!");
       
       private void removeFuncionario(){
           int id = viewFuncionario.getIdFuncionario();
           Optional<Funcionario> funcionarioOptional = DataStore.getFuncionarios().stream()
                    .filter(f -> f.getIdFuncionario() == id).findFirst();
                                                        
           
           if(!funcionarioOpitional.isPresent()){
               System.out.println("Funcionário não foi encontrado!");
               return;
           }
           
           Funcionario funcionario = funcionarioOptional.get();
           viewFuncionario.mostrarFuncionario(funcionario);
           
           String opcaoConfirmacao = viewFuncionario.confirmaExclusaoFuncionario();
           
           if(!opcaoConfirmacao.equalsIgnoreCase("S")){
               System.out.println("Operacação aberta!");
               return;
           }
           
           if(DataStore.getFuncionario().remove(funcionario)){
               DataStore.salvarDados();
               System.out.println("Funcionário removido com sucesso!");
           }
           else{
               System.out.println("Falha ao remover funcionário! : (");
           }   
       }
       private void motrarFuncionario(){
            int id = viewFucionario.getIdFuncionario();
            Optional<Funcionario> funcionarioOptional = DataStore.getFuncionarios().stream()
                   .filter(f -> f.getIdFuncionario() == id).findFirst();
            if(funcionarioOptional.isPresent()){
                viewFuncionario.mostraFuncionario(funcionarioOptional.get());
            }                                             
            else{
                System.out.println("Funcionário não encontrado!");
            }     
       }
      private void listarFuncionario(){
          viewFuncionario.mostraListaFuncionarios(DataStre.getFuncionarios());
      }
     @Overrive
     public String toString(){
         return String.format("FuncionarioController: %d funcionários registrados.", DataStore.getFuncionarios().size());
     }






























        












