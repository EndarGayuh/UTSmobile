package com.muktitama.sessionmanagement;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.muktitama.sessionmanagement.model.Kota;

public class ReadDataSingleActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data_kota);

        EditText etJudul = findViewById(R.id.et_namakota);

        Button btSubmit = findViewById(R.id.bt_submit);

        etJudul.setEnabled(false);

        btSubmit.setVisibility(View.GONE);

        Kota kota = (Kota) getIntent().getSerializableExtra("data");
        if(kota!=null){
            etJudul.setText(kota.getNama_kota());

        }
    }

    public static Intent getActIntent(Activity activity){
        return new Intent(activity,ReadDataSingleActivity.class);
    }
}
