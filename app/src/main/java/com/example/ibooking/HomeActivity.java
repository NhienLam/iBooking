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

    private TextView userName, txt_reservation_address, txt_reservation_checkin, txt_reservation_checkout;
    private LinearLayout layoutUserInfo;
    private CardView cardViewBooking, cardViewCart, card_booking_info;
    private DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        userName = findViewById(R.id.txt_user_name);
        layoutUserInfo = findViewById(R.id.layout_user_information);
        cardViewBooking = findViewById(R.id.card_view_booking);
        cardViewCart = findViewById(R.id.card_view_cart);
        card_booking_info = findViewById(R.id.card_booking_info);
        txt_reservation_address = findViewById(R.id.txt_reservation_address);
        txt_reservation_checkin = findViewById(R.id.txt_reservation_checkin);
        txt_reservation_checkout = findViewById(R.id.txt_reservation_checkout);

        myDb = new DataBaseHelper(this);

        cardViewBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this , Search.class));
            }
        });
        setUserInformation();

        cardViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadBookingInfo();
            }
        });
    }

    private void setUserInformation()
    {
        userName.setText(Common.currentUser.getUserName());
    }

    private void loadBookingInfo()
    {
        txt_reservation_address.setText(Common.currentHotel.getAddress());
        txt_reservation_checkin.setText(Common.currentCheckin);
        txt_reservation_checkout.setText(Common.currentCheckout);
        if(card_booking_info.getVisibility()==View.VISIBLE)
        {
            card_booking_info.setVisibility(View.GONE);
        }
        else
        {
            card_booking_info.setVisibility(View.VISIBLE);
        }
    }
}
