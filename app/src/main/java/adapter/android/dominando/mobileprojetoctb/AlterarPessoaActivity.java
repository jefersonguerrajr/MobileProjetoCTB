package adapter.android.dominando.mobileprojetoctb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.android.dominando.mobileprojetoctb.BDHelper.PessoasBd;
import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;

public class AlterarPessoaActivity extends AppCompatActivity {

    ListView lista;
    PessoasBd bdhelper;
    ArrayList<Pessoa> listviewPessoa;
    Pessoa pessoa;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar_pessoa);

        lista = (ListView) findViewById(R.id.listviewPessoaID);
    }

    protected void onResume(){
        super.onResume();
        carregarPessoa();
    }

    public void carregarPessoa(){
        bdhelper = new PessoasBd(AlterarPessoaActivity.this);
        listviewPessoa = bdhelper.getLista();
        bdhelper.close();

        if (listviewPessoa != null){
            adapter = new ArrayAdapter<Pessoa>(AlterarPessoaActivity.this, android.R.layout.simple_expandable_list_item_1);
            lista.setAdapter(adapter);
        }
        finish();
    }
}
