package adapter.android.dominando.mobileprojetoctb.basicas;

import java.io.Serializable;

/**
 * Created by desenvolvimento on 28/11/2017.
 */

public class Servicos implements Serializable{
    Long id;
    String nomeEstabelecimento;
    String tipoServico;
    Double valorServico;
    String enderecoEstabelecimentodoServico;
    String telefoneEstabelecimentodoServico;
    Double avaliacaoEstavelecimentodoServico;

    @Override
    public String toString() {
        return nomeEstabelecimento;
    }

    // Construtor
   /* public Servicos() {
        this.id = id;
        this.nomeEstabelecimento = nomeEstabelecimento;
        this.tipoServico = tipoServico;
        this.valorServico = valorServico;
        this.enderecoEstabelecimentodoServico = enderecoEstabelecimentodoServico;
        this.telefoneEstabelecimentodoServico = telefoneEstabelecimentodoServico;
        this.avaliacaoEstavelecimentodoServico = avaliacaoEstavelecimentodoServico;

    }
*/
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

    public Double getValorServico() {
        return valorServico;
    }

    public void setValorServico(Double valorServico) {
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

    public Double getAvaliacaoEstavelecimentodoServico() {
        return avaliacaoEstavelecimentodoServico;
    }

    public void setAvaliacaoEstavelecimentodoServico(Double avaliacaoEstavelecimentodoServico) {
        this.avaliacaoEstavelecimentodoServico = avaliacaoEstavelecimentodoServico;
    }
}

