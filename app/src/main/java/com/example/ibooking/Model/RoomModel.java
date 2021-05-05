package com.example.ibooking.Model;

public class RoomModel implements RoomInterface
{
    private int id;
    private int hotelId;
    private String roomType;
    private int roomNumber;
    private int capacity;
    private double price;
    private boolean isAvailable;

    /**
     * Constructs a RoomModel object with ID, hotelId, RoomType, RoomNumber, Capacity, Price, isAvailable
     */
    public RoomModel(int id, int hotelId, String roomType, int roomNumber, int capacity, double price, boolean isAvailable) {
        this.id = id;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.roomNumber = roomNumber;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    /**
     * @return a String representation of RoomModel object
     */
    @Override
    public String toString() {
        return "RoomModel{" +
                "ID =" + id +
                ", Hotel ID = " + hotelId +
                ", Room Type = " + roomType +
                ", Room Number = " + roomNumber +
                ", Capacity = " + capacity +
                ", Price = $" + price +
                ", IsAvailable = " + isAvailable +
                '}';
    }

    /**
     * Add an extra service to the room reservation using Decorator Design Pattern
     * @param room the target room
     * @param newService the extra service to add
     */
    public RoomInterface addService(RoomInterface room, Service newService)
    {
        return room = new RoomExtraService(room, newService);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
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

    // UNIT TEST : TEST addService()
 /*   public static void main(String[] args)
    {
        RoomInterface r1 = new RoomModel(1, 1,"Double", 12, 2, 100, true);
        r1 = r1.addService(r1, Service.GYM);
        System.out.println(r1.getRoomType());
        System.out.println(r1.getPrice());
        r1 = r1.addService(r1, Service.BREAKFAST);
        System.out.println(r1.getRoomType());
        System.out.println(r1.getPrice());
        RoomInterface r2 = new RoomModel(2, 1,"Triple", 122, 3, 150, true);
        System.out.println(r2.getRoomType());
        System.out.println(r2.getPrice());
*/
        /* Expected Output:
            Double + GYM
            110.0
            Double + GYM + BREAKFAST
            120.0
            Triple
            150.0
    }*/
}