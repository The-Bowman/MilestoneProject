package com.example.milestoneproject;

public abstract class BaseContact {

    private String name;
    private String phone;
    private Location location;


    public BaseContact() {
        name = "Unknown";
        phone = "7998765";
    }

    public BaseContact(String name, String phone, Location location) {
        this.name = name;
        this.phone = phone;
        this.location = location;
    }


    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }




    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getPhone() {
        return phone;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Contact ID: " + "\n\tName: " + this.getName() + "\n\tPhone: " + this.getPhone() +
                 "\n\t" + location.toString();
    }





}
