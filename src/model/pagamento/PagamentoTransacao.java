package model.pagamento;

public class PagamentoTransacao extends Pagamento {

    public PagamentoTransacao(FormaDePagamento formaPagamento) {
        super(formaPagamento);
    }

    @Override
    public void processarPagamento(double valor) {
        formaPagamento.pagar(valor);
    }
}
