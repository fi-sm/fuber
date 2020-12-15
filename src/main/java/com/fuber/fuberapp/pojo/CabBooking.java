package com.fuber.fuberapp.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

public class CabBooking {

    private Long id;
    private Location sourceLocation;
    private Location destinationLocation;
    private Cab withCab;
    private LocalDateTime bookingTime;
    private LocalDateTime tripStartTime;
    private LocalDateTime tripEndTime;
    private String isCompleted; //booked/started/completed/suspended/cancel
    private String anyComment;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CabBooking that = (CabBooking) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Location getSourceLocation() {
        return sourceLocation;
    }

    public void setSourceLocation(Location sourceLocation) {
        this.sourceLocation = sourceLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public Cab getWithCab() {
        return withCab;
    }

    public void setWithCab(Cab withCab) {
        this.withCab = withCab;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    public void setBookingTime(LocalDateTime bookingTime) {
        this.bookingTime = bookingTime;
    }

    public LocalDateTime getTripStartTime() {
        return tripStartTime;
    }

    public void setTripStartTime(LocalDateTime tripStartTime) {
        this.tripStartTime = tripStartTime;
    }

    public LocalDateTime getTripEndTime() {
        return tripEndTime;
    }

    public void setTripEndTime(LocalDateTime tripEndTime) {
        this.tripEndTime = tripEndTime;
    }

    public String getIsCompleted() {
        return isCompleted;
    }

    public void setIsCompleted(String isCompleted) {
        this.isCompleted = isCompleted;
    }

    public String getAnyComment() {
        return anyComment;
    }

    public void setAnyComment(String anyComment) {
        this.anyComment = anyComment;
    }

    public static void main(String ar[]){
        LocalDateTime now=  LocalDateTime.now();
  try{
      Thread.sleep(1000);
  }catch (Exception e){
      e.printStackTrace();
  }
        LocalDateTime end= LocalDateTime.now();
System.out.println(Timestamp.valueOf(end).getTime()-Timestamp.valueOf(now).getTime());

    }

}
