package com.example.ibooking.Model;

import java.util.ArrayList;
import java.util.List;
/**
 * Hotel Model that store hotelID, address, city, rating, and list of room in a hotel
 */

public class HotelModel {
    private static final int NUMBER_SINGLE_ROOM = 5;
    private static final int NUMBER_DOUBLE_ROOM = 5;
    private static final int NUMBER_TRIPLE_ROOM = 5;

    private int hotelID;
    private String address;
    private String city;
    private double rating;
    private List<RoomInterface> roomList;

    /**
     * Constructs a HotelModel object with hotel ID, address, city, rating, and  list of room
     * @param hotelID hotel ID
     * @param address hotel address
     * @param city city
     * @param rating rating
     */
    public HotelModel(int hotelID, String address, String city, double rating){
        this.hotelID = hotelID;
        this.address = address;
        this.city = city;
        this.rating= rating;
        this.roomList = new ArrayList<RoomInterface>();
    }

    /**
     * Get List of room
     * @return list of room
     */
    public List<RoomInterface> getRoomList() {
        return roomList;
    }

    /**
     * Get id of hotel
     * @return id of hotel
     */
    public int getHotelID() {
        return hotelID;
    }

    /**
     * Get address of hotel
     * @return address of hotel
     */
    public String getAddress() {
        return address;
    }
    /**
     * Get city of hotel
     * @return city of hotel
     */
    public String getCity() {
        return city;
    }


    /**
     * Set rating of hotel
     * @param  rating
     */
    public void setRating(double rating)
    {
        this.rating = rating;
    }

    /**
     * Gets rating of hotel
     * @return rating of hotel
     */
    public double getRating() {
        return rating;
    }

    /**
     * Returns a String representation of HotelModel object
     * @return a String representation of HotelModel object
     */
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
