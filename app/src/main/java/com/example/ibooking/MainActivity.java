package com.example.ibooking;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.os.Bundle;
/**
 * User Login where user can start type their username and password
 */
public class MainActivity extends AppCompatActivity {

    private Button loginButton , signUpButton;
    @Override

    /**
     * Is called when MainActivity begins
     * Initializes instance variables and set onclick function for buttons
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginButton = findViewById(R.id.button1);
        signUpButton = findViewById(R.id.button2);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //Redirect users to login page
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , Login.class));
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            //Redirect users to signup page
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this , Signup.class));
            }
        });

    }
}