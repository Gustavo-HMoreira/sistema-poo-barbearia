package model;

/**
 * A classe Servico representa um serviço oferecido pela barbearia.
 * Contém informações como ID, nome, preço, descrição e tipo do serviço.
 */
public class Servico {
    private int idServico;
    private String nomeServico;
    private double preco;
    private String descricao;
    private TipoServico tipoServico;

    /**
     * Construtor da classe Servico.
     * @param idServico O ID único do serviço.
     * @param nomeServico O nome do serviço.
     * @param descricao A descrição detalhada do serviço.
     * @param preco O preço do serviço.
     * @param tipoServico O tipo de serviço (Corte, Barba, etc.).
     */
    public Servico(int idServico, String nomeServico, String descricao, double preco, TipoServico tipoServico) {
        this.idServico = idServico;
        this.nomeServico = nomeServico;
        this.preco = preco;
        this.descricao = descricao;
        this.tipoServico = tipoServico;
    }

    /**
     * Retorna o ID do serviço.
     * @return O ID do serviço.
     */
    public int getIdServico() {
        return idServico;
    }

    /**
     * Define o ID do serviço.
     * @param idServico O novo ID do serviço.
     */
    public void setIdServico(int idServico) {
        this.idServico = idServico;
    }

    /**
     * Retorna o nome do serviço.
     * @return O nome do serviço.
     */
    public String getNomeServico() {
        return nomeServico;
    }

    /**
     * Define o nome do serviço.
     * @param nomeServico O novo nome do serviço.
     */
    public void setNomeServico(String nomeServico) {
        this.nomeServico = nomeServico;
    }

    /**
     * Retorna o preço do serviço.
     * @return O preço do serviço.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do serviço.
     * @param preco O novo preço do serviço.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Retorna a descrição do serviço.
     * @return A descrição do serviço.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do serviço.
     * @param descricao A nova descrição do serviço.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna o tipo do serviço.
     * @return O tipo do serviço.
     */
    public TipoServico getTipoServico() {
        return tipoServico;
    }

    /**
     * Define o tipo do serviço.
     * @param tipoServico O novo tipo do serviço.
     */
    public void setTipoServico(TipoServico tipoServico) {
        this.tipoServico = tipoServico;
    }

    /**
     * Retorna uma representação em String do objeto Servico.
     * @return Uma String contendo o ID, nome, preço, descrição e tipo do serviço.
     */
    @Override
    public String toString() {
        return "ID: " + idServico + ", Serviço: " + nomeServico + ", Preço: R$ " + String.format("%.2f", preco) + ", Descrição: " 
                + descricao + ", Tipo: " + tipoServico.getDescricao();
    }
}

