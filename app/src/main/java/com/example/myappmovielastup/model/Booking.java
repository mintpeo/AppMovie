package com.example.myappmovielastup.model;

public class Booking {
    private int id;
    private String movieTitle;
    private String customerName;
    private String bookingDate;

    // Getters và setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", movieTitle='" + movieTitle + '\'' +
                ", customerName='" + customerName + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                '}';
    }
}
