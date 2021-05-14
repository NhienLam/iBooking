package com.example.ibooking.Model;

/**
 * Decorator Design Pattern
 * Represents a Room with additional requested services
 */
public class RoomExtraService implements RoomInterface
{
    private RoomInterface room;
    private String service;
    private static final double PRICE = 10.00;

    /**
     * Constructs a room with a new service
     * @param room room to add service to
     * @param service new service
     */
    public RoomExtraService(RoomInterface room, String service)
    {
        this.room = room;
        this.service = service;
    }

    /**
     * Decorator Design Pattern
     * Add new service to the room
     * @param room the room to add
     * @param newService the new service to add
     * @return new RoomExtraService
     */
    public RoomInterface addService(RoomInterface room, String newService)
    {
        return room = new RoomExtraService(room, newService);
    }

    /**
     * Adds a price of the new service to the total price
     * @return a new price with the price of extra service added
     */
    @Override
    public double getPrice()
    {
        return room.getPrice() + PRICE;
    }

    /**
     * Adds a new service description
     * @return  description of the room with new service
     */
    @Override
    public String getRoomType()
    {
        return room.getRoomType() + " + " + service;
    }


    /**
     * Gets availability status of the room
     * @return availability status of the room
     */
    @Override
    public boolean isAvailable() {
        return room.isAvailable();
    }

    /**
     * Gets id of room
     * @return id of room
     */
    @Override
    public int getRoomId() {
        return room.getRoomId();
    }

    /**
     * Gets hotel id
     * @return hotel id
     */
    @Override
    public int getHotelId() {
        return room.getHotelId();
    }

    /**
     * Gets capacity of room
     * @return capacity of room
     */
    @Override
    public int getCapacity() {
        return room.getCapacity();
    }
}
