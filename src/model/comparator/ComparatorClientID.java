package model.comparator;

import model.Cliente;
import java.util.Comparator;

public class ComparatorClientID implements Comparator<Cliente> {
    
     
    @Override
    public int compare(Cliente c1, Cliente c2) {
        return c1.getIdCliente() - c2.getIdCliente();
    }
    
  
    @Override
    public String toString() {
        return "Comparator que organiza os clientes pelo ID";
    }
}