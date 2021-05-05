package com.example.ibooking.Model;

public interface RoomInterface {
    int getId();
    int getHotelId();
    String getRoomType();
    int getRoomNumber();
    int getCapacity();
    double getPrice();
    boolean isAvailable();
    RoomInterface addService(RoomInterface room, Service newService);
}