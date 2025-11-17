package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

    /**
     * 
     * Registro de ponto completo do funcionário, com controle de horas!
     *
     */

public class RegistroPonto {
    private int idFuncionario;
    private LocalDateTime dataHora;
    private TipoPonto tipo;

    public RegistroPonto(int idFuncionario, LocalDateTime dataHora, TipoPonto tipo) {
        this.idFuncionario = idFuncionario;
        this.dataHora = dataHora;
        this.tipo = tipo;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public TipoPonto getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        return "Funcionário ID: " + idFuncionario + ", Tipo: " + tipo.getDescricao() + ", Data/Hora: " + dataHora.format(formatter);
    }
}

