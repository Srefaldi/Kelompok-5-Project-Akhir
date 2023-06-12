package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
public class MateriActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<DataClass> dataList;
    MyAdapter adapter;
    DataClass androidData;
    SearchView searchView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.materi_activity);
        recyclerView = findViewById(R.id.recyclerView);
        searchView = findViewById(R.id.search);
        searchView.clearFocus();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                searchList(newText);
                return true;
            }
        });
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MateriActivity.this, 1);
        recyclerView.setLayoutManager(gridLayoutManager);
        dataList = new ArrayList<>();
        androidData = new DataClass("Mikrotik", R.string.mikrotik, "Pendahuluan", R.drawable.mikrotik);
        dataList.add(androidData);
        androidData = new DataClass("Sejarah Mikrotik", R.string.sejarahmikrotik, "Pengertian", R.drawable.sejarah_mikrotik);
        dataList.add(androidData);
        androidData = new DataClass("Jenis Mikrotik", R.string.jenismikrotik, "Jenis", R.drawable.macam_mikrotik);
        dataList.add(androidData);
        androidData = new DataClass("Dasar-Dasar Jaringan", R.string.DasarJaringan, "Pengertian", R.drawable.dasar_jaringan);
        dataList.add(androidData);
        androidData = new DataClass("Konsep Jaringan Wireless", R.string.konsepjaringanwireless, "Konsep", R.drawable.konsep_jaringan);
        dataList.add(androidData);
        androidData = new DataClass("Jaringan Wireless", R.string.jaringanwireless, "Pengertian", R.drawable.jaringan);
        dataList.add(androidData);
        androidData = new DataClass("Konfigurasi Mikrotik", R.string.konfigurasimikrotik, "Tutorial", R.drawable.konfigurasi_mikrotik);
        dataList.add(androidData);

        adapter = new MyAdapter(MateriActivity.this, dataList);
        recyclerView.setAdapter(adapter);
    }
    private void searchList(String text){
        List<DataClass> dataSearchList = new ArrayList<>();
        for (DataClass data : dataList){
            if (data.getDataTitle().toLowerCase().contains(text.toLowerCase())) {
                dataSearchList.add(data);
            }
        }
        if (dataSearchList.isEmpty()){
            Toast.makeText(this, "Not Found", Toast.LENGTH_SHORT).show();
        } else {
            adapter.setSearchList(dataSearchList);
        }
    }
}