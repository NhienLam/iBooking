package com.example.ibooking.Model;

import junit.framework.TestCase;

import java.time.LocalDate;

public class ReservationModelTest extends TestCase {

    ReservationModel r = new ReservationModel(1, 15, LocalDate.of(2021,12,12), LocalDate.of(2021,12,15));
    public void testGetId() {
        assertEquals(1, r.getId());
    }

    public void testSetId() {
        r.setId(2);
        assertEquals(2, r.getId());
    }

    public void testGetHotelId() {
        assertEquals(15, r.getHotelId());
    }

    public void testSetHotelAddress() {
        r.setHotelAddress(69);
        assertEquals(69, r.getHotelId());
    }

    public void testGetcheckInDate() {
        assertEquals(LocalDate.of(2021,12,12), r.getcheckInDate());
    }

    public void testSetcheckInDate() {
        r.setcheckInDate(LocalDate.of(2021,9,9));
        assertEquals(LocalDate.of(2021,9,9), r.getcheckInDate());
    }

    public void testGetcheckOutDate() {
        assertEquals(LocalDate.of(2021,12,15), r.getcheckOutDate());
    }

    public void testSetcheckOutDate() {
        r.setcheckOutDate(LocalDate.of(2021,9,9));
        assertEquals(LocalDate.of(2021,9,9), r.getcheckOutDate());
    }
}