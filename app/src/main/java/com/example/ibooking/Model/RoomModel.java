package com.example.ibooking.Model;

/**
 * Hotel Room that stores room ID, hotel ID, type of room, capacity, price, and availability status
 */
public class RoomModel implements RoomInterface
{
    private int roomId;
    private int hotelId;
    private String roomType;
    private int capacity;
    private double price;
    private boolean isAvailable;

    /**
     * Constructs a RoomModel object with room ID, hotel ID, type of room, capacity, price, and availability status
     * @param roomId room ID
     * @param hotelId hotel ID that indicates which hotel this room belongs to
     * @param roomType type of room
     * @param capacity capacity
     * @param price price
     * @param isAvailable availability status
     */
    public RoomModel(int roomId, int hotelId, String roomType, int capacity, double price, boolean isAvailable) {
        this.roomId = roomId;
        this.hotelId = hotelId;
        this.roomType = roomType;
        this.capacity = capacity;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    /**
     * Returns a String representation of RoomModel object
     * @return a String representation of RoomModel object
     */
    @Override
    public String toString() {
        return "RoomModel{" +
                "Room ID =" + roomId +
                ", Hotel ID = '" + hotelId +
                ", Room Type = '" + roomType +
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
    public RoomInterface addService(RoomInterface room, String newService)
    {
        return room = new RoomExtraService(room, newService);
    }

    /**
     * Gets id of room
     * @return id of room
     */
    public int getRoomId() {
        return roomId;
    }

    /**
     * Gets hotel id
     * @return hotel id
     */
    public int getHotelId() {
        return hotelId;
    }

    /**
     * Sets hotel id
     * @param hotelId
     */
    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }


    /**
     * Gets room type
     * @return room type
     */
    @Override
    public String getRoomType() {
        return roomType;
    }

    /**
     * Sets room type
     * @param roomType
     */
    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    /**
     * Gets capacity of room
     * @return capacity of room
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Sets capacity of room
     * @param capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }


    /**
     * Gets price of room
     * @return price of room
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Sets price of room
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Gets availability status of the room
     * @return availability status of the room
     */
    public boolean isAvailable() {
        return isAvailable;
    }

    /**
     * Sets availability status of the room
     * @param available availability status of the room
     */
    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    // UNIT TEST : TEST addService()
 /*   public static void main(String[] args)
    {
        RoomInterface r1 = new RoomModel(1, 1,"Double", 2, 100, true);
        r1 = r1.addService(r1, Service.GYM);
        System.out.println(r1.getRoomType());
        System.out.println(r1.getPrice());
        r1 = r1.addService(r1, Service.BREAKFAST);
        System.out.println(r1.getRoomType());
        System.out.println(r1.getPrice());
        RoomInterface r2 = new RoomModel(2, 1,"Triple", 3, 150, true);
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
