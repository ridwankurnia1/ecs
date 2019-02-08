package id.amfg.ecs.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import id.amfg.ecs.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatrolFragment extends Fragment {


    public PatrolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_patrol, container, false);
    }

}
