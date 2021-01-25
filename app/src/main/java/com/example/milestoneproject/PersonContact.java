package com.example.milestoneproject;

import android.app.Person;
import android.provider.Contacts;

import java.util.Comparator;

public class PersonContact extends BaseContact {

    private int id;
    private int dateOfBirth;
    private String description;
    private String imageURL;


    public PersonContact() {
        super();
        id = 0;
        description = "Unknown";
        imageURL = "https://style.anu.edu.au/_anu/4/images/placeholders/person.png";

    }

    public PersonContact(int id, String name, String phone, Location location, String imageURL) {
        super(name, phone, location);
        this.id = id;
        this.description = description;
        this.imageURL = imageURL;
    }

    public PersonContact(int id, String name, String phone, Location location) {
        super(name, phone, location);
        this.id = id;
        this.imageURL ="https://style.anu.edu.au/_anu/4/images/placeholders/person.png";
    }

    public PersonContact(int id, String name, String phone){
        super(name, phone);
        this.id = id;
        this.imageURL ="https://style.anu.edu.au/_anu/4/images/placeholders/person.png";
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }


    public String getDescription() {

        return description;
    }


    public void setDescription(String description) {

        this.description = description;
    }

    public void setImageURL(String imageURL) {

        this.imageURL = imageURL;
    }

    public String getImageURL() {

        return imageURL;
    }


    @Override
    public String toString() {
        return super.toString();
    }

    public static Comparator<PersonContact> PersonNameAZComparator = new Comparator<PersonContact>() {
        @Override
        public int compare(PersonContact p1, PersonContact p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    public static Comparator<PersonContact> PersonNameZAComparator = new Comparator<PersonContact>() {
        @Override
        public int compare(PersonContact p1, PersonContact p2) {
            return p2.getName().compareTo(p1.getName());
        }
    };

}
