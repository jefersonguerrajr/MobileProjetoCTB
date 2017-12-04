package adapter.android.dominando.mobileprojetoctb.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Relatorio;

/**
 * Created by desenvolvimento on 03/12/2017.
 */

public class ListaRelatorioFragments extends android.support.v4.app.Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View listadoRelatorio = inflater.inflate(R.layout.relatorio_lista,null);

        ListView listagemdeRelatorios  = (ListView) listadoRelatorio.findViewById(R.id.relatorios);

        Relatorio relatorio1 = new Relatorio("20/03/2012","Troca de oleo");
        relatorio1.setTopicos(Arrays.asList("Alinhamento","Polimento","Lavagem Rapida"));

        Relatorio relatorio2 = new Relatorio("20/03/2012","Lanternagem");
        relatorio2.setTopicos(Arrays.asList("Troca de Oleo linera",
                "Manutenção","Limpeza de bico"));
        List<Relatorio> relatorios = Arrays.asList(relatorio1,relatorio2);

        int layout = android.R.layout.simple_list_item_1;

        FragmentActivity contex = getActivity();

        ArrayAdapter<Relatorio> adapter = new ArrayAdapter<Relatorio>(contex, layout,relatorios);

        listagemdeRelatorios.setAdapter(adapter);

        return listadoRelatorio;
    }
}
