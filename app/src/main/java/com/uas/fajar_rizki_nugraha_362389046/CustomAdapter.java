package com.uas.fajar_rizki_nugraha_362389046;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    private static final String TAG = "CustomAdapter";
    private Context context;
    private Activity activity;
    private ArrayList id, nim, name, program, noHp, email;

    CustomAdapter(Activity activity, Context context,ArrayList id, ArrayList nim, ArrayList name, ArrayList program,
                  ArrayList noHp, ArrayList email) {
        this.activity = activity;
        this.context = context;
        this.id = id;
        this.nim = nim;
        this.name = name;
        this.program = program;
        this.noHp = noHp;
        this.email = email;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.mahasiwa_container, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
          holder.tvNim.setText(String.valueOf(nim.get(position)));
          holder.tvName.setText(String.valueOf(name.get(position)));
          holder.tvProgram.setText(String.valueOf(program.get(position)));
          holder.tvPhone.setText(String.valueOf(noHp.get(position)));
          holder.tvEmail.setText(String.valueOf(email.get(position)));
        // Recyclerview onClickListener
        holder.editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Edit.class);
                intent.putExtra("_id", String.valueOf(id.get(position)));
                intent.putExtra("nim", String.valueOf(nim.get(position)));
                intent.putExtra("name", String.valueOf(name.get(position)));
                intent.putExtra("program", String.valueOf(program.get(position)));
                intent.putExtra("phone", String.valueOf(noHp.get(position)));
                intent.putExtra("email", String.valueOf(email.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });

        holder.deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmDialog(String.valueOf(id.get(position)));
            }
        });
    }

    void confirmDialog(String _id){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Komfirmasi hapus");
        builder.setMessage("Apakah yakin akan dihapus ?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                DatabeseHelper myDB = new DatabeseHelper(context);
                myDB.deleteOneRow(String.valueOf(_id));
                activity.recreate();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

    @Override
    public int getItemCount() {
        return nim.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvNim, tvName, tvProgram, tvPhone, tvEmail;
        Button editBtn,deleteBtn;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvName = itemView.findViewById(R.id.tvName);
            tvProgram = itemView.findViewById(R.id.tvProgram);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            editBtn = itemView.findViewById(R.id.btnEdit);
            deleteBtn = itemView.findViewById(R.id.btnDelete);
        }

    }
}
