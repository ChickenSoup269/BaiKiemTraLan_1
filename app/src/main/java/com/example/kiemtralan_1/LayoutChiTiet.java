package com.example.kiemtralan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;


public class LayoutChiTiet extends AppCompatActivity {
    // LayoutChiTiet
    FloatingActionButton fab2;
    TextView txtMessageDetail, txtDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_chi_tiet);
        addControls();
        addEvents();
    }

    public void addControls(){
        fab2 = (FloatingActionButton) findViewById(R.id.fab2);
        txtMessageDetail = (TextView) findViewById(R.id.txtMessageDetail);
        txtDate = (TextView) findViewById(R.id.txtDate);
    }

    public void addEvents(){
        String messageContent = getIntent().getStringExtra( "message");
        String messageDate  = getIntent().getStringExtra("date");
        txtMessageDetail.setText(messageContent);
        txtDate.setText(messageDate);

        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onBackPressed();}
        });
    }

}