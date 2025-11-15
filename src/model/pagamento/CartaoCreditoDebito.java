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
}
//implementação concreta