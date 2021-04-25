package com.ibooking.Model;

public class HotelModel {

    private int hotelID;
    private String address;
    private String zip;
    private double rating;

    public HotelModel( int hotelID, String address, String zip, double rating){
        this.hotelID = hotelID;
        this.address = address;
        this.zip = zip;
        this.rating= rating;
    }

    public int getHotelID() {
        return hotelID;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public void setRating() { this.rating = rating; }

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
