package model.pagamento;

public abstract class Pagamento {
    protected FormaDePagamento formaPagamento;

    public Pagamento(FormaDePagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public abstract void processarPagamento(double valor);

    public String getDescricaoFormaPagamento() {
        return formaPagamento.getDescricao();
    }
}
