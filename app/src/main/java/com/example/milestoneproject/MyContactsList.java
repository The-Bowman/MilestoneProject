package com.example.milestoneproject;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyContactsList extends Application {

    private static List<PersonContact> personContactList = new ArrayList<PersonContact>();
    private static int nextID = 3;

    public MyContactsList() {
        fillPersonList();
    }




    private void fillPersonList() {
        PersonContact p0 = new PersonContact(0, "Paige Lucky", "777-777-7777", new Location("777 Bantha Street", "Fargo", "AZ", "85396"), "https://web5.lifelearn.com/ahcofrochester/wp-content/uploads/2011/02/Bulldog1of2.jpg");
        PersonContact p1 = new PersonContact(1, "Bahn", "888-888-8888", new Location("666 Purgatory Dr", "Unknown", "Unknown", "00000"), "https://imgix.ranker.com/user_node_img/3832/76621023/original/ban-photo-u11?fit=crop&fm=pjpg&q=60&w=650&dpr=2");
        PersonContact p2 = new PersonContact(2, "Cayde", "010-101-0101", new Location("0", "Last City", "The Traveler", "00000"), "https://i.pinimg.com/originals/e6/31/9c/e6319c7f31e94b30cc61a1b7a766c47b.jpg");

        personContactList.addAll(Arrays.asList(new PersonContact[] { p0, p1, p2}));

    }

    public static void setPersonContactList(List<PersonContact> personContactList) {
        MyContactsList.personContactList = personContactList;
    }

    public static List<PersonContact> getPersonContactList(){
        return personContactList;
    }

    public static int getNextID(){
        return nextID;
    }

    public static void setNextID(int nextID){
        MyContactsList.nextID = nextID;
    }


}
