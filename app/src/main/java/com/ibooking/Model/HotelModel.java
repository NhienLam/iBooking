package com.ibooking.Model;

public class HotelModel {
    private String address;
    private String zip;
    private double rating;

    public HotelModel( String address, String zip, double rating){
        this.address = address;
        this.zip = zip;
        this.rating= rating;
    }

    public String getAddress() {
        return address;
    }

    public String getZip() {
        return zip;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "HotelModel{" +
                "address='" + address + '\'' +
                ", zip='" + zip + '\'' +
                ", rating=" + rating +
                '}';
    }
}
