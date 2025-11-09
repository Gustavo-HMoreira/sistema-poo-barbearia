package model;

public class Cpf {
    private String numeroCPF;
    
  
    public Cpf(String numeroCPF){
        this.numeroCPF = numeroCPF;
    }
    
    
    public String getNumeroCpf(){
        return numeroCPF;
    }
 
    public void setNumeroCpf(String numeroCPF){
        this.numeroCPF = numeroCPF;
    }
    
    public static boolean validaCPF(String codigoCpf){
        int soma, resto, primeiroDigito, segundoDigito;       
        codigoCpf = codigoCpf.replaceAll("[^\\d]", ""); 
        
        if (codigoCpf == null || codigoCpf.length() != 11){
            return false;
        }
        
        if (codigoCpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        soma = 0;
        for (int i = 0; i < 9; i++){
            soma = soma + Character.getNumericValue(codigoCpf.charAt(i)) * (10 - i);
        }
        
        resto = 11 - (soma % 11);
        primeiroDigito = (resto >= 10) ? 0 : resto;
        
        if (primeiroDigito != Character.getNumericValue(codigoCpf.charAt(9))) { 
            return false;
        }
        
        soma = 0;
        for(int i = 0; i < 10; i++){
            soma = soma + Character.getNumericValue(codigoCpf.charAt(i)) * (11 - i);    
        }
        
        resto = 11 - (soma % 11);
        segundoDigito = (resto >= 10) ? 0 : resto;
        
        if (segundoDigito != Character.getNumericValue(codigoCpf.charAt(10))) { 
            return false;
        }
        
        return true;
        
    }
          
    @Override
    public String toString(){
        return numeroCPF;
    }
    
}

