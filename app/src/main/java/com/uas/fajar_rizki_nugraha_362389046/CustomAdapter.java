package com.uas.fajar_rizki_nugraha_362389046;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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
    private ArrayList nim, name, program, noHp, email;

    CustomAdapter(Activity activity, Context context, ArrayList nim, ArrayList name, ArrayList program,
                  ArrayList noHp, ArrayList email) {
        this.activity = activity;
        this.context = context;
        this.nim = nim;
        this.name = name;
        this.program = program;
        this.noHp = email;
        this.email = email;

        Log.d(TAG, "CustomAdapter: " + nim);
        Log.d(TAG, "CustomAdapter: " + name);
        Log.d(TAG, "CustomAdapter: " + program);
        Log.d(TAG, "CustomAdapter: " + noHp);
        Log.d(TAG, "CustomAdapter: " + email);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.mahasiwa_container, parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, int position) {
//        holder.tvNim.setText(String.valueOf(nim.get(position)));
//        holder.tvName.setText(String.valueOf(name.get(position)));
//        holder.tvProgram.setText(String.valueOf(program.get(position)));
//        holder.tvPhone.setText(String.valueOf(noHp.get(position)));
//        holder.tvEmail.setText(String.valueOf(email.get(position)));
        // Recyclerview onClickListener
//        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(context, UpdateActivity.class);
//                intent.putExtra("id", String.valueOf(book_id.get(position)));
//                intent.putExtra("title", String.valueOf(book_title.get(position)));
//                intent.putExtra("author", String.valueOf(book_author.get(position)));
//                intent.putExtra("pages", String.valueOf(book_pages.get(position)));
//                activity.startActivityForResult(intent, 1);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return nim.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvNim, tvName, tvProgram, tvPhone, tvEmail;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNim = itemView.findViewById(R.id.tvNim);
            tvName = itemView.findViewById(R.id.tvName);
            tvProgram = itemView.findViewById(R.id.tvProgram);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvEmail = itemView.findViewById(R.id.tvEmail);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }

    }
}
