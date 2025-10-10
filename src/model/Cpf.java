package model;


public class Cpf {
    
    private String numeroCpf;
    
    public Cpf(String numeroCpf){
        this.numeroCpf = numeroCpf;
    }
    
    public String getNumeroCpf(){
        return numeroCpf;
    }
    
    public void setNumeroCpf(String numeroCpf){
        this.numeroCpf = numeroCpf;
    }
    
    public static boolean validarCpf(String codigoCpf){
        return true; //futuramente será adicionado método de verificação, assim como em outros lugares.
    }
    
    @Override
    public String toString(){
        return numeroCpf;
    }
    
    
    
}
