package com.example.ibooking.Model;
import java.util.ArrayList;
import java.util.List;

public class HotelModel {
    private static final int NUMBER_SINGLE_ROOM = 5;
    private static final int NUMBER_DOUBLE_ROOM = 5;
    private static final int NUMBER_TRIPLE_ROOM = 5;

    private int hotelID;
    private String address;
    private String zip;
    private double rating;
    private List<RoomInterface> roomList;


    public HotelModel(int hotelID, String address, String zip, double rating){
        this.hotelID = hotelID;
        this.address = address;
        this.zip = zip;
        this.rating= rating;
        this.roomList = new ArrayList<RoomInterface>();
    }

    //RoomModel(int id, int hotelId, String roomType, int roomNumber, int capacity, double price, boolean isAvailable)
    /**
     * Create rooms for this hotel
     * 5 SINGLE rooms with room number 1-5
     * 5 DOUBLE rooms with room number 6-10
     * 5 TRIPLE rooms with room number 11-15
     */
    public void createHotelRooms()
    {
        RoomInterface room;

        for(int i = 0; i < NUMBER_SINGLE_ROOM; i++)
        {
            room = new RoomModel(-1, this.hotelID, "SINGLE", i+1, 1, 100, true);
            this.roomList.add(room);
        }

        for(int i = 0; i < NUMBER_DOUBLE_ROOM; i++)
        {
            room = new RoomModel(-1, this.hotelID, "DOUBLE", i+6, 2, 120, true);
            this.roomList.add(room);
        }

        for(int i = 0; i < NUMBER_TRIPLE_ROOM; i++)
        {
            room = new RoomModel(-1, this.hotelID, "TRIPLE", i+11, 3, 150, true);
            this.roomList.add(room);
        }

        for(int i = 0 ; i<roomList.size();i++)
        {
            System.out.println(roomList.get(i).toString());
        }
    }

//    public static void main(String[] args)
//    {
//    	HotelModel hotel = new HotelModel(10, "1515 Oakland Road", "94653", 4.0);
//    	hotel.createHotelRooms();
//    }

    public int getHotelID() {
        return hotelID;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
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
                ", zip='" + zip + '\'' +
                ", rating=" + rating +
                '}';
    }
}
