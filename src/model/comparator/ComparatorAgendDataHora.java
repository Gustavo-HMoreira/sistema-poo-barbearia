package model.comparator;

import model.Agendamento;
import java.util.Comparator;
import java.time.LocalDateTime;

public class ComparatorAgendDataHora implements Comparator<Agendamento> {
    
    @Override
    public int compare(Agendamento a1, Agendamento a2) {
        LocalDateTime a1DataHora = a1.getDataHora();
        LocalDateTime a2DataHora = a2.getDataHora();
        
        return a1DataHora.compareTo(a2DataHora);
    }
    

    @Override
    public String toString() {
        return "Comparator que organiza os agendamentos pela data/hora";
    }
}

