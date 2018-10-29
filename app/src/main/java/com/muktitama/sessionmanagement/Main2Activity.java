package com.muktitama.sessionmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    TextView tvEmail;
    Button buttonLogout,buttonDatabase;
    SessionManagement session;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        session = new SessionManagement(getApplicationContext());

        tvEmail = (TextView) findViewById(R.id.tvEmail);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);
        buttonDatabase = (Button) findViewById(R.id.buttonDatabase);

//        Toast.makeText(getApplicationContext(), "User Login Status: " + session.isLoggedIn(), Toast.LENGTH_LONG).show();

        session.checkIsLogin();

        HashMap<String, String> user = session.getUserInformation();

        String name = user.get(SessionManagement.KEY_EMAIL);

        tvEmail.setText(Html.fromHtml("Selamat Datang " + name));

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logoutUser();
            }
        });

        buttonDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToActivity();
            }
        });

    } private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(),InputDataKota.class);
        startActivity(mIntent);
    }

}
