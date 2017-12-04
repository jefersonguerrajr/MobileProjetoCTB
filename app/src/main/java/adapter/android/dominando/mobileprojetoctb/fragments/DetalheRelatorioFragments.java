package adapter.android.dominando.mobileprojetoctb.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Relatorio;

/**
 * Created by desenvolvimento on 03/12/2017.
 */

public class DetalheRelatorioFragments extends android.support.v4.app.Fragment{
    private TextView campoMateria;
    private TextView campoData;
    private ListView listaTopicos;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View viewDetalhesRelatorio = inflater.inflate(R.layout.relatoriodetalhes,null);

        campoMateria = (TextView) viewDetalhesRelatorio.findViewById(R.id.detalhes_servico);
        campoData = (TextView) viewDetalhesRelatorio.findViewById(R.id.detalhes_data);
        listaTopicos = (ListView) viewDetalhesRelatorio.findViewById(R.id.detalhes_prova_topicos);
        Bundle parametros = getArguments();
        if (parametros != null) {
            Relatorio prova = (Relatorio) parametros.getSerializable("relatorio");
            populaCamposCom(prova);
        }

        return viewDetalhesRelatorio;
    }

    private void populaCamposCom(Relatorio relatorio) {

        campoMateria.setText(relatorio.getServicoRelacorio());
        campoData.setText(relatorio.getDataServico());

        ArrayAdapter<String> adapterTopicos =
                new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, relatorio.getTopicos());
        listaTopicos.setAdapter(adapterTopicos);
    }
}

