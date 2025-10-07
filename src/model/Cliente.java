/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Gustavo
 */
public class Cliente extends Pessoa {
    
    private int idcliente;
    
    public Cliente(String nome, String endereco, String telefone, String email, String cpf, int idcliente){
        super(nome, endereco, telefone, email, cpf);
        
        this.idcliente = idcliente;
    }
    
    
    
    public int getIdCliente(){
        return idcliente;
    }
    
    public void setIdCliente(int idcliente){
        this.idcliente = idcliente;
    }
    
    
    
}
