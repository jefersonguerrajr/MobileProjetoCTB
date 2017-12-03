package adapter.android.dominando.mobileprojetoctb.cadastros.Pessoa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.basicas.Pessoa;

/**
 * Created by cppde on 02/12/2017.
 */

public class PessoaAdapter extends ArrayAdapter<Pessoa> {

    private ArrayList<Pessoa> pessoas;

    public PessoaAdapter(@NonNull Context context, @NonNull ArrayList<Pessoa> pessoas) {
        super(context, 0, pessoas);
        this.pessoas = pessoas;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Pessoa pessoa = pessoas.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_pessoa, null);

        TextView textViewNome = (TextView)convertView.findViewById(R.id.txtViewNome);
        TextView textViewEmail = (TextView)convertView.findViewById(R.id.txtViewEmail);

        textViewNome.setText(pessoa.getNomePessoa().toString());
        textViewEmail.setText(pessoa.getEmailPessoa().toString());

        return convertView;

    }
}
