package model.comparator;

import model.Agendamento;
import java.util.Comparator;

public class ComparatorAgendID implements Comparator<Agendamento> {
   
    @Override
    public int compare(Agendamento a1, Agendamento a2) {
        return a1.getIdAgendamento() - a2.getIdAgendamento();
    }
    
   
    @Override
    public String toString() {
        return "Comparator que organiza os agendamentos pelo ID";
    }
}