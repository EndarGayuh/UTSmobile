package com.muktitama.sessionmanagement.adapter;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.muktitama.sessionmanagement.R;
import com.muktitama.sessionmanagement.ReadDataSingleActivity;
import com.muktitama.sessionmanagement.data.factory.AppDatabase;
import com.muktitama.sessionmanagement.model.Kota;

import java.util.ArrayList;

public class AdapterKotaRecyclerView  extends RecyclerView.Adapter<AdapterKotaRecyclerView.ViewHolder> {

    private ArrayList<Kota> daftarKota;
    private Context context;
    private AppDatabase db;

    public AdapterKotaRecyclerView(ArrayList<Kota> kotas, Context ctx) {
        this.daftarKota = kotas;
        this.context = ctx;

        db = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class,"kotadb").allowMainThreadQueries().build();
    }

    public AdapterKotaRecyclerView() {
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_kota, parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder,final int position) {

        final String name = daftarKota.get(position).getNama_kota();
        holder.tvTitle.setText(name);


    }

    @Override
    public int getItemCount() {
        return daftarKota.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        CardView cvMain;


        public ViewHolder(View v) {
            super(v);
            tvTitle = v.findViewById(R.id.tv_judulkota);
            cvMain = v.findViewById(R.id.cv_main);
        }
    }
}
