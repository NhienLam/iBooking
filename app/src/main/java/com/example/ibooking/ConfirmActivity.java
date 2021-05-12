package com.example.ibooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ibooking.Common.Common;
import com.example.ibooking.Model.ReservationModel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class ConfirmActivity extends AppCompatActivity {

    private Button confirmButton;
    private TextView txt_hotel_address, txt_booking_checkin_date_text, txt_booking_checkout_date_text, txt_room_type_text, txt_price_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        confirmButton = findViewById(R.id.confirm_button);

        txt_hotel_address = findViewById(R.id.txt_hotel_address);
        txt_booking_checkin_date_text = findViewById(R.id.txt_booking_checkin_date_text);
        txt_booking_checkout_date_text = findViewById(R.id.txt_booking_checkout_date_text);
        txt_room_type_text = findViewById(R.id.txt_room_type_text);
        txt_price_text = findViewById(R.id.txt_price_text);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Unable to convert String mmmm-d-yyyy to localdate
                // Common.currentReservation = new ReservationModel( -1, Common.currentHotel.getHotelID(), Common.currentCheckin, Common.currentCheckout)
                startActivity(new Intent(ConfirmActivity.this , HomeActivity.class));
            }
        });
        setReservationInfo();
    }

    private void setReservationInfo()
    {
        txt_hotel_address.setText(Common.currentHotel.getAddress());
        txt_booking_checkin_date_text.setText(Common.currentCheckin);
        txt_booking_checkout_date_text.setText(Common.currentCheckout);
        txt_room_type_text.setText("Room: " + Common.currentRoom.getRoomType());
        txt_price_text.setText(String.valueOf(Common.currentRoom.getPrice()) + "/day");
    }
}