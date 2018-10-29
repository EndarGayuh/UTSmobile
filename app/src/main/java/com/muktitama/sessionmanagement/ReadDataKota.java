package com.muktitama.sessionmanagement;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.muktitama.sessionmanagement.adapter.AdapterKotaRecyclerView;
import com.muktitama.sessionmanagement.data.factory.AppDatabase;
import com.muktitama.sessionmanagement.model.Kota;

import java.util.ArrayList;
import java.util.Arrays;

public class ReadDataKota extends AppCompatActivity {

    private AppDatabase db;
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Kota> daftarKota;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_data_kota);

        daftarKota = new ArrayList<>();

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"kotadb").allowMainThreadQueries().build();

        rvView = findViewById(R.id.rv_main);
        rvView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        rvView.setLayoutManager(layoutManager);

        daftarKota.addAll(Arrays.asList(db.kotaDAO().selectAllKota()));

        adapter = new AdapterKotaRecyclerView(daftarKota,this);
        rvView.setAdapter(adapter);

    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity,ReadDataKota.class);
    }
}
