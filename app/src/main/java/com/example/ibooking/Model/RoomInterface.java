package com.example.ibooking.Model;

public interface RoomInterface {
    int getRoomId();
    int getHotelId();
    String getRoomType();
    int getCapacity();
    double getPrice();
    boolean isAvailable();
    RoomInterface addService(RoomInterface room, Service newService);
}
