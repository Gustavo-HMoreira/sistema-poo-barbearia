package model.pagamento;

public interface FormaDePagamento {
    void pagar(double valor);
    String getDescricao();
}
