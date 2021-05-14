package com.example.ibooking;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.example.ibooking.Common.Common;

/**
 * User Homepage where user can start booking and view reservations
 */
public class HomeActivity extends AppCompatActivity {

    private TextView userName, txt_reservation_address, txt_reservation_checkin, txt_reservation_checkout;
    private LinearLayout layoutUserInfo;
    private CardView cardViewBooking, cardViewCart, card_booking_info;
    private DataBaseHelper myDb;

    @Override
    /**
     * Is called when HomeActivity begins
     * Initializes instance variables and set onclick function for buttons
     */
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

        /**
         * When a Booking Button is clicked, goes to Search activity
         */
        cardViewBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this , Search.class));
            }
        });
        setUserInformation();

        /**
         * When a Reservations Button is clicked, displays/hides reservations that user made
         */
        cardViewCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadBookingInfo();
            }
        });
    }

    /**
     * Sets username of the current user
     */
    private void setUserInformation()
    {
        userName.setText(Common.currentUser.getUserName());
    }

    /**
     * Loads new booking information to the homepage including:
     * Hotel address
     * Check in and check out date
     */
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
