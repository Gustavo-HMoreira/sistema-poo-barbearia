package controller;

import model.Funcionario;
import repository.RepositorioGeral;
import view.LoginView;


public class LoginController {
    private LoginView loginView = new LoginView();
    private Funcionario usuarioLogado = null;
    
  
    public boolean realizarLogin() {
        loginView.exibeTelaBemVindo();
        
        String usuario = loginView.getUsuario();
        String senha = loginView.getSenha();
        
        usuarioLogado = autenticarUsuario(usuario, senha);
        
        if (usuarioLogado != null) {
            loginView.exibeSucessoLogin(usuarioLogado);
            return true;
        } else {
            loginView.exibeErroLogin();
            return false;
        }
    }
   
    private Funcionario autenticarUsuario(String usuario, String senha) {
        if (usuario == null || senha == null || usuario.isEmpty() || senha.isEmpty()) {
            return null;
        }
        
        for (Funcionario funcionario : RepositorioGeral.getFuncionarios()) {
            if (funcionario.getUsuario().equals(usuario) && funcionario.getSenha().equals(senha)) {
                
                return funcionario;
            }
        }
        return null;
    }
    
   
    public boolean isGerente() {
        return usuarioLogado != null && usuarioLogado.getCargo().toUpperCase().contains("GERENTE");           
    }
     
    public boolean podeAcessarAreaFinanceira() {
        if (!isGerente()) {
            loginView.exibeAcessoNegado();
            return false;
        }
        return true;
    }
    
    public boolean podeCadastrarFuncionario() {
        if (!isGerente()) {
            loginView.exibeAcessoNegado();
            return false;
        }
        return true;
    }
    
    public Funcionario getUsuarioLogado() {
        return usuarioLogado;
    }
    
    @Override 
    public String toString(){
        return "LoginController: usuário está logado? " + usuarioLogado;
    }
}

