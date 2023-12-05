package com.example.kiemtralan_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Bai1 extends AppCompatActivity {
    // Bài1
    FloatingActionButton fab1;
    ListView lstViewNganHang;
    List<BankMessage> messages;
    Button btnNhanTien, btnTruTien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        addControls();
        addEvents();
    }

    public void addControls(){
        fab1 = (FloatingActionButton) findViewById(R.id.fab1);
        lstViewNganHang =  (ListView) findViewById(R.id.lstViewNganHang);
        btnNhanTien = (Button) findViewById(R.id.btnNhanTien);
        btnTruTien = (Button) findViewById(R.id.btnTruTien);
    }

    public void addEvents(){
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {onBackPressed();}
        });
        messages = generateDummyData();
        messages.sort(Collections.reverseOrder());


        MessageAdapter adapter = new MessageAdapter(this, R.layout.list_item, messages);
        lstViewNganHang.setAdapter(adapter);


        lstViewNganHang.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(this, LayoutChiTiet.class);
            intent.putExtra("message", messages.get(position).getContent());
            startActivity(intent);

            overridePendingTransition(R.anim.slide_right, R.anim.slide_right);
        });

        btnNhanTien.setOnClickListener(v -> filterMessages(true));
        btnTruTien.setOnClickListener(v -> filterMessages(false));
    }

    private void filterMessages(boolean isReceived) {
        List<BankMessage> filteredMessages = new ArrayList<>();
        for (BankMessage message : messages) {
            if (message.isReceived() == isReceived) {
                filteredMessages.add(message);
            }
        }

        MessageAdapter adapter = new MessageAdapter(this, R.layout.list_item, filteredMessages);
        lstViewNganHang.setAdapter(adapter);
    }

    private List<BankMessage> generateDummyData() {
        List<BankMessage> dummyData = new ArrayList<>();
        dummyData.add(new BankMessage("02.11.2023", "[CO] +10.000.000 VND", true));
        dummyData.add(new BankMessage("03.11.2023", "[NO] -5.000.000 VND", false));
        dummyData.add(new BankMessage("04.11.2023", "[CO] +8.000.000 VND", true));
        dummyData.add(new BankMessage("05.11.2023", "[NO] -3.000.000 VND", false));

        return dummyData;
    }
}