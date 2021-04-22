package com.ibooking.Model;

public class RoomModel implements RoomInterface
{
    //-ROOM_TABLE [id, RoomType, RoomNumber, Capacity, boolean isAvailable]
    private int id;
    private String roomType;
    private int roomNumber;
    private int capacity;
    private double price;
    private boolean isAvailable;

    //constructor
    public RoomModel(int id, String roomType, int roomNumber, int capacity, double price, boolean isAvailable) {
        this.id = id;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    // toString
    @Override
    public String toString() {
        return "RoomModel{" +
                "ID =" + id +
                ", Room Type = '" + roomType +
                ", Room Number = " + roomNumber +
                ", Capacity = " + capacity +
                ", Price = $" + price +
                ", IsAvailable = " + isAvailable +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
