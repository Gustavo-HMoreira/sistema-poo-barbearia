package model;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class RegistroPonto {
    
    private int idRegistro;
    private int idFuncionario;
    private LocalDateTime dataHoraEntrada;
    private LocalDateTime dataHoraSaida;
    private double horasTrabalhadas;
    
    
    public Ponto(int idRegistro, int idFuncionario){
        this.idRegistro = idRegistro;
        this.idFuncionario = idFuncionario; 
        this.dataHoraEntrada = null;
        this.dataHoraSaida = null;
        this.horasTrabalhadas = 0.0;
    }

    public Ponto(int idRegistro, int idFuncionario, LocalDateTime dataHoraEntrada, LocalDateTie dataHoraSaida, double horasTrabalhadas){
        this.idRegistro = idRegistro;
        this.idFuncionario = idFuncionario; 
        this.dataHoraEntrada = dataHoraEntrada;
        this.dataHoraSaida = dataHoraSaida;
        this.horasTrabalhadas = horasTrabalhadas;
    }
    
    
    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }
    public int getIdRegistro() {
        return idRegistro;
    }
    
    
    public int getIdFuncionario() {
        return idFuncionario;
    }
    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    
    public void setDataHoraEntrada(LocalDateTime dataHoraEntrada) {
        this.dataHoraEntrada = dataHoraEntrada;
    }

    public void setDataHoraSaida(LocalDateTime dataHoraSaida) {
        this.dataHoraSaida = dataHoraSaida;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    

    

    public LocalDateTime getDataHoraEntrada() {
        return dataHoraEntrada;
    }

    public LocalDateTime getDataHoraSaida() {
        return dataHoraSaida;
    }

    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }
    
    
    
    
    
}
