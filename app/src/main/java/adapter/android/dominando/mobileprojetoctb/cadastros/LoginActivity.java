package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.cadastros.Pessoa.FormularioPessoaActivity;

public class LoginActivity extends AppCompatActivity {


    private View.OnClickListener tratadorDoBotao = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent it = new Intent(LoginActivity.this, GerenteActivity.class);
            startActivity(it);
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


