package com.example.ibooking.Model;

/**
 * A simple Hotel Room
 */
public interface RoomInterface {
    /**
     * Gets id of room
     * @return id of room
     */
    int getRoomId();
    
    /**
     * Gets hotel id
     * @return hotel id
     */
    int getHotelId();
    
    /**
     * Gets room type
     * @return room type
     */
    String getRoomType();
    
    /**
     * Gets capacity of room
     * @return capacity of room
     */
    int getCapacity();
    
    /**
     * Gets price of room
     * @return price of room
     */
    double getPrice();
    
    /**
     * Gets availability status of the room
     * @return availability status of the room
     */
    boolean isAvailable();
    
    /**
     * Add an extra service to the room reservation using Decorator Design Pattern
     * @param room the target room
     * @param newService the extra service to add
     */
    RoomInterface addService(RoomInterface room, String newService);
}
