package com.ibooking.Model;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDate;

public class ReservationModel {
    private String HotelAddress;
    private int id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;

    /**
     * Constructs a ReservationModel object with id, HotelAddress, checkInDate, checkOutDate
     */
    public ReservationModel (int id, String HotelAddress, LocalDate checkInDate, LocalDate checkOutDate){
        this.id = id;
        this.HotelAddress = HotelAddress;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }
    //RESERVATION_TABLE [HotelAddress, id, CheckinDate, CheckoutDate]

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHotelAddress() {
        return HotelAddress;
    }

    public void setHotelAddress(String HotelAddress) {
        this.HotelAddress = HotelAddress;
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
                ", HotelAddress = '" + HotelAddress +
                ", Check In Date = " + checkInDate +
                ", Check Out Date = " + checkOutDate +
                '}';
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public static void main(String[] args)
    {
        ReservationModel rev1 = new ReservationModel(1, "123 Baker Street, 123123", LocalDate.of(2021,12,12), LocalDate.of(2021,12,15));
        System.out.println(rev1.toString());
    }

    //expected output
    //ReservationModelID = 1, HotelAddress = '123 Baker Street, 123123, Check In Date = 2021-12-12, Check Out Date = 2021-12-15}
}
