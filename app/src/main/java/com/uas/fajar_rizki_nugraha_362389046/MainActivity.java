package com.uas.fajar_rizki_nugraha_362389046;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextInputLayout eTNIM, eTName, etProgram, eTNoHp, eTmail;
    Button saveBtn, showBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eTNIM = findViewById(R.id.et_nim);
        eTName = findViewById(R.id.eTName);
        etProgram = findViewById(R.id.etProgram);
        eTNoHp = findViewById(R.id.eTNoHp);
        eTmail = findViewById(R.id.eTmail);
        saveBtn = findViewById(R.id.saveBtn);
        showBtn = findViewById(R.id.showBtn);


        saveBtn.setOnClickListener(view -> {
            boolean valid = validation();

            if (valid){
                DatabeseHelper db = new DatabeseHelper(MainActivity.this);
                db.addData(Long.parseLong(eTNIM.getEditText().getText().toString()),eTName.getEditText().getText().toString(),etProgram.getEditText().getText().toString(),Long.parseLong(eTNoHp.getEditText().getText().toString()),eTmail.getEditText().getText().toString());
                eTNIM.getEditText().getText().clear();
                eTName.getEditText().getText().clear();
                etProgram.getEditText().getText().clear();
                eTNoHp.getEditText().getText().clear();
                eTmail.getEditText().getText().clear();
            }
        });

        showBtn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, ShowDataActivity.class);
            startActivity(intent);
        });
    }

    boolean validation() {
        if (eTNIM.getEditText().getText().length() == 0 || eTName.getEditText().getText().length() == 0 || etProgram.getEditText().getText().length() == 0 || eTNoHp.getEditText().getText().length() == 0) {
            Toast.makeText(MainActivity.this, "NIM, Nama, Program Studi dan Nomor Handphone Wajib diisi!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
