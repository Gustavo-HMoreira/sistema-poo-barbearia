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
}
