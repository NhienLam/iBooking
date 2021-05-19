package com.example.ibooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/**
 * Connecting with Detail Activity
 * Direct users from Detail[age to Room[icker page  when user press a button.
 */
public class Detail extends AppCompatActivity {

    private Button BookingButton ;
    /**
     * Is called when DetailActivity begins
     * Initializes instance variables and set onclick function for buttons
     * Direct users to a new page when users press a button
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);
        BookingButton = findViewById(R.id.button);
        BookingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Detail.this , RoomPicker.class));
            }
        });
    }
}