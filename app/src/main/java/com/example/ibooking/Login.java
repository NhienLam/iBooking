package com.example.ibooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    private EditText loginUsername , loginPassword;
    private Button loginButton;
    private DataBaseHelper myDb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername = findViewById(R.id.editTextTextPersonName);
        loginPassword = findViewById(R.id.editTextTextPersonName2);
        loginButton = findViewById(R.id.button3);

        myDb = new DataBaseHelper(this);

        loginUser();

    }
    private void loginUser(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDb.checkUser(loginUsername.getText().toString() , loginPassword.getText().toString());
                if (var){
                    Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Login.this , HomeActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(Login.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }




}
