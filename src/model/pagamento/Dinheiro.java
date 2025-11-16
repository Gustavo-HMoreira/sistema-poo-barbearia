package model.pagamento;

public class Dinheiro implements FormaDePagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado em Dinheiro.");
    }

    @Override
    public String getDescricao() {
        return "Dinheiro";
    }
    
    /**
     * Retorna uma representação em String da forma de pagamento.
     * 
     * @return String "Dinheiro".
     */
    @Override
    public String toString() {
        return "Dinheiro";
    }
}
