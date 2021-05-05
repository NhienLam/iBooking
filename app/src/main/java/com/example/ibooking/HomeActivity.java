//package com.example.ibooking;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//
//public class HomeActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home2);
//    }
//}

package com.example.ibooking;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
    }
}
