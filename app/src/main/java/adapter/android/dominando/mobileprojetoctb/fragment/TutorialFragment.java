package adapter.android.dominando.mobileprojetoctb.fragment;


import android.os.Bundle;;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import adapter.android.dominando.mobileprojetoctb.R;

public class TutorialFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                           Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tutorial, container, false);

                return view;
    }

}
