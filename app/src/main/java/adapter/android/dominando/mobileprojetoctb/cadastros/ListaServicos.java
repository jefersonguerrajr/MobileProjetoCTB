package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import adapter.android.dominando.mobileprojetoctb.BDHelper.PessoasBd;
import adapter.android.dominando.mobileprojetoctb.BDHelper.ServicoBd;
import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;
import adapter.android.dominando.mobileprojetoctb.basicas.Servicos;

public class ListaServicos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);

       final String[] listadosservicos = {"Oleo","Pintura","Lanternagem"};
        int layaut = android.R.layout.simple_list_item_1;
        final ArrayAdapter<String> adapter = new ArrayAdapter <String>(this, layaut,listadosservicos);


        ListView listaservicos = (ListView) findViewById(R.id.listaservicos);

        listaservicos.setAdapter(adapter);

        listaservicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListaServicos.this, "Serviço"+listadosservicos[position], Toast.LENGTH_SHORT).show();
            }
        });
        listaservicos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(ListaServicos.this, "Serviço de:"+adapter.getItemViewType(position), Toast.LENGTH_SHORT).show();
                return false;
            }
        });


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
                Intent novoFormulario = new Intent(this, FormularioServicos.class);
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
