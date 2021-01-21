package com.example.milestoneproject;

import android.app.Person;
import android.provider.Contacts;

import java.util.Comparator;

public class PersonContact extends BaseContact {

    private int dateOfBirth;
    private String description;
    private String imageURL;


    public PersonContact() {
        super();
        dateOfBirth = 0;
        description = "Unknown";
        imageURL = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fsecocms.cpa.texas.gov%2Fsca-dev-kilimanjaro%2Fimg%2Fno_image_available.jpeg&imgrefurl=https%3A%2F%2Fsecocms.cpa.texas.gov%2Fsearch%3Fpage%3D3&tbnid=QJnWwlLEbJmpBM&vet=12ahUKEwj0k7r55KvuAhUSmJ4KHUDrABoQMygHegQIARA_..i&docid=O9EFpnqtH6FaeM&w=1601&h=1601&q=no%20image%20available&ved=2ahUKEwj0k7r55KvuAhUSmJ4KHUDrABoQMygHegQIARA_";

    }

    public PersonContact(String name, String phone, Location location, int dateOfBirth, String description, String imageURL) {
        super(name, phone, location);
        this.dateOfBirth = dateOfBirth;
        this.description = description;
        this.imageURL = imageURL;
    }

    public PersonContact(String name, String phone, Location location) {
        super(name, phone, location);
        this.imageURL ="https://www.google.com/imgres?imgurl=https%3A%2F%2Fsecocms.cpa.texas.gov%2Fsca-dev-kilimanjaro%2Fimg%2Fno_image_available.jpeg&imgrefurl=https%3A%2F%2Fsecocms.cpa.texas.gov%2Fsearch%3Fpage%3D3&tbnid=QJnWwlLEbJmpBM&vet=12ahUKEwj0k7r55KvuAhUSmJ4KHUDrABoQMygHegQIARA_..i&docid=O9EFpnqtH6FaeM&w=1601&h=1601&q=no%20image%20available&ved=2ahUKEwj0k7r55KvuAhUSmJ4KHUDrABoQMygHegQIARA";
    }



    public int getDateOfBirth() {
        return dateOfBirth;
    }


    public void setDateOfBirth(int dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
        return super.toString() + "\n\tDate of Birth: " + this.getDateOfBirth() + "\n\tDescription: " + this.getDescription();
    }

    public static Comparator<PersonContact> PeopleNameAZComparator = new Comparator<PersonContact>() {
        @Override
        public int compare(PersonContact p1, PersonContact p2) {
            return p1.getName().compareTo(p2.getName());
        }
    };

    public static Comparator<PersonContact> PeopleNameZAComparator = new Comparator<PersonContact>() {
        @Override
        public int compare(PersonContact p1, PersonContact p2) {
            return p2.getName().compareTo(p1.getName());
        }
    };

    public static Comparator<PersonContact> PeopleDateAscendingComparator = new Comparator<PersonContact>() {
        @Override
        public int compare(PersonContact p1, PersonContact p2) {
            return p1.getDateOfBirth() - p2.getDateOfBirth();
        }
    };

    public static Comparator<PersonContact> PeopleDateDescendingComparator = new Comparator<PersonContact>() {
        @Override
        public int compare(PersonContact p1, PersonContact p2) {
            return p2.getDateOfBirth() - p1.getDateOfBirth();
        }
    };



}
