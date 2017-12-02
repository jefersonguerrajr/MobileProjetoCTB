package adapter.android.dominando.mobileprojetoctb.cadastros.Pessoa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;

public class FormularioPessoaActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edtNomePessoa;
    private EditText edtEmailPessoa;
    private EditText edtSenhaPessoa;

    private Button btnSalvarPessoa;
    private Button btnExcluirPessoa;
    private Button btnCancelarPessoa;

    private final Pessoa pessoa = new Pessoa(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pessoa);

        edtNomePessoa = (EditText) findViewById(R.id.edtNomePessoa);
        edtEmailPessoa = (EditText) findViewById(R.id.edtEmailPessoa);
        edtSenhaPessoa = (EditText) findViewById(R.id.edtSenhaPessoa);
        btnSalvarPessoa = (Button)findViewById(R.id.btnSalvarPessoa);
        btnExcluirPessoa = (Button)findViewById(R.id.btnExcluirPessoa);
        btnCancelarPessoa = (Button)findViewById(R.id.btnCancelarPessoa);

        btnSalvarPessoa.setOnClickListener(this);
        btnExcluirPessoa.setOnClickListener(this);
        btnCancelarPessoa.setOnClickListener(this);



        if (getIntent().getExtras() != null){
            setTitle(getString(R.string.titulo_editando));
            int id = getIntent().getExtras().getInt("consulta");
            pessoa.carregaPessoaPeloID(id);

            if (pessoa.getNomePessoa() != null)
                edtNomePessoa.setText(pessoa.getNomePessoa().toString());
                edtEmailPessoa.setText(pessoa.getEmailPessoa().toString());
                edtSenhaPessoa.setText(pessoa.getSenhaPessoa().toString());

        }else {
            setTitle(getString(R.string.titulo_incluindo));
        }
        btnExcluirPessoa.setEnabled(true);
        if (pessoa.getId() == -1)
            btnExcluirPessoa.setEnabled(false);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCancelarPessoa :{
                finish();
                break;
            }case R.id.btnExcluirPessoa : {
                pessoa.excluir();
                finish();
                break;
            }case R.id.btnSalvarPessoa :{
                boolean valido = true;
                pessoa.setNomePessoa(edtNomePessoa.getText().toString().trim());
                pessoa.setEmailPessoa(edtEmailPessoa.getText().toString().trim().toLowerCase());
                pessoa.setSenhaPessoa(edtSenhaPessoa.getText().toString().trim());

                if (pessoa.getNomePessoa().equals("")){
                    edtNomePessoa.setError(getString(R.string.obrigatorio));
                    valido = false;
                }
                if (pessoa.getEmailPessoa().equals("")){
                    edtEmailPessoa.setError(getString(R.string.obrigatorio));
                    valido = false;
                }
                if (pessoa.getSenhaPessoa().equals("")){
                    edtSenhaPessoa.setError(getString(R.string.obrigatorio));
                    valido = false;
                }

                if (valido){
                    pessoa.salvar();
                    finish();
                }
                break;
            }
        }
    }
}
