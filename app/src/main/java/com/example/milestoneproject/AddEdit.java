package com.example.milestoneproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class AddEdit extends AppCompatActivity {

    Button btn_ok, btn_cancel, btn_call, btn_text, btn_email, btn_map;
    EditText et_name, et_number, et_street, et_city, et_state, et_zip, et_url;
    TextView tv_id;
    List<PersonContact> contacts;
    PersonContact temp;
    int id;


    MyContactsList myContactsList = (MyContactsList) this.getApplication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit);

        contacts = MyContactsList.getPersonContactList();

        btn_ok = findViewById(R.id.btn_ok);
        btn_cancel = findViewById(R.id.btn_cancel);
        et_name = findViewById(R.id.et_name);
        et_number = findViewById(R.id.et_number);
        et_street = findViewById(R.id.et_street);
        et_city = findViewById(R.id.et_city);
        et_state = findViewById(R.id.et_state);
        et_zip = findViewById(R.id.et_zip);
        tv_id = findViewById(R.id.tv_id);
        et_url = findViewById(R.id.et_url);
        btn_call = findViewById(R.id.btn_call);
        btn_text = findViewById(R.id.btn_text);
        btn_email = findViewById(R.id.btn_email);
        btn_map = findViewById(R.id.btn_map);

        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        PersonContact personContact = null;

        if ( id >= 0) {
            // edit contact
            for (PersonContact p: contacts){
                if (p.getId() == id)
                    personContact = p;
            }

            et_name.setText(personContact.getName());
            et_number.setText(personContact.getPhone());
            et_street.setText(personContact.getLocation().getStreet());
            et_city.setText(personContact.getLocation().getCity());
            et_state.setText(personContact.getLocation().getState());
            et_zip.setText(personContact.getLocation().getZip());
            tv_id.setText(String.valueOf(personContact.getId()));
            et_url.setText(personContact.getImageURL());
            btn_call.setVisibility(View.VISIBLE);
            btn_text.setVisibility(View.VISIBLE);
            btn_email.setVisibility(View.VISIBLE);
            btn_map.setVisibility(View.VISIBLE);

            btn_call.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialPhoneNumber(et_number.getText().toString());
                }
            });

            btn_text.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    composeMmsMessage(et_number.getText().toString());
                }
            });

            btn_email.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String[] email = new String[]{et_name.getText().toString()};
                    // here the contacts name i being sed for the email to
                    // ensure user remembers who they wanted to send the email to
                    // as well as a failsafe for not having an email for the contact
                    composeEmail(email);
                }
            });

            btn_map.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String mapsQuery ="geo:0,0?q=" + et_street.getText().toString() + et_city.getText().toString() + et_state.getText().toString() + et_zip.getText().toString();
                    Uri maprui = Uri.parse(mapsQuery);
                    showMap(maprui);
                }
            });
        }
        else {
            // create a new contact
        }

        // verifies that required fields are entered and adds contact to the list before returning to
        // the main contact list screen
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEdit.this, MainActivity.class);
                if (id >= 0) {
                    // update
                    PersonContact update = new PersonContact(Integer.parseInt(tv_id.getText().toString()), et_name.getText().toString(), et_number.getText().toString(), new Location(et_street.getText().toString(), et_city.getText().toString(), et_state.getText().toString(), et_zip.getText().toString()), et_url.getText().toString());
                    contacts.set(id, update);
                }
                else {
                    if (!et_name.getText().toString().isEmpty() && !et_number.getText().toString().isEmpty() )
                        temp = new PersonContact(MyContactsList.getNextID(), et_name.getText().toString(), et_number.getText().toString());

                    contacts.add(temp);
                }
                startActivity(intent);


            }
        });

        // brings user back to the contact list screen and does nothing with any data entered
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddEdit.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void dialPhoneNumber(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:" + phoneNumber));
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e){
            Toast.makeText(this, "There is no ability to make a call with this device", Toast.LENGTH_SHORT).show();
        }
    }

    public void composeEmail(String[] addresses) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL, addresses);
        i.putExtra(Intent.EXTRA_TEXT, "body of email");
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }

    public void composeMmsMessage(String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("smsto:" + phoneNumber));  // This ensures only SMS apps respond
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e){
            Toast.makeText(this, "There is no ability to text with this device", Toast.LENGTH_SHORT).show();
        }
    }

    public void showMap(Uri geoLocation) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(geoLocation);
        try {
            startActivity(intent);
        } catch (ActivityNotFoundException e){
            Toast.makeText(this, "There is no ability to use Maps with this device", Toast.LENGTH_SHORT).show();
        }
    }
}