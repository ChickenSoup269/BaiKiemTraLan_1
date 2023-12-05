package com.example.kiemtralan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String[] baitap = {"Bài 1"};
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    ImageView imgViewSinhVien;
    Button btnBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addEvents();
    }

    public void addControls(){
        imgViewSinhVien = (ImageView) findViewById(R.id.imgViewSinhVien);
        btnBlink = (Button) findViewById(R.id.btnBlink);
    }

    private void addEvents() {
        autoCompleteTextView = findViewById(R.id.autoComplete_tv);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_baitap, baitap);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adpterView, View view, int i, long l) {
                String baitap = adpterView.getItemAtPosition(i).toString();

                switch (baitap) {
                    case "Bài 1":
                        startActivity(new Intent(MainActivity.this, Bai1.class));
                        break;

                }
            }
        });
        btnBlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
                imgViewSinhVien.startAnimation(animation);
            }
        });

    }
}