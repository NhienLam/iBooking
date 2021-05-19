package com.example.ibooking.Model;

import junit.framework.TestCase;

public class RoomModelTest extends TestCase {
    RoomInterface r = new RoomModel(1, 1, "Double", 2, 100, true);

    public void testAddService() {
        r = r.addService(r, "GYM");
        assertEquals(110.0, r.getPrice());
    }

    public void testGetRoomId() {
        assertEquals(1, r.getRoomId());
    }

    public void testGetHotelId() {
        assertEquals(1, r.getHotelId());
    }

    public void testGetRoomType() {
        assertEquals("Double", r.getRoomType());
    }

    public void testGetCapacity() {
        assertEquals(2, r.getCapacity());
    }

    public void testGetPrice() {
        assertEquals(100.0, r.getPrice());
    }

    public void testIsAvailable() {
        assertEquals(true, r.isAvailable());
    }
}
