package com.example.milestoneproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "PersonList App";
    Button btn_add;

    List<Person> personList = new ArrayList<Person>();

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fillPersonList();
        Log.d(TAG, "onCreate: " + personList.toString());
        btn_add = findViewById(R.id.btn_add);

        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddEdit.class);
                startActivity(intent);
            }
        });

        recyclerView = findViewById(R.id.lv_contactlist);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        mAdapter = new RecycleViewAdapter(personList, MainActivity.this);
        recyclerView.setAdapter(mAdapter);
    }

    private void fillPersonList() {
        Person p0 = new Person("John Doe", "77777777777", "333 Unknown Street, Fargo, AZ");
        Person p1 = new Person("Paige Christopherson", "7018675309", "777 Bantha Street, Fargo, AZ");
        Person p2 = new Person("Dustin Johnson", "7019035768", "777 Bantha Street, Fargo, AZ");
        Person p3 = new Person("Felix Jones", "9019019001", "444 Firefly Street, Fargo, AZ");
        Person p4 = new Person("Cayde-6", "6", "Forever in our Hearts Street, Serenity, Space");

        personList.addAll(Arrays.asList(new Person[]{p0, p1, p2, p3, p4}));

    }
}