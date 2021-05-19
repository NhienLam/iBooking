package com.example.ibooking;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;

import java.util.ArrayList;
/**
 * Search  where user can select city and location
 */
public class Search extends AppCompatActivity {
    Spinner sp_city,sp_location;
    ArrayList<String> arrayList_city;
    ArrayAdapter<String> arrayAdapter_city;
    ArrayList<String> arrayList_sj;
    ArrayList<String> arrayList_ny;
    ArrayList<String> arrayList_la;
    Button select;
    ArrayAdapter<String> arrayAdapter_location;
    @SuppressLint("WrongViewCast")
    @Override
    /**
     * Is called when Search begins
     * Initializes instance variables and set onclick function for buttons
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        sp_city=(Spinner)findViewById(R.id.citysp);
        sp_location=(Spinner)findViewById(R.id.locationsp);
        arrayList_city = new ArrayList<>();
        arrayList_city.add("San Jose");
        arrayList_city.add("New York");
        arrayList_city.add("Los Angeles");

        arrayAdapter_city =new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_city);
        sp_city.setAdapter((SpinnerAdapter) arrayAdapter_city);

        arrayList_sj = new ArrayList<>();
        arrayList_sj.add("2050 Gateway Pl, San Jose, CA 95110");
        arrayList_sj.add("1355 N 4th St, San Jose, CA 95112");
        arrayList_sj.add("656 America Center Ct, San Jose, CA 95002");

        arrayList_ny = new ArrayList<>();
        arrayList_ny.add("44 W 29th St, New York, NY 10001 ");
        arrayList_ny.add("137 W 111th St, New York, NY 10026  ");
        arrayList_ny.add("870 7th Ave, New York, NY 10019  ");

        arrayList_la = new ArrayList<>();
        arrayList_la.add("813 Flower St, Los Angeles, CA 90017 ");
        arrayList_la.add("5400 W Century Blvd, Los Angeles, CA 90045");
        arrayList_la.add("416 W 8th St, Los Angeles, CA 90014 ");
        select = findViewById(R.id.button10);

       select.setOnClickListener(new View.OnClickListener() {
            @Override
            /**
             * Redirect users from search page to detail page
             */
            public void onClick(View v) {
                startActivity(new Intent(Search.this , Detail.class));
            }
        });


        sp_city.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            /**
             * Users select a city
             * Return an array of location based on the city
             */
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    arrayAdapter_location = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_sj);
                }
                if(position==1)
                {
                    arrayAdapter_location = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_ny);
                }
                if(position==2)
                {
                    arrayAdapter_location = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_la);
                }

                sp_location.setAdapter((SpinnerAdapter) arrayAdapter_location);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}