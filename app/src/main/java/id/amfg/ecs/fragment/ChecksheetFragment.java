package id.amfg.ecs.fragment;


import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import id.amfg.ecs.BracketActivity;
import id.amfg.ecs.MainActivity;
import id.amfg.ecs.R;
import id.amfg.ecs.adapter.AdapterChecksheet;
import id.amfg.ecs.adapter.ChecksheetAdapter;
import id.amfg.ecs.model.MenuChecksheet;

import android.telephony.mbms.MbmsErrors;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ChecksheetFragment extends Fragment implements AdapterChecksheet.OnMenuClickListener {

    private RecyclerView listMenu;
    protected Context context;
    private LinearLayoutManager linearLayoutManager;
    private AdapterChecksheet adapterChecksheet;
    private  ArrayList<MenuChecksheet> menuChecksheetArrayList;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView, menuView;

    public static ChecksheetFragment newInstance(){
        return  new ChecksheetFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }
   /* @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(R.layout.fragment_checksheet, container, false);
//        mRecyclerView = rootView.findViewById(R.id.cs_recyclerview);
//        ChecksheetAdapter adapter = new ChecksheetAdapter(getActivity(), mImage, mNames);
//        mRecyclerView.setAdapter(adapter);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        initialData();
//        return rootView;
        return inflater.inflate(R.layout.fragment_checksheet, container, false);
    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_checksheet, container, false);
        listMenu = (RecyclerView) rootView.findViewById(R.id.cs_recyclerview);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        addMenu();
        linearLayoutManager = new LinearLayoutManager(context);
        adapterChecksheet = new AdapterChecksheet(menuChecksheetArrayList, this);
        listMenu.setLayoutManager(linearLayoutManager);
        listMenu.setAdapter(adapterChecksheet);
    }

    //dummy data
    private void addMenu() {
        menuChecksheetArrayList = new ArrayList<>();
        //looping buat cek list recyclerview
        /*int i = 0;
        do{
            i++;
            menuChecksheetArrayList.add(new MenuChecksheet("Menu "+i, R.drawable.ic_assignment_green_24dp));
        }while (i<=20);*/
        menuChecksheetArrayList.add(new MenuChecksheet("Menu satu", R.drawable.ic_assignment_green_24dp));
        menuChecksheetArrayList.add(new MenuChecksheet("Menu dua", R.drawable.ic_assignment_green_24dp));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onMenuClick(int position) {
        int a = position+1;

        //deklarasi view di menu jadi bisa ngambil text view di xml menu_checkseet
        /*menuView = inflater.inflate(R.layout.menu_checksheet, null);
        TextView tvMenu = (TextView) menuView.findViewById(R.id.img_name);
        String t = tvMenu.getText().toString();
        Log.e("debug", "Muncul > " + t.toString());*/

        Toast.makeText(getContext(),"Di klik menu " +a, Toast.LENGTH_SHORT).show();

        popupDialog(position);
    }

    private void popupDialog(int position){
        AlertDialog.Builder dialog;
        dialog = new AlertDialog.Builder(getContext());
        Button btnMp1, btnMp2, btnMp3;
        inflater = getLayoutInflater();
        dialogView = inflater.inflate(R.layout.dialog_checkseet, null);
        dialog.setView(dialogView);
        dialog.setCancelable(true);
        dialog.setTitle("Select Man Power");

        btnMp1 = (Button) dialogView.findViewById(R.id.btnMp1);
        btnMp2 = (Button) dialogView.findViewById(R.id.btnMp2);
        btnMp3 = (Button) dialogView.findViewById(R.id.btnMp3);
        switch (position){
            case 0:
                btnMp1.setText("Man Power 1");
                btnMp2.setText("Man Power 2");
                btnMp3.setTextColor(getResources().getColor(R.color.colorWhite));
                btnMp3.setEnabled(true);
                btnMp3.setText("Man Power 3");
                btnMp1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"button pop up mp1 di klik", Toast.LENGTH_SHORT).show();
                        /*Intent i = new Intent(getContext(), BracketActivity.class);
                        i.putExtra("mp","mp1");
                        startActivity(i);*/
                    }
                });
                btnMp2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"button pop up mp2 di klik", Toast.LENGTH_SHORT).show();
                        /*Intent i = new Intent(getContext(), BracketActivity.class);
                        i.putExtra("mp","mp2");
                        startActivity(i);*/
                    }
                });
                btnMp3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"button pop up mp3 di klik", Toast.LENGTH_SHORT).show();
                        /*Intent i = new Intent(getContext(), BracketActivity.class);
                        i.putExtra("mp","mp3");
                        startActivity(i);*/
                    }
                });
                break;
            case 1:
                btnMp1.setText("Man Power 4");
                btnMp2.setText("Man Power 5");
                btnMp3.setTextColor(232323);
                btnMp3.setEnabled(false);
                btnMp1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"button pop up mp4 di klik", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getContext(), BracketActivity.class);
                        i.putExtra("mp","mp4");
                        startActivity(i);
                    }
                });
                btnMp2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(),"button pop up mp5 di klik", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(getContext(), BracketActivity.class);
                        i.putExtra("mp","mp5");
                        startActivity(i);
                    }
                });
                break;
            default:
                break;
        }
        dialog.show();
    }

    /*public ChecksheetFragment() {

    }*/

    /*protected RecyclerView mRecyclerView;
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
    }*/
}
