package utilitarios;

import model.Cliente;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/**
 * Classe utilitária para operações de busca utilizando Iterator e Comparator.
 * Questão 17: Implementa método find para clientes.
 */
public class BuscaUtil {
    
    /**
     * Questão 17: Busca um cliente em uma lista usando Iterator e Comparator.
     * Este método percorre a lista usando Iterator e compara cada elemento
     * com o cliente buscado usando o Comparator fornecido.
     * 
     * @param lista Lista de clientes onde a busca será realizada.
     * @param clienteBuscado Cliente que está sendo procurado.
     * @param comparator Comparator para determinar a igualdade.
     * @return O cliente encontrado, ou null se não for encontrado.
     */
    public static Cliente findCliente(List<Cliente> lista, Cliente clienteBuscado, Comparator<Cliente> comparator) {
        if (lista == null || clienteBuscado == null || comparator == null) {
            return null;
        }
        
        Iterator<Cliente> iterator = lista.iterator();
        
        while (iterator.hasNext()) {
            Cliente clienteAtual = iterator.next();
            
            // Se o comparator retorna 0, significa que os elementos são iguais
            if (comparator.compare(clienteAtual, clienteBuscado) == 0) {
                return clienteAtual;
            }
        }
        
        return null; // Cliente não encontrado
    }
    
    /**
     * Busca um cliente por ID usando Iterator.
     * 
     * @param lista Lista de clientes.
     * @param idBuscado ID do cliente procurado.
     * @return O cliente encontrado, ou null se não for encontrado.
     */
    public static Cliente findClientePorId(List<Cliente> lista, int idBuscado) {
        if (lista == null) {
            return null;
        }
        
        Iterator<Cliente> iterator = lista.iterator();
        
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getIdCliente() == idBuscado) {
                return cliente;
            }
        }
        
        return null;
    }
    
    /**
     * Busca um cliente por nome usando Iterator (busca parcial, case-insensitive).
     * 
     * @param lista Lista de clientes.
     * @param nomeBuscado Nome (ou parte do nome) do cliente procurado.
     * @return O primeiro cliente encontrado, ou null se não for encontrado.
     */
    public static Cliente findClientePorNome(List<Cliente> lista, String nomeBuscado) {
        if (lista == null || nomeBuscado == null) {
            return null;
        }
        
        Iterator<Cliente> iterator = lista.iterator();
        
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getNome().toLowerCase().contains(nomeBuscado.toLowerCase())) {
                return cliente;
            }
        }
        
        return null;
    }
}
