package com.uas.fajar_rizki_nugraha_362389046;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ShowDataActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabeseHelper db;
    ArrayList<String> nim,name,program,noHp,email;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);

        recyclerView = findViewById(R.id.recyclerView);

        db  = new DatabeseHelper(ShowDataActivity.this);
        nim = new ArrayList<>();
        name = new ArrayList<>();
        program = new ArrayList<>();
        noHp = new ArrayList<>();
        email = new ArrayList<>();
        showData();
        adapter = new CustomAdapter(ShowDataActivity.this,this,nim,name,program,noHp,email);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(ShowDataActivity.this));

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void showData(){
        Cursor cursor = db.getAllData();

        if (cursor.getCount() == 0 ){
            Toast.makeText(this,"Belum ada data",Toast.LENGTH_SHORT).show();
        }else{

            while (cursor.moveToNext()){
                Log.d("hehe",cursor.getString(1));
                nim.add(cursor.getString(1));
//                name.add(cursor.getString(2));
//                nim.add(cursor.getString(3));
//                program.add(cursor.getString(4));
//                noHp.add(cursor.getString(5));
//                email.add(cursor.getString(6));

            }
        }
    }
}