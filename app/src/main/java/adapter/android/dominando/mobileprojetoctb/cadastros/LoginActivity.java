package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;
import adapter.android.dominando.mobileprojetoctb.cadastros.Pessoa.FormularioPessoaActivity;

public class LoginActivity extends AppCompatActivity {

    public final Pessoa pessoa = new Pessoa(this);

    private View.OnClickListener tratadorDoBotao = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText editText = (EditText) findViewById(R.id.loginID);
            String usuario, senha;
            usuario = editText.getText().toString();
            editText = (EditText) findViewById(R.id.passwordID);
            senha = editText.getText().toString();
            if(pessoa.validadorLogin(usuario,senha)) {
                Toast.makeText(getApplicationContext(), "Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                Intent it = new Intent(LoginActivity.this, GerenteActivity.class);
                startActivity(it);
            }else{
                Toast.makeText(getApplicationContext(), "Falha no login, verifique os dados cadastrados", Toast.LENGTH_SHORT).show();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        findViewById(R.id.btnAcessarID).setOnClickListener(tratadorDoBotao);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menutelainicio,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemClicado = item.getItemId();

        switch (itemClicado){
            case R.id.novo:
                Intent novoFormulario = new Intent(this, FormularioPessoaActivity.class);
               startActivity(novoFormulario);
                break;
            case  R.id.sair:
                finish();
                break;

                default:
                    break;

        }


        return super.onOptionsItemSelected(item);
    }
}


