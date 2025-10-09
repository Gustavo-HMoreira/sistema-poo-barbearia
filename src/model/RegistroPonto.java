package model;

import java.time.LocalDateTime;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class RegistroPonto {
    private Funcionario Funcionario;
    private LocalDateTime dataHora;
    private TipoPonto tipo;
    private Duration duracao;

    public RegistroPonto(Funcionario Funcionario, LocalDateTime dataHora, TipoPonto tipo) {
        this.Funcionario = Funcionario;
        this.dataHora = dataHora;
        this.tipo = tipo;
    }

    public Funcionario getIdFuncionario() {
        return Funcionario;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public TipoPonto getTipo() {
        return tipo;
    }

    public Duration getDuracao() {
        return duracao;
    }

    public void calcularDuracao(RegistroPonto registroSaida) {
        if (this.tipo == TipoPonto.ENTRADA && registroSaida.getTipo() == TipoPonto.SAIDA) {
            this.duracao = Duration.between(this.dataHora, registroSaida.getDataHora());
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

        String texto = "Tipo: " + tipo.getDescricao() +
                ", Data/Hora: " + dataHora.format(formatter);

        if (duracao != null) { //calcular a duração que o cara trabalhou
            long horas = duracao.toHours();
            long minutos = duracao.toMinutesPart();
            texto += String.format(" | Duração: %dh %dmin", horas, minutos);
        }

        return texto;
    }
}
