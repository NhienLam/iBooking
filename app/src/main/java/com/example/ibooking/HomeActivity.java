package com.example.ibooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.ibooking.Common.Common;

//import com.example.ibooking.Common.Common;

public class HomeActivity extends AppCompatActivity {

    private TextView userName;
    private LinearLayout layoutUserInfo;
    private CardView cardViewBooking, cardViewCart;
    private DataBaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userName = findViewById(R.id.txt_user_name);
        layoutUserInfo = findViewById(R.id.layout_user_information);
        cardViewBooking = findViewById(R.id.card_view_booking);
        cardViewCart = findViewById(R.id.card_view_cart);

        myDb = new DataBaseHelper(this);

        cardViewBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this , Search.class));
            }
        });
        setUserInformation();
    }

    private void setUserInformation()
    {
        userName.setText(Common.currentUser.getUserName());
    }

}
