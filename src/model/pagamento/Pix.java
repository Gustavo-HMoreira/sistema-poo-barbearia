package model.pagamento;

public class Pix implements FormaDePagamento {
    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado via Pix.");
    }

    @Override
    public String getDescricao() {
        return "Pix";
    }
    
    /**
     * Retorna uma representação em String da forma de pagamento.
     * 
     * @return String "Pix".
     */
    @Override
    public String toString() {
        return "Pix";
    }
}
