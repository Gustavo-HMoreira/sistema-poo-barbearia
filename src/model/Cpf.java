package model;

/**
 * Representa um CPF e fornece um método para validação do código.
 */
public class Cpf {
    private String numeroCPF;
    
/**
* Construtor da classe {@code Cpf}.
* Inicializa o CPF com código especificado.
* 
* @param numeroCPF código do CPF no formato XXX.XXX.XXX-XX
*/    
    public Cpf(String numeroCPF){
        this.numeroCPF = numeroCPF;
    }
    
/**
 * Pega o cpf da pessoa.
 * 
 * @return numeroCPF pessoa.
 */     
    public String getNumeroCpf(){
        return numeroCPF;
    }
    
/**
 * Determina o número de Cpf da pessoa.
 * 
 * @param numeroCPF Telefone novo da pessoa.
 */  
    public void setNumeroCpf(String numeroCPF){
        this.numeroCPF = numeroCPF;
    }
    
 /**
 * Verifica se um código de CPF é válido.
 * Utiliza o cálculo de dígitos verificadores para validar o CPF (calculo usado é padrão).
 * 
 * @param codigoCpf Código do CPF a ser validado.
 * @return true se o cpf for válido e false caso seja inválido
 */
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
    
/**
* Retorna o CPF completo.
* 
* @return CPF completo.
*/       
    @Override
    public String toString(){
        return numeroCPF;
    }
    
}

