package adapter.android.dominando.mobileprojetoctb.cadastros.Pessoa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;

public class ConsultarPessoaActivity extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemClickListener {

    private ListView listViewPessoas;
    private Button btnFechar;
    private PessoaAdapter pessoaAdapter;
    private ArrayList<Pessoa> pessoas;
    private Pessoa pessoaEdicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_pessoa);

        btnFechar = (Button)findViewById(R.id.btnFecharPessoa);
        btnFechar.setOnClickListener(this);


        listViewPessoas = (ListView)findViewById(R.id.listviewPessoa);
        listViewPessoas.setOnItemClickListener(this);

        pessoas = new Pessoa(this).getPessoas();
        pessoaAdapter = new PessoaAdapter(this,pessoas);
        listViewPessoas.setAdapter(pessoaAdapter);

    }

    @Override
    public void onClick(View view) {
        finish();
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
        Pessoa pessoa = pessoas.get(position);
        Intent intent = new Intent(this, FormularioPessoaActivity.class);
        intent.putExtra("consulta", pessoa.getId());
        pessoaEdicao = pessoa;
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (pessoaEdicao != null){
           pessoaEdicao.carregaPessoaPeloID(pessoaEdicao.getId());
           if (pessoaEdicao.isExcluir())
               pessoas.remove(pessoaEdicao);
           pessoaAdapter.notifyDataSetChanged();

        }
    }
}
