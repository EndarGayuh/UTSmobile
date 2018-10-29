package com.muktitama.sessionmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtEmail, edtPassword;
    Button buttonLogin;

    SessionManagement sessionManagement;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtEmail = findViewById(R.id.editEmail);
        edtPassword = findViewById(R.id.editPassword);
        buttonLogin = findViewById(R.id.buttonLogin);

        sessionManagement = new SessionManagement(getApplicationContext());

//        if(sessionManagement.isLoggedIn()){
//            goToActivity();
//        }
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtEmail.getText().toString().length()==0){
                    edtEmail.setError("Harap Isi Username !");
                }

                else if(edtPassword.getText().toString().length()==0){
                    edtPassword.setError("Harap Isi Password !");
                }

                else {

                sessionManagement.createLoginSession(edtEmail.getText().toString(),edtPassword.getText().toString());
                goToActivity();
                }
            }
        });

    }

    private void goToActivity(){
        Intent mIntent = new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(mIntent);
    }

}
