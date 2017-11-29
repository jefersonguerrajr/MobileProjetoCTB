package adapter.android.dominando.mobileprojetoctb.basicas;

/**
 * Created by desenvolvimento on 28/11/2017.
 */

public class Servicos {
    Long id;
    String nomeEstabelecimento;
    String tipoServico;
    double valorServico;
    String enderecoEstabelecimentodoServico;
    String telefoneEstabelecimentodoServico;
    double avaliacaoEstavelecimentodoServico;

    // Construtor
    public Servicos() {
        this.id = id;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.tipoServico = tipoServico;
        this.valorServico = valorServico;
        this.enderecoEstabelecimentodoServico = enderecoEstabelecimentodoServico;
        this.telefoneEstabelecimentodoServico = telefoneEstabelecimentodoServico;
        this.avaliacaoEstavelecimentodoServico = avaliacaoEstavelecimentodoServico;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEstabelecimento() {
        return nomeEstabelecimento;
    }

    public void setNomeEstabelecimento(String nomeEstabelecimento) {
        this.nomeEstabelecimento = nomeEstabelecimento;
    }

    public String getTipoServico() {
        return tipoServico;
    }

    public void setTipoServico(String tipoServico) {
        this.tipoServico = tipoServico;
    }

    public double getValorServico() {
        return valorServico;
    }

    public void setValorServico(double valorServico) {
        this.valorServico = valorServico;
    }

    public String getEnderecoEstabelecimentodoServico() {
        return enderecoEstabelecimentodoServico;
    }

    public void setEnderecoEstabelecimentodoServico(String enderecoEstabelecimentodoServico) {
        this.enderecoEstabelecimentodoServico = enderecoEstabelecimentodoServico;
    }

    public String getTelefoneEstabelecimentodoServico() {
        return telefoneEstabelecimentodoServico;
    }

    public void setTelefoneEstabelecimentodoServico(String telefoneEstabelecimentodoServico) {
        this.telefoneEstabelecimentodoServico = telefoneEstabelecimentodoServico;
    }

    public double getAvaliacaoEstavelecimentodoServico() {
        return avaliacaoEstavelecimentodoServico;
    }

    public void setAvaliacaoEstavelecimentodoServico(double avaliacaoEstavelecimentodoServico) {
        this.avaliacaoEstavelecimentodoServico = avaliacaoEstavelecimentodoServico;
    }
}

