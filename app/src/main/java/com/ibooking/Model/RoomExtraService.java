package com.ibooking.Model;

public class RoomExtraService implements RoomInterface
{
    private RoomInterface room;
    private String name;
    private static final double PRICE = 10.00;

    public RoomExtraService(RoomInterface room, String name)
    {
        this.room = room;
        this.name = name;
    }

    public double getPrice()
    {
        return room.getPrice() + PRICE;
    }

    public String getRoomType()
    {
        return room.getRoomType() + " + " + this.name;
    }
}
