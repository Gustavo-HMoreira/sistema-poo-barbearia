package model;


public class Funcionario extends Pessoa{
    
    private int idFuncionario;
    private String usuario;
    private String senha;
    private String cargo;
    private double salario;
        
    public Funcionario(String nome, String endereco, String telefone, String email,
            String cpf, String usuario, String senha, String cargo, int idFuncionario, double salario){    
        super(nome, endereco, telefone, email, cpf);
        this.idFuncionario = idFuncionario;
        this.usuario = usuario;
        this.senha = senha;
        this.cargo = cargo;
        this.salario = salario;
    }    
   
    
    
    
    
    
    
    
    
    
    
    
}
