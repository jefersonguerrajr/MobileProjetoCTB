package adapter.android.dominando.mobileprojetoctb.cadastros.Pessoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.cadastros.AposLogarActivity;

public class ListaPessoaActivity extends AppCompatActivity {

    private Button btnIncluir;
    private Button btnConsultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pessoa);

        btnIncluir = (Button) findViewById(R.id.btnIncluirPessoa);
        btnIncluir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaPessoaActivity.this, FormularioPessoaActivity.class);
                startActivity(intent);
            }
        });

        btnConsultar = (Button) findViewById(R.id.btnConsultarPessoa);
        btnConsultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaPessoaActivity.this, ConsultarPessoaActivity.class);
                startActivity(intent);
            }
        });
    }
}
