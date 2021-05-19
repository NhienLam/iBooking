package com.example.ibooking.Model;

import junit.framework.TestCase;

public class RoomExtraServiceTest extends TestCase {
    RoomInterface r = new RoomModel(1, 1, "Double", 2, 100, true);

    public void testAddService() {
        r = r.addService(r, "GYM");
        assertEquals(110.0, r.getPrice());
    }

    public void testGetPrice() {
        assertEquals(100.0, r.getPrice());
    }

    public void testGetRoomType() {
        assertEquals("Double", r.getRoomType());
    }

    public void testIsAvailable() {
        assertEquals(true, r.isAvailable());
    }

    public void testGetRoomId() {
        assertEquals(1, r.getRoomId());
    }

    public void testGetHotelId() {
        assertEquals(1, r.getHotelId());
    }

    public void testGetCapacity() {
        assertEquals(2, r.getCapacity());
    }
}