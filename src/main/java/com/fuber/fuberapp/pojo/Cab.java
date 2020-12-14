package com.fuber.fuberapp.pojo;

import java.util.Objects;

public class Cab {
    private Long longitude;
    private Long latitude;
    private Integer id;
    private String type;
    private String color;

    @Override
    public String toString() {
        return "Cab{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

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
}
