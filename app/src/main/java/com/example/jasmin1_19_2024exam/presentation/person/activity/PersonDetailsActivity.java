package com.example.jasmin1_19_2024exam.presentation.person.activity;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.example.jasmin1_19_2024exam.JsonConfigUtil;
import com.example.jasmin1_19_2024exam.R;
import com.example.jasmin1_19_2024exam.presentation.friend.FriendsActivity;
import com.example.jasmin1_19_2024exam.presentation.person.PersonListManager;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class PersonDetailsActivity extends AppCompatActivity {

    private ArrayList<Person> persons = new ArrayList<>();
    private PersonListManager personListManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_details);
        personListManager = new PersonListManager();
        personListManager.loadPeopleList(this);
        View nameItem = findViewById(R.id.nameItem);
        View emailItem = findViewById(R.id.emailItem);
        View mobileNumberItem = findViewById(R.id.mobileNumberItem);
        View addressItem = findViewById(R.id.addressItem);


        persons.addAll(personListManager.getPersons());
        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String email = getIntent().getStringExtra("email");
        String phoneNumber = getIntent().getStringExtra("number");
        String address = getIntent().getStringExtra("address");
        int age = getIntent().getIntExtra("age", 0);

        Toolbar toolbar = findViewById(R.id.personDetailsToolBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Person Details");

        TextView nameTv = nameItem.findViewById(R.id.valueTextView);
        TextView nameDescriptionTv = nameItem.findViewById(R.id.descriptionTextView);
        TextView emailTv = emailItem.findViewById(R.id.valueTextView);
        TextView emailDescriptionTv = emailItem.findViewById(R.id.descriptionTextView);
        TextView mobileNumberTv = mobileNumberItem.findViewById(R.id.valueTextView);
        TextView mobileNumberDescriptionTv = mobileNumberItem.findViewById(R.id.descriptionTextView);
        TextView addressTv = addressItem.findViewById(R.id.valueTextView);
        TextView addressDescriptionTv = addressItem.findViewById(R.id.descriptionTextView);

        nameTv.setText(firstName + " " +lastName);
        nameDescriptionTv.setText("Name");
        emailTv.setText(email);
        emailDescriptionTv.setText("Email Address");
        mobileNumberTv.setText(phoneNumber);
        mobileNumberDescriptionTv.setText("Mobile Number");
        addressTv.setText(address);
        addressDescriptionTv.setText("Address");

        Button updateButton = findViewById(R.id.update_button);
        Button deleteButton = findViewById(R.id.delete_button);

        updateButton.setOnClickListener(v -> {

        });

        deleteButton.setOnClickListener(v -> {
            deletePersonByMobileNumber(phoneNumber);
            Toast.makeText(this, "Person deleted", Toast.LENGTH_SHORT).show();
            this.startActivity(new Intent(this, FriendsActivity.class));
        });

    }




    private void deletePersonByMobileNumber(String mobileNumber) {
        try {
            String jsonData = readPeopleListJson();
            JSONObject jsonObject = new JSONObject(jsonData);

            JSONArray peopleArray = getPeopleArray(jsonObject);
            int indexToDelete = findPersonIndexByMobileNumber(peopleArray, mobileNumber);

            if (indexToDelete != -1) {
                peopleArray.remove(indexToDelete);
                savePeopleListJson(jsonObject);
                showToast("Person deleted!");
            } else {
                showToast("Person not found");
            }

        } catch (JSONException e) {
            e.printStackTrace();
            showToast("Deletion failed");
        }
    }

    private String readPeopleListJson() {
        return JsonConfigUtil.readConfig(this.getBaseContext(), "peoplelist.json");
    }

    private JSONArray getPeopleArray(JSONObject jsonData) throws JSONException {
        return jsonData.optJSONArray("people");
    }

    private void savePeopleListJson(JSONObject jsonData) {
         JsonConfigUtil.saveConfig(this, jsonData.toString(), "peoplelist.json");
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private int findPersonIndexByMobileNumber(JSONArray peopleArray, String mobileNumber) throws JSONException {
        for (int i = 0; i < peopleArray.length(); i++) {
            JSONObject personObject = peopleArray.getJSONObject(i);
            String currentMobileNumber = personObject.optString("mobile", ""); // Use optString to handle null case
            if (currentMobileNumber.equals(mobileNumber)) {
                return i;
            }
        }
        return -1; // Not found
    }




}
