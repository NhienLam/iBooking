package com.example.ibooking.Model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

class HotelModelTest {
HotelModel q = new HotelModel(1,"123 McDonald","Gotham",4.5);
    @Test
    void getRoomList() {
    }

    @Test
    void getHotelID() {
        assertEquals(1, q.getHotelID());
    }

    @Test
    void getAddress() {
        assertEquals("123 McDonald", q.getAddress());
    }

    @Test
    void getCity() {
        assertEquals("Gotham", q.getCity());
    }

    @Test
    void setRating() {
        q.setRating(4.2);
        assertEquals(4.2, q.getRating(),0);
    }

    @Test
    void getRating() {

        assertEquals(4.5, q.getRating(),0);
    }
}