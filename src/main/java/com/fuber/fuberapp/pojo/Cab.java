package com.fuber.fuberapp.pojo;

import java.util.Objects;

public class Cab {
    private Integer id;
    private String type;
    private String color;
    private String brand;
    private String isAvailable;
    private String registrationNumber;//numberPlate
    private Location currentLocation;




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cab cab = (Cab) o;
        return Objects.equals(id, cab.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cab{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                ", brand='" + brand + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", currentLocation=" + currentLocation +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }
}
