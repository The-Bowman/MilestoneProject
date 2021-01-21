package com.example.milestoneproject;

import java.util.ArrayList;
import java.util.List;

public class AddressBook {

    List<BaseContact> contactList;

    public AddressBook() {
        contactList = new ArrayList<>();
    }

    public AddressBook(BaseContact contact) {
        contactList = new ArrayList<>();
        contactList.add(contact);
    }

    public void addContact(BaseContact contact) {
        contactList.add(contact);
    }

    public void removeContact(int index) {
        contactList.remove(index);
    }

    public BaseContact getContact(int index) {
        return contactList.get(index);
    }

    public int size() {
        return contactList.size();
    }

    public BaseContact searchByName(String name) {
        BaseContact temp = null;
        for (BaseContact c : contactList) {
            if (c.getName().equalsIgnoreCase(name)) {
                temp = c;
            }
        }
        return temp;
    }

//    public BaseContact searchByNumber(int number) {
//        BaseContact temp = null;
//        for (BaseContact c : contactList) {
//            if (c.getNumber() == number) {
//                temp = c;
//            }
//        }
//        return temp;
//    }

//    public BaseContact searchByPhone(long phone) {
//        BaseContact temp = null;
//        for (BaseContact c : contactList) {
//            if (c.getPhone() == phone) {
//                temp = c;
//            }
//        }
//        return temp;
//    }

    public BaseContact searchByLocation(Location location) {
        BaseContact temp = null;
        for (BaseContact c : contactList) {
            if (c.getLocation().equals(location)) {
                temp = c;
            }
        }
        return temp;
    }

    public void viewAll() {
        for (BaseContact c : contactList) {
            System.out.println(c.toString());
        }
    }

    @Override
    public String toString() {
        String list = "";
        for (BaseContact c : contactList) {
            list += c.toString();
        }
        return list;
    }


}
