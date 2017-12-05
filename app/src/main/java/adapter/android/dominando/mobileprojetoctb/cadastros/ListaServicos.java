package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import adapter.android.dominando.mobileprojetoctb.BDHelper.ServicoBd;
import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Servicos;

public class ListaServicos extends AppCompatActivity {
    private  ListView listaservicos;
    private  Servicos servico;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_servicos);
        listaservicos = (ListView) findViewById(R.id.listaservicos);
        registerForContextMenu(listaservicos);

        listaservicos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                //   Toast.makeText(ListaServicos.this, "Serviço"+position, Toast.LENGTH_SHORT).show();

                Servicos servicosClicado =  (Servicos) adapter.getItemAtPosition(position);
                Intent intentParaFormularioDeAlterar = new Intent(ListaServicos.this,FormularioServicos.class);
                intentParaFormularioDeAlterar.putExtra("servicoSelecionado",servicosClicado);
                startActivity(intentParaFormularioDeAlterar);
            }
        });

        listaservicos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapter, View view, int position, long id) {
                servico = (Servicos) adapter.getItemAtPosition(position);
                return false;
            }
        });
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem deletar = menu.add("deletar");
        deletar.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                ServicoBd dao = new ServicoBd(ListaServicos.this);
                dao.deletar(servico);
                dao.close();
                carregaLista();
                return false;
            }
        });
        menu.add("alterar");
        super.onCreateContextMenu(menu, v, menuInfo);
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
            case  R.id.btFragment:
                Intent irpararelatorio = new Intent(this, Relatorios.class);
                startActivity(irpararelatorio);
                //default:
                break;

            case  R.id.sair:
              finish();
            break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();

    }

    private void carregaLista() {
        ServicoBd servicoBd = new ServicoBd(this);
        List<Servicos>servicos = servicoBd.getListaServico();
        servicoBd.close();

        //final String[] listadosservicos = {"Oleo","Pintura","Lanternagem"};
        int layaut = android.R.layout.simple_list_item_1;
        ArrayAdapter<Servicos> adapter = new ArrayAdapter <Servicos>(this, layaut,servicos);
        listaservicos.setAdapter(adapter);
    }
}

