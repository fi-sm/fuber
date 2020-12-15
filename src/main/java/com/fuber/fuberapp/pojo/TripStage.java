package com.fuber.fuberapp.pojo;

public class TripStage {
    private Long bookingId;
    private String stage;//booked/started/completed/suspended/cancel

    public Long getBookingId() {
        return bookingId;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage;
    }
}
