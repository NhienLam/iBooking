package com.example.ibooking.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class ReservationModel {
    private int HotelId;
    private int id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    /**
     * Constructs a ReservationModel object with id, HotelAddress, checkInDate, checkOutDate
     */
    public ReservationModel (int id, int HotelId, LocalDate checkInDate, LocalDate checkOutDate){
        this.id = id;
        this.HotelId = HotelId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    //RESERVATION_TABLE [HotelId, id, CheckinDate, CheckoutDate]

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHotelId() {
        return HotelId;
    }

    public void setHotelAddress(int HotelId) {
        this.HotelId = HotelId;
    }

    public LocalDate getcheckInDate() {
        return checkInDate;
    }

    public void setcheckInDate (LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getcheckOutDate() {
        return checkInDate;
    }

    public void setcheckOutDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    /**
     * @return a String of Reservation model
     */
    public String toString() {
        return "ReservationModel" +
                "ID = " + id +
                ", HotelId = '" + HotelId +
                ", Check In Date = " + checkInDate +
                ", Check Out Date = " + checkOutDate +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args)
    {
        ReservationModel rev1 = new ReservationModel(1, 15, LocalDate.of(2021,12,12), LocalDate.of(2021,12,15));
        System.out.println(rev1.toString());
    }

    //expected output
    //ReservationModelID = 1, HotelAddress = 15, Check In Date = 2021-12-12, Check Out Date = 2021-12-15}
}
