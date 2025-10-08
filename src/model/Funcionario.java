package model;


public class Funcionario extends Pessoa{
    
    private int idFuncionario;
    private String usuario;
    private String senha;
    private String cargo;
    private double salario;
        
    public Funcionario(String nome, String endereco, String telefone, String email,String cpf, String usuario, String senha, String cargo, int idFuncionario, double salario){    
        super(nome,cpf, endereco, telefone, email);  
        
        this.idFuncionario = idFuncionario;
        this.usuario = usuario;
        this.senha = senha;
        this.cargo = cargo;
        this.salario = salario;
    }    
    
    public int getIdFuncionario(){
        return idFuncionario;
    }
    
    public void setIdFuncionario(int idFuncionario){
        this.idFuncionario = idFuncionario;
    }
    
    
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    
    public String getCargo(){
        return cargo;
    }
    
    public void setCargo(String cargo){
        this.cargo = cargo;
    }
    
    
    public double getSalario(){
        return salario;
    }
    
    public void setSalario(){
        this.salario = salario;
    }
    
    
}
