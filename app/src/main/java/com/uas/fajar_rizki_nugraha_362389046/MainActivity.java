package com.uas.fajar_rizki_nugraha_362389046;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText eTNIM,eTName,etProgram,eTNoHp,eTmail;
    Button saveBtn,showBtn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTNIM = findViewById(R.id.et_nim);
//        eTName =findViewById(R.id.eTName);
//        etProgram =findViewById(R.id.etProgram);
//        eTNoHp =findViewById(R.id.eTNoHp);
//        eTmail =findViewById(R.id.eTmail);
//        saveBtn =findViewById(R.id.saveBtn);
//        showBtn =findViewById(R.id.showBtn);

//        saveBtn.setOnClickListener(view -> {
//            DatabeseHelper db = new DatabeseHelper(MainActivity.this);
//            db.addData(Integer.parseInt(eTNIM.getText().toString()),eTName.getText().toString(),etProgram.getText().toString(),Integer.parseInt(eTNoHp.getText().toString()),eTmail.getText().toString());
//        });
//
//        showBtn.setOnClickListener(view -> {
//            Intent intent = new Intent(MainActivity.this,ShowDataActivity.class);
//            startActivity(intent);
//        });





    }
}