package com.fuber.fuberapp.pojo;

import java.util.Objects;

public class CabWithDistance {


    private Integer cabId;
    private String color;
    private Long longitude;
    private Long latitude;
    private Double distanceFromSource;

   public  CabWithDistance(){}
   public CabWithDistance(Cab cab){
       this.cabId=cab.getId();
       this.color=cab.getColor();
       this.longitude=cab.getCurrentLocation().getLongitude();
       this.latitude=cab.getCurrentLocation().getLatitude();
   }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CabWithDistance that = (CabWithDistance) o;
        return Objects.equals(cabId, that.cabId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cabId);
    }

    @Override
    public String toString() {
        return "CabWithDistance{" +
                "cabId=" + cabId +
                ", color='" + color + '\'' +
                ", longitude=" + longitude +
                ", latitude=" + latitude +
                ", distanceFromSource=" + distanceFromSource +
                '}';
    }

    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Long getLongitude() {
        return longitude;
    }

    public void setLongitude(Long longitude) {
        this.longitude = longitude;
    }

    public Long getLatitude() {
        return latitude;
    }

    public void setLatitude(Long latitude) {
        this.latitude = latitude;
    }

    public Double getDistanceFromSource() {
        return distanceFromSource;
    }

    public void setDistanceFromSource(Double distanceFromSource) {
        this.distanceFromSource = distanceFromSource;
    }
}


