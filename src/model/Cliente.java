
package model;


public class Cliente {
    private String nome;
    private String cpf;
    private String endereco;
    private String telefone;
    private String email;
    private int id; 
   
    public String getNome(){
        return nome;
    }
    
    public void setNome(String nome){
        this.nome = nome;
    }
}
