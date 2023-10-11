package com.uas.fajar_rizki_nugraha_362389046;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class Edit extends AppCompatActivity {

    TextInputLayout eTNIM, eTName, etProgram, eTNoHp, eTmail;
    Button updateBtn;

    String id,nim,name,program,phone,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        eTNIM = findViewById(R.id.et_nim);
        eTName = findViewById(R.id.eTName);
        etProgram = findViewById(R.id.etProgram);
        eTNoHp = findViewById(R.id.eTNoHp);
        eTmail = findViewById(R.id.eTmail);
        updateBtn = findViewById(R.id.saveBtn);

        getIntentData();
        updateBtn.setOnClickListener(view -> {
            boolean valid = validation();

            if (valid){
                DatabeseHelper db = new DatabeseHelper(Edit.this);
                db.updateData(id,Long.parseLong(eTNIM.getEditText().getText().toString()),eTName.getEditText().getText().toString(),etProgram.getEditText().getText().toString(),Long.parseLong(eTNoHp.getEditText().getText().toString()),eTmail.getEditText().getText().toString());
                finish();
            }
        });
    }

    void getIntentData(){
        if (getIntent().hasExtra("nim") && getIntent().hasExtra("name") && getIntent().hasExtra("program") && getIntent().hasExtra("phone") && getIntent().hasExtra("email")){
            id = getIntent().getStringExtra("_id");
            nim = getIntent().getStringExtra("nim");
            name = getIntent().getStringExtra("name");
            program = getIntent().getStringExtra("program");
            phone = getIntent().getStringExtra("phone");
            email = getIntent().getStringExtra("email");

            eTNIM.getEditText().setText(nim);
            eTName.getEditText().setText(name);
            etProgram.getEditText().setText(program);
            eTNoHp.getEditText().setText(phone);
            eTmail.getEditText().setText(email);
        }else{
            Toast.makeText(Edit.this, "Tidak Ada Data!", Toast.LENGTH_SHORT).show();
        }
    }

    boolean validation() {
        if (eTNIM.getEditText().getText().length() == 0 || eTName.getEditText().getText().length() == 0 || etProgram.getEditText().getText().length() == 0 || eTNoHp.getEditText().getText().length() == 0) {
            Toast.makeText(Edit.this, "NIM, Nama, Program Studi dan Nomor Handphone Wajib diisi!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}