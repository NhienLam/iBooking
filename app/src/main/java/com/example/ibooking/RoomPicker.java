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
import com.example.ibooking.Model.RoomExtraService;
import com.example.ibooking.Model.RoomInterface;
import com.example.ibooking.Model.RoomModel;

import java.util.ArrayList;

/**
 * Room picker page where user can start booking their rooms
 */
public class RoomPicker extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private CheckBox cb1,cb2,cb3,cb4;
    private Button confirmButton;
    private RoomDatabaseHelper myDb;
    private ArrayList<String> service;

    @Override
     /**
     * Is called when RoomPicker begins
     * Initializes instance variables and set onclick function for buttons
     */
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_picker);

        confirmButton = findViewById(R.id.button4);
        myDb = new RoomDatabaseHelper(this);
        cb1 = findViewById(R.id.checkBox);
        cb2 = findViewById(R.id.checkBox2);
        cb3 = findViewById(R.id.checkBox3);
        cb4 = findViewById(R.id.checkBox4);
        service = new ArrayList<>();

        /**
        * When spinner is click show all room options
        */
        Spinner spinner = findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.room_picker_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        createRoomsDB();

        /**
         * When Confirm Button is clicked, adds additional services that user chose to the room
         * Goes to DatePickerActivity
         */
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb1.isChecked()) {
                    service.add(cb1.getText().toString());
                }
                if(cb2.isChecked()) {
                    service.add(cb2.getText().toString());
                }
                if(cb3.isChecked()) {
                    service.add(cb3.getText().toString());
                }
                if(cb4.isChecked()) {
                    service.add(cb4.getText().toString());
                }
                Toast.makeText(RoomPicker.this, service.toString(), Toast.LENGTH_SHORT).show();

                /**
                 * DECORATOR DESIGN PATTERN
                 */
                for(String s : service)
                {
                    Common.currentRoom  = new RoomExtraService( Common.currentRoom , s);
                }

                startActivity(new Intent(RoomPicker.this , DatePickerActivity.class));
            }
        });
    }

    /**
    * Displayed popup after a room is selected
    */
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text, Toast.LENGTH_SHORT).show();

        Common.currentRoom  = myDb.getRoomByHotelId_Type_IsAvailable(Common.currentHotel.getHotelID(), text, true);
    }

    /**
     * Create rooms for this hotel in database
     * 5 SINGLE rooms
     * 5 DOUBLE rooms
     * 5 TRIPLE rooms
     */
    public void createRoomsDB()
    {
        ArrayList<RoomInterface> rooms = new ArrayList<>();
        RoomInterface r;
        try{
            for(int i = 0; i < 5; i++)
            {
                r = new RoomModel(-1, Common.currentHotel.getHotelID(), "SINGLE", 1, 100, true);
                rooms.add(r);
            }
            for(int i = 0; i < 5; i++)
            {
                r = new RoomModel(-1, Common.currentHotel.getHotelID(), "DOUBLE", 2, 120, true);
                rooms.add(r);
            }
            for(int i = 0; i < 5; i++)
            {
                r = new RoomModel(-1, Common.currentHotel.getHotelID(), "TRIPLE", 3, 150, true);
                rooms.add(r);
            }
        }
        catch (Exception e){
            r = new RoomModel(-1, -1, "error", -1, -1, false);
            rooms.add(r);
        }
        for(RoomInterface ri : rooms)
        {
            myDb.insertRoom(ri);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
