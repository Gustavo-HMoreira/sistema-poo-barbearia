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
}
