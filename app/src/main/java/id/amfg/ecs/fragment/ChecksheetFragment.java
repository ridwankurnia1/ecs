package id.amfg.ecs.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.amfg.ecs.R;
import id.amfg.ecs.adapter.ChecksheetAdapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class ChecksheetFragment extends Fragment {

//    @Override
//    public void OnCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        initialData();
//    }

    public ChecksheetFragment() {
        // Required empty public constructor
    }

    protected RecyclerView mRecyclerView;
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImage = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initialData();
        View rootView = inflater.inflate(R.layout.fragment_checksheet,container,false);
        mRecyclerView = rootView.findViewById(R.id.cs_recyclerview);
        ChecksheetAdapter adapter = new ChecksheetAdapter(getActivity(), mImage, mNames);
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return rootView;
    }

    private void initialData() {
        for (int i = 0; i < 5; i++) {
            mNames.add("images " + Integer.toString(i));
            mImage.add("https://i.imgur.com/ZcLLrkY.jpg");
        }
    }
}
