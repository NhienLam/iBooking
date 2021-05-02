package com.ibooking.Model;

import com.ibooking.MainActivity;

import java.util.ArrayList;
import java.util.List;

public class HotelModel {
    private static final int NUMBER_SINGLE_ROOM = 5;
    private static final int NUMBER_DOUBLE_ROOM = 5;
    private static final int NUMBER_TRIPLE_ROOM = 5;

    private int hotelID;
    private String address;
    private String city;
    private double rating;
    private List<RoomInterface> roomList;

    public HotelModel(int hotelID, String address, String city, double rating){
        this.hotelID = hotelID;
        this.address = address;
        this.city = city;
        this.rating= rating;
        this.roomList = new ArrayList<RoomInterface>();
    }

    /**
     * Create rooms for this hotel with the hotelId
     * 5 SINGLE rooms
     * 5 DOUBLE rooms
     * 5 TRIPLE rooms
     */
    public void createHotelRooms()
    {
        RoomInterface room;

        // RoomModel(int roomId, int hotelId, String roomType, int capacity, double price, boolean isAvailable)
        // create 5 SINGLE rooms
        for(int i = 0; i < NUMBER_SINGLE_ROOM; i++)
        {
            room = new RoomModel(-1, this.hotelID, "SINGLE", 1, 100, true);
            roomList.add(room);
        }
        // create 5 DOUBLE rooms
        for(int i = 0; i < NUMBER_DOUBLE_ROOM; i++)
        {
            room = new RoomModel(-1, this.hotelID, "DOUBLE", 2, 120, true);
            roomList.add(room);
        }
        // create 5 TRIPLE rooms
        for(int i = 0; i < NUMBER_TRIPLE_ROOM; i++)
        {
            room = new RoomModel(-1, this.hotelID, "TRIPLE", 3, 150, true);
            roomList.add(room);
        }
//        for(int i = 0 ; i<roomList.size();i++)
//        {
//            System.out.println(roomList.get(i).toString());
//        }
    }


    public List<RoomInterface> getRoomList() {
        return roomList;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public void setRating(double rating) 
    {
    	this.rating = rating; 
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "HotelModel{" +
                "hotelID='" + hotelID + '\'' +
                "address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", rating=" + rating +
                '}';
    }
}
