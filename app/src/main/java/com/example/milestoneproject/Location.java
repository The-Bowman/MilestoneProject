package com.example.milestoneproject;

public class Location {

    String address;

    public Location() {

        address = "Unknown";

    }

    public Location(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Location{" +
                "address='" + address + '\'' +
                '}';
    }
}
