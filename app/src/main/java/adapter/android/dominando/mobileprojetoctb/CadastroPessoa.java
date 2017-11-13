package adapter.android.dominando.mobileprojetoctb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import adapter.android.dominando.mobileprojetoctb.DAO.Create;
import adapter.android.dominando.mobileprojetoctb.DAO.Update;
import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;

public class CadastroPessoa extends AppCompatActivity {

    Button mBotaoSalvar;
    EditText mNome, mEmail, mCpf, mSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_pessoa);

        mNome = (EditText) findViewById(R.id.edtNomeID);
        mEmail = (EditText) findViewById(R.id.edtEmailID);
        mCpf = (EditText) findViewById(R.id.edtCPFID);
        mSenha = (EditText) findViewById(R.id.edtSenhaID);
        mBotaoSalvar = (Button) findViewById(R.id.btnSalvarID);

        Create c = new Create(getApplicationContext());
        c.createTable();

        mBotaoSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pessoa p = new Pessoa();
                p.setNome(mNome.getText().toString());
                p.setEmail(mEmail.getText().toString());
                p.setSenha(mSenha.getText().toString());
                p.setCpf(Integer.parseInt(mCpf.getText().toString()));

                Update u = new Update(getApplicationContext());
                if (u.insertPessoa(p)){
                    Toast.makeText(CadastroPessoa.this, "Usuário Inserido com sucesso", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(CadastroPessoa.this, "Erro: Usuário não foi inserido", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
