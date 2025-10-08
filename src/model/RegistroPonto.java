package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.Duration;


public class RegistroPonto {
    
    private int idFuncionario;   
    private LocalDateTime dataHora;
    private Duration horasTrabalhadas;
    private TipoPonto tipo;
    
    public RegistroPonto(int idFuncionario, LocalDateTime dataHora, Duration horasTrabalhadas ,TipoPonto tipo){
        this.idFuncionario = idFuncionario;
        this.dataHora = dataHora;
        this.horasTrabalhadas = horasTrabalhadas;
        this.tipo = tipo;
    }
    
    
    
    
    
    
    

}