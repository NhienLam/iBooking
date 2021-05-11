package com.example.ibooking;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.ibooking.Common.Common;
import com.example.ibooking.Model.RoomDatabaseHelper;

public class RoomPicker extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    CheckBox cb1,cb2,cb3,cb4;
    private Button confirmButton;
    private RoomDatabaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_picker);

        confirmButton = findViewById(R.id.button4);
        myDb = new RoomDatabaseHelper(this);

        Spinner spinner = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.room_picker_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RoomPicker.this , DatePickerActivity.class));
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();
        //** Comment out if cannot **
//        Common.currentRoom = myDb.getRoomByHotelId_Type_IsAvailabble(Common.currentHotel.getHotelID(), text, true);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}