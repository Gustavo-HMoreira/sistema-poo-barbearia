package model;


public class Cliente extends Pessoa {
    
    private int idCliente;
    
    public Cliente(String nome, String endereco, String telefone, String email, Cpf cpf, int idCliente) {
        super(nome, endereco, telefone, email, cpf);
        
        this.idCliente = idCliente;
    }
    
    public int getIdCliente(){
        return idCliente;
    }
    
    public void setIdCliente(int idcliente){
        this.idCliente = idcliente;
    }
    
    @Override
    public String toString() {
        return this.getNome() + ": " + idCliente;
    }
    
}
