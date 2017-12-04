package adapter.android.dominando.mobileprojetoctb.cadastros;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import adapter.android.dominando.mobileprojetoctb.R;
import adapter.android.dominando.mobileprojetoctb.fragments.DetalheRelatorioFragments;
import adapter.android.dominando.mobileprojetoctb.fragments.ListaRelatorioFragments;

public class Relatorios extends FragmentActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_relatorioss);
        //setContentView(R.layout.relatoriodeservicos);
        setContentView(R.layout.relatoriodeservicos);

        FragmentManager manager = getSupportFragmentManager();


        android.support.v4.app.FragmentTransaction transaction = manager.beginTransaction();
        //verificar se é um tablet horizontal ou nao
        if (isTabletEmLandscape()){
            transaction.replace(R.id.esquerdaTablets, new ListaRelatorioFragments());
            transaction.replace(R.id.diretitaTablets, new DetalheRelatorioFragments());

        }else{
            transaction.replace(R.id.unico, new ListaRelatorioFragments());

        }
        transaction.commit();
    }

    public boolean isTabletEmLandscape() {


        return getResources().getBoolean(R.bool.ehTabletNaHorizontal);
    }
}
