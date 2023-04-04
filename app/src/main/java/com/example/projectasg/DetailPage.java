package com.example.projectasg;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailPage extends AppCompatActivity {

    Medicine medicine;
    TextView NamaObat, deskripsi;
    EditText quantity;
    Button submit;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        NamaObat = findViewById(R.id.txtView_detail);
        deskripsi = findViewById(R.id.deskripsi);
        quantity = findViewById(R.id.edt_detail);
        submit = (Button) findViewById(R.id.submit_btn);
        medicine = (Medicine) getIntent().getSerializableExtra("medi");

        NamaObat.setText(medicine.getName());
    }

};