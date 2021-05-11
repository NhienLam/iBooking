package com.example.ibooking.Model;

public class RoomExtraService implements RoomInterface
{
    private RoomInterface room;
    private Service service;
    private static final double PRICE = 10.00;

    public RoomExtraService(RoomInterface room, Service service)
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
    public RoomInterface addService(RoomInterface room, Service newService)
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

    @Override
    public boolean isAvailable() {
        return room.isAvailable();
    }

    @Override
    public int getRoomId() {
        return room.getRoomId();
    }

    @Override
    public int getHotelId() {
        return room.getHotelId();
    }

    @Override
    public int getCapacity() {
        return room.getCapacity();
    }
}
