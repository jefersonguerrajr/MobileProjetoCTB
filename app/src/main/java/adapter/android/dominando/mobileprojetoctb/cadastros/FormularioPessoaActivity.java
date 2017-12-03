package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.Button;

import adapter.android.dominando.mobileprojetoctb.BDHelper.PessoasBd;
import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;

public class FormularioPessoaActivity extends AppCompatActivity {
    Pessoa editarPessoa, pessoa;
    PessoasBd bdHelper;
    private AppCompatEditText editTextEmail;
    private AppCompatEditText editTextSenha;
    private TextInputLayout textLayoutEmail;
    private TextInputLayout textLayoutSenha;
    private Button btnPolimorfi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario_pessoa);

        pessoa = new Pessoa();
        bdHelper = new PessoasBd(FormularioPessoaActivity.this);

        Intent intent = getIntent();
        editarPessoa = (Pessoa) intent.getSerializableExtra("Pessoa Escolhida");

        editTextEmail = (AppCompatEditText) findViewById(R.id.edtEmailID);
        textLayoutEmail = (TextInputLayout) findViewById(R.id.txtLayout_email);
        editTextSenha = (AppCompatEditText) findViewById(R.id.edtSenhaID);
        textLayoutSenha = (TextInputLayout) findViewById(R.id.txtLayout_senha);

        btnPolimorfi = (Button) findViewById(R.id.btnPolimorfiID);

        if (editarPessoa != null){
            btnPolimorfi.setText("Modificar");
        }else {
            btnPolimorfi.setText("Salvar");
        }



        btnPolimorfi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validateForm();
                pessoa.setEmail(editTextEmail.getText().toString());
                pessoa.setSenha(editTextSenha.getText().toString());

                if(btnPolimorfi.getText().toString().equals("Salvar")){
                    bdHelper.salvarPessoa(pessoa);
                    bdHelper.close();
                }else{
                    bdHelper.alterarPessoa(pessoa);
                    bdHelper.close();
                }
            }
        });

    }


    private void validateForm(){
        if (editTextEmail.getText().toString().isEmpty()){
            textLayoutEmail.setErrorEnabled(true);
            textLayoutEmail.setError("Preencha com o seu email");
        }else {
            textLayoutEmail.setErrorEnabled(false);
        }

        if (editTextSenha.getText().toString().isEmpty()){
            textLayoutSenha.setErrorEnabled(true);
            textLayoutSenha.setError("Preencha com a sua senha");
        }else {
            textLayoutSenha.setErrorEnabled(false);
        }

    }
}
