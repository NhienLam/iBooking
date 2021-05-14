package com.example.ibooking.Common;

import com.example.ibooking.Model.HotelModel;
import com.example.ibooking.Model.ReservationModel;
import com.example.ibooking.Model.RoomInterface;
import com.example.ibooking.Model.RoomModel;
import com.example.ibooking.Model.UserModel;
import java.util.Date;

/**
 * Keeps track of current reservations and activities of  current user
 */
public class Common {
    public static UserModel currentUser;
    public static HotelModel currentHotel = new HotelModel(1, "2050 Gateway Pl, San Jose, CA 95110", "San Jose", 4);
    public static String currentCheckin;
    public static String currentCheckout;
    public static RoomInterface currentRoom;
    public static ReservationModel currentReservation;
}
