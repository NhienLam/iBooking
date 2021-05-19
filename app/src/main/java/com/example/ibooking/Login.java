package com.example.ibooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ibooking.Common.Common;
import com.example.ibooking.Model.UserModel;
/**
 * User Login where user can start type their username and password
 */
public class Login extends AppCompatActivity {

    private EditText loginUsername , loginPassword;
    private Button loginButton;
    private DataBaseHelper myDb;
    @Override
    /**
     * Is called when Login begins
     * Initializes instance variables and set onclick function for buttons
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername = findViewById(R.id.editTextTextPersonName);
        loginPassword = findViewById(R.id.editTextTextPersonName2);
        loginButton = findViewById(R.id.button3);

        myDb = new DataBaseHelper(this);

        loginUser();

    }

    /**
     * Collecting user's input for username and password
     * Veryfying them with data in database
     * Indicating if users login successfully
     */
    private void loginUser(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean var = myDb.checkUser(loginUsername.getText().toString() , loginPassword.getText().toString());
                if (var){
                    Common.currentUser = myDb.getUserByUsername(loginUsername.getText().toString());
                    Toast.makeText(Login.this, "Login Successfully", Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Login.this , HomeActivity.class));
                    finish();
                }else{
                    Toast.makeText(Login.this, "Login Failed !!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
