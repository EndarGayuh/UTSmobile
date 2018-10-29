package com.muktitama.sessionmanagement;

import android.app.Activity;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.muktitama.sessionmanagement.data.factory.AppDatabase;
import com.muktitama.sessionmanagement.model.Kota;

public class InputDataKota extends AppCompatActivity {

    private AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_kota);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class,"kotadb").build();

        final EditText etNamaKota = findViewById(R.id.et_namakota);
        final Button btSubmit = findViewById(R.id.bt_submit);
        final Button btSubmit2 = findViewById(R.id.bt_cek);

        final Kota kota = (Kota) getIntent().getSerializableExtra("data");

        if(kota!=null){
            etNamaKota.setText(kota.getNama_kota());

            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kota.setNama_kota(etNamaKota.getText().toString());


                    updateKota(kota);
                }
            });
        }

        else {
            btSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Kota k = new Kota();
                    k.setNama_kota(etNamaKota.getText().toString());

                    insertData(k);
                }
            });
        }

        btSubmit2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ReadDataKota.getActIntent(InputDataKota.this));
            }
        });
    }

    private void insertData(final Kota kota){
        new AsyncTask<Void, Void, Long>(){

            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.kotaDAO().insertKota(kota);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(InputDataKota.this,"Insert Sukses",Toast.LENGTH_SHORT).show();
            }
        }.execute();

        finish();
    }

    private void updateKota(final Kota kota) {
        new AsyncTask<Void,Void, Long>(){

            @Override
            protected Long doInBackground(Void... voids) {
                long status = db.kotaDAO().updateKota(kota);
                return status;
            }

            @Override
            protected void onPostExecute(Long status) {
                Toast.makeText(InputDataKota.this,"Update Sukses",Toast.LENGTH_SHORT).show();
            }
        }.execute();

        finish();
    }

}
