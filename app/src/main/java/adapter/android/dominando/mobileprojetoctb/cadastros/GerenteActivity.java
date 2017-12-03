package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.cadastros.Pessoa.ListaPessoaActivity;

public class GerenteActivity extends AppCompatActivity {
    private ImageView btnPessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerente);



        btnPessoa = (ImageView) findViewById(R.id.imgPessoaID);
        btnPessoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GerenteActivity.this, ListaPessoaActivity.class);
                startActivity(intent);
            }
        });
    }
}
