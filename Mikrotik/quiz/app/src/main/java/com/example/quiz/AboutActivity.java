package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.example.quiz.databinding.ActivityAboutBinding;

import java.util.ArrayList;

public class AboutActivity extends AppCompatActivity {

    ActivityAboutBinding binding;
    ListAdapter listAdapter;
    ArrayList<ListData> dataArrayList = new ArrayList<>();
    ListData listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAboutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int[] imageList = {
                R.drawable.sofia_refaldi, R.drawable.yuliana, R.drawable.ka_rapiyah
        };

        int[] ingredientList = {
                R.string.faldi, R.string.yuli, R.string.fiyah
        };

        int[] descList = {
                R.string.anggota1, R.string.ketua, R.string.anggota2
        };

        String[] nameList = {
                "Sopia Refaldi", "Yuliana", "Rapiyah Hawa Nur"
        };

        String[] timeList = {
                "Anggota", "Ketua", "Anggota"
        };

        for (int i = 0; i < imageList.length; i++) {
            listData = new ListData(nameList[i], timeList[i], ingredientList[i], descList[i], imageList[i]);
            dataArrayList.add(listData);
        }

        listAdapter = new ListAdapter(AboutActivity.this, dataArrayList);
        binding.listview.setAdapter(listAdapter);
        binding.listview.setClickable(true);
        binding.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(AboutActivity.this, AboutDetail.class);
                intent.putExtra("name", nameList[i]);
                intent.putExtra("time", timeList[i]);
                intent.putExtra("ingredients", ingredientList[i]);
                intent.putExtra("desc", descList[i]);
                intent.putExtra("image", imageList[i]);
                startActivity(intent);
            }
        });
    }
}
