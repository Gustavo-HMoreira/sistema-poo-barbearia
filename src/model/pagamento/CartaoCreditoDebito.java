package model.pagamento;

public class CartaoCreditoDebito implements FormaDePagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado via Cartão.");
    }

    @Override
    public String getDescricao() {
        return "Cartão de Crédito / Débito";
    }
    
    /**
     * Retorna uma representação em String da forma de pagamento.
     * 
     * @return String "Cartão de Crédito / Débito".
     */
    @Override
    public String toString() {
        return "Cartão de Crédito / Débito";
    }
}
