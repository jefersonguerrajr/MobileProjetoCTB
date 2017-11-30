package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import adapter.android.dominando.mobileprojetoctb.BDHelper.VeiculoBd;
import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Veiculo;

public class ListaVeiculosActivity extends AppCompatActivity {

    private Button btnCadastrarVeiculo;
    ListView lista;
    VeiculoBd bdHelper;
    ArrayList<Veiculo> listviewVeiculo;
    Veiculo veiculo;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_veiculos);

        lista = (ListView) findViewById(R.id.listviewVeiculoID);
        registerForContextMenu(lista);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
                Veiculo veiculoEscolhido = (Veiculo) adapter.getItemAtPosition(position);
                Intent i = new Intent(ListaVeiculosActivity.this, FormularioVeiculoActivity.class);

                i.putExtra("veiculo-escolhido", veiculoEscolhido);
                startActivity(i);
            }
        });


        btnCadastrarVeiculo = (Button) findViewById(R.id.btnCadastrarVeiculo);
        btnCadastrarVeiculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ListaVeiculosActivity.this, FormularioVeiculoActivity.class);
                startActivity(intent);
            }
        });

           }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem menuDelete = menu.add("Deletar Este Veiculo");
        menuDelete.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                bdHelper = new VeiculoBd(ListaVeiculosActivity.this);
                bdHelper.deteltarVeiculo(veiculo);
                bdHelper.close();
                carregarVeiculo();
                return true;
            }
        });
    }

    protected  void onResume(){
        super.onResume();
        carregarVeiculo();
    }

    public void carregarVeiculo(){
        bdHelper = new VeiculoBd(ListaVeiculosActivity.this);
        listviewVeiculo = bdHelper.getLista();
        bdHelper.close();

        if (listviewVeiculo != null){
            adapter = new ArrayAdapter<Veiculo>(ListaVeiculosActivity.this, android.R.layout.simple_list_item_1, listviewVeiculo);
            lista.setAdapter(adapter);
        }

    }

}
