package id.amfg.ecs.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import id.amfg.ecs.R;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ChecksheetFragment extends Fragment {


    public ChecksheetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_checksheet, container, false);
    }

}
