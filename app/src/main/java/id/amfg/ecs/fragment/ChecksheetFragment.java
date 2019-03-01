package id.amfg.ecs.fragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.amfg.ecs.R;
import id.amfg.ecs.adapter.ChecksheetAdapter;

import android.telephony.mbms.MbmsErrors;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ChecksheetFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_checksheet, container, false);
//        mRecyclerView = rootView.findViewById(R.id.cs_recyclerview);
//        ChecksheetAdapter adapter = new ChecksheetAdapter(getActivity(), mImage, mNames);
//        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        initialData();
//        return rootView;
        return inflater.inflate(R.layout.fragment_checksheet, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    public ChecksheetFragment() {

    }

    protected RecyclerView mRecyclerView;
    private ArrayList<String> mNames;
    //private ArrayList<String> mImage = new ArrayList<>();
    private int[] mImage;

    private void initialData() {
        mNames = new ArrayList<>();
        mImage = new int[2];

        mNames.add("Kelengkapan Process Persiapan Kaca & JIG");
        mImage[0] = R.drawable.ic_assignment_green_24dp;

        mNames.add("Kelengkapan Process Persiapan Bracket");
        mImage[1] = R.drawable.ic_assignment_green_24dp;
    }
}
