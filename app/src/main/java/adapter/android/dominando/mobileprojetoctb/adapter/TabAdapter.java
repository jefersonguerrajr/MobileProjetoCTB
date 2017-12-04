package adapter.android.dominando.mobileprojetoctb.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import adapter.android.dominando.mobileprojetoctb.fragment.PessoasFragment;
import adapter.android.dominando.mobileprojetoctb.fragment.VeiculoFragment;

/**
 * Created by cppde on 04/12/2017.
 */

public class TabAdapter extends FragmentStatePagerAdapter {

private String[] tituloAbas = {"TUTORIAL", "SOBRE"};

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;

        switch (position){
            case 0:
                fragment = new PessoasFragment();
                break;
            case 1:
                fragment = new VeiculoFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {

        return tituloAbas.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tituloAbas[position];
    }
}
