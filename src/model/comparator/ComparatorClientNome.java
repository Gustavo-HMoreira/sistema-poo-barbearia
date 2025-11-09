package model.comparator;

import model.Cliente;
import java.util.Comparator;

public class ComparatorClientNome implements Comparator<Cliente> {

    @Override
    public int compare(Cliente c1, Cliente c2) {
        return c1.getNome().compareToIgnoreCase(c2.getNome());
    }

    @Override
    public String toString() {
        return "Comparator que organiza os clientes pelo nome de forma alfabética";
    }
}