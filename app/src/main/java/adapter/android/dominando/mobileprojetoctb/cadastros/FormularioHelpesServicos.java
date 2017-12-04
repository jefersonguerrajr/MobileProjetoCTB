package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.widget.EditText;
import android.widget.RatingBar;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Servicos;

/**
 * Created by desenvolvimento on 28/11/2017.
 */

public  class FormularioHelpesServicos {
    private EditText editNomeEstabelecimento;
    private EditText tipoServico;
    private EditText valorServico;
    private EditText editEnderecoEstabelecimento;
    private EditText telefoneEstabelecimento;
    private  RatingBar avaliacaoEstavelecimentodoServico;

    public FormularioHelpesServicos(FormularioServicos formularioServicos) {

        editNomeEstabelecimento = (EditText) formularioServicos.findViewById(R.id.edText_NomeEstabelecimento);
        tipoServico = (EditText) formularioServicos.findViewById(R.id.edText2_tipoServico);
        valorServico = (EditText) formularioServicos.findViewById(R.id.editTValorServico);
        editEnderecoEstabelecimento = (EditText) formularioServicos.findViewById(R.id.editTextEndereco);
        telefoneEstabelecimento = (EditText) formularioServicos.findViewById(R.id.editTextTelefone);
        avaliacaoEstavelecimentodoServico = (RatingBar) formularioServicos.findViewById(R.id.ratingBarAvaliacaoServico);
    }

    public Servicos pegarServicodoFormulario() {
        Servicos servicos = new Servicos();

        servicos.setNomeEstabelecimento(editNomeEstabelecimento.getText().toString());
        servicos.setTipoServico(tipoServico.getText().toString());
        servicos.setValorServico(Double.valueOf(valorServico.getText().toString()));
        servicos.setEnderecoEstabelecimentodoServico(editEnderecoEstabelecimento.getText().toString());
        servicos.setTelefoneEstabelecimentodoServico(telefoneEstabelecimento.getText().toString());
        servicos.setAvaliacaoEstavelecimentodoServico(Double.valueOf(avaliacaoEstavelecimentodoServico.getRating()));

        return servicos;
    }

    public void colocarServico(Servicos servicosAlterar) {

        editNomeEstabelecimento.setText(servicosAlterar.getNomeEstabelecimento());
        tipoServico.setText(servicosAlterar.getTipoServico());

        //Double.valueOf(servicosAlterar.getValorServico());
        editEnderecoEstabelecimento.setText(servicosAlterar.getNomeEstabelecimento());
        telefoneEstabelecimento.setText(servicosAlterar.getTelefoneEstabelecimentodoServico());
        avaliacaoEstavelecimentodoServico.setRating(servicosAlterar.getAvaliacaoEstavelecimentodoServico().floatValue());

    }
}
