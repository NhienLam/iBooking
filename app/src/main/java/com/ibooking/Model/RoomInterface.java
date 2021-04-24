package com.ibooking.Model;

public interface RoomInterface {
    int getId();
    String getRoomType();
    int getRoomNumber();
    int getCapacity();
    double getPrice();
    boolean isAvailable();
    RoomInterface addService(RoomInterface room, Service newService);
}
