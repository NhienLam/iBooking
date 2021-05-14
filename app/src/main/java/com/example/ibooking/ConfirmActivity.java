package com.example.ibooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ibooking.Common.Common;
import com.example.ibooking.Model.ReservationModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Confirmation page that is the last step of booking
 * which display booking information that user makes to let user confirm
 * before making a reservation
 */
public class ConfirmActivity extends AppCompatActivity {

    private Button confirmButton;
    private TextView txt_hotel_address, txt_booking_checkin_date_text, txt_booking_checkout_date_text, txt_room_type_text, txt_price_text;

    @Override
    /**
     * Is called when ConfirmActivity begins
     * Initializes instance variables and set onclick function for buttons
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        confirmButton = findViewById(R.id.confirm_button);

        txt_hotel_address = findViewById(R.id.txt_hotel_address);
        txt_booking_checkin_date_text = findViewById(R.id.txt_booking_checkin_date_text);
        txt_booking_checkout_date_text = findViewById(R.id.txt_booking_checkout_date_text);
        txt_room_type_text = findViewById(R.id.txt_room_type_text);
        txt_price_text = findViewById(R.id.txt_price_text);

        /**
         * When a Confirm Button is clicked, displays a message and goes to HomeActivity
         */
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Unable to convert String mmmm-d-yyyy to localdate
                // Common.currentReservation = new ReservationModel( -1, Common.currentHotel.getHotelID(), Common.currentCheckin, Common.currentCheckout)
                Toast.makeText(ConfirmActivity.this, "Successfully made a reservation!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(ConfirmActivity.this , HomeActivity.class));
            }
        });
        setReservationInfo();
    }

    /**
     * Sets the booking information that use made in the booking process including:
     * Hotel address
     * Check in and check out date
     * Room type and extra services
     * Price per day
     */
    private void setReservationInfo()
    {
        txt_hotel_address.setText(Common.currentHotel.getAddress());
        txt_booking_checkin_date_text.setText("Check In: " + Common.currentCheckin);
        txt_booking_checkout_date_text.setText("Check Out: " + Common.currentCheckout);
        txt_room_type_text.setText("Room: " + Common.currentRoom.getRoomType());
        txt_price_text.setText(String.valueOf(Common.currentRoom.getPrice()) + "/day");
    }
}