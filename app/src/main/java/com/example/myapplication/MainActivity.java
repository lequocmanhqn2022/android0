package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.transition.Slide;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<QuocGia> listQuocGia = khoitaoListQuocGia();
        Spinner spnView = findViewById(R.id.spn1);

        QuocGiaAdapter quocGiaAdapter = new QuocGiaAdapter(this, listQuocGia);
        spnView.setAdapter(quocGiaAdapter);
        spnView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Hello " + listQuocGia.get(i).ten, Toast.LENGTH_SHORT).show();
                ImageView bgMain = findViewById(R.id.bgMain);
                Glide.with(MainActivity.this).load(listQuocGia.get(i).hinh).into(bgMain);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    private ArrayList<QuocGia> khoitaoListQuocGia(){
        ArrayList<QuocGia> listQuocGia = new ArrayList<QuocGia>();
        listQuocGia.add(new QuocGia("https://cdn.britannica.com/41/4041-004-D051B135/Flag-Vietnam.jpg", "Việt Nam", 113));
        listQuocGia.add(new QuocGia("https://upload.wikimedia.org/wikipedia/commons/thumb/f/fa/Flag_of_the_People%27s_Republic_of_China.svg/640px-Flag_of_the_People%27s_Republic_of_China.svg.png", "China", 245));
        listQuocGia.add(new QuocGia("https://upload.wikimedia.org/wikipedia/commons/thumb/9/9a/Flag_of_Spain.svg/2560px-Flag_of_Spain.svg.png", "Spain", 654));
        listQuocGia.add(new QuocGia("https://upload.wikimedia.org/wikipedia/commons/thumb/f/ff/European_flag%2C_upside_down.svg/2700px-European_flag%2C_upside_down.svg.png", "Eu", 654));

        return listQuocGia;
    }
}