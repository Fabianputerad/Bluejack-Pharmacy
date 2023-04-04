package com.example.projectasg;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;


public class HomeFragment extends Fragment {
    TextView mediTitle, mediManu, mediPrice;
    Adapter adapter;
    ArrayList<Medicine> medicineList;
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        mediTitle = view.findViewById(R.id.tv_medicineName);
        mediManu = view.findViewById(R.id.tv_medicineDesc);
        mediPrice = view.findViewById(R.id.tv_medicinePrice);
        recyclerView = view.findViewById(R.id.rvList);

        medicineList = new ArrayList<>();
        medicineList.add(new Medicine("Panadol", " lezat","20000"));
        medicineList.add(new Medicine("Hansaplast", "lezat","20000"));
        medicineList.add(new Medicine("Tolak Angin", "lezat","20000"));
        medicineList.add(new Medicine("Pil", "lezat","20000"));

        adapter = new Adapter(medicineList, this.getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapter);
        return view;
    }

}