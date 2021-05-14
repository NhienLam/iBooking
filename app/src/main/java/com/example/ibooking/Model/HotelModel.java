package com.example.ibooking.Model;

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
