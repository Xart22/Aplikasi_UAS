package com.uas.fajar_rizki_nugraha_362389046;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DatabeseHelper extends SQLiteOpenHelper{
    private Context context;
    private static final  String DATABASE_NAME="DataMahasiswa.db";
    private static final  int DATABASE_VERSION=1;


    private static final  String TABLE_NAME="data_mahasiswa";
    private static final  String COLUMN_ID="_id";
    private static final  String COLUMN_NIM="nim";
    private static final  String COLUMN_NAME ="name";
    private static final  String COLUMN_PROGRAM_STUDY ="program_study";
    private static final  String COLUMN_NO_HP="no_hp";
    private static final  String COLUMN_EMAIL="email";

    public DatabeseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE data_mahasiswa " +
                "(_id INTEGER PRIMARY KEY AUTOINCREMENT,nim INTEGER,name TEXT, program_study TEXT,no_hp INTEGER,email TEXT);";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS data_mahasiswa");
        onCreate(db);
    }

    void addData(int nim,String name,String program,int noHp, String email){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NIM,nim);
        cv.put(COLUMN_NAME,name);
        cv.put(COLUMN_PROGRAM_STUDY,program);
        cv.put(COLUMN_NO_HP,noHp);
        cv.put(COLUMN_EMAIL,email);

        long result = db.insert(TABLE_NAME,null,cv);
        if (result == -1){
            Toast.makeText(context,"Failed",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(context,"Simpan Berhasil!",Toast.LENGTH_SHORT).show();
        }
    }

    Cursor getAllData(){
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor =null;
        if(db !=null){
            cursor =  db.rawQuery(query,null);
        }
        return  cursor;
    }
}
