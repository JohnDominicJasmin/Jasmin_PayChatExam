package com.example.jasmin1_19_2024exam.presentation.friend;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jasmin1_19_2024exam.JsonConfigUtil;
import com.example.jasmin1_19_2024exam.R;
import com.example.jasmin1_19_2024exam.databinding.UpdateFriendBinding;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateFriendActivity extends AppCompatActivity {
    private UpdateFriendBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = UpdateFriendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar = binding.updatePersonToolBar;
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Friend Details");

        String firstName = getIntent().getStringExtra("firstName");
        String lastName = getIntent().getStringExtra("lastName");
        String email = getIntent().getStringExtra("email");
        String phoneNumber = getIntent().getStringExtra("number");
        String address = getIntent().getStringExtra("address");
        int age = getIntent().getIntExtra("age", 0);
        binding.firstNameEditText.setText(firstName);
        binding.lastNameEditText.setText(lastName);
        binding.emailEditText.setText(email);
        binding.mobileNumberEditText.setText(phoneNumber);
        binding.addressEditText.setText(address);
        binding.ageEditText.setText(String.valueOf(age));


        binding.updateFriendButton.setOnClickListener(v -> {

            updatePersonByMobileNumber(phoneNumber, new Person(
                    binding.firstNameEditText.getText().toString(),
                    binding.lastNameEditText.getText().toString(),
                    binding.emailEditText.getText().toString(),
                    binding.mobileNumberEditText.getText().toString(),
                    binding.addressEditText.getText().toString(),
                    Integer.parseInt(binding.ageEditText.getText().toString())
            ));
            finish();
        });
    }

    private void updatePersonByMobileNumber(String mobileNumber, Person updatedPerson) {
        try {
            String jsonData = readPeopleListJson();
            JSONObject jsonObject = new JSONObject(jsonData);


            JSONArray peopleArray = getPeopleArray(jsonObject);
            int indexToUpdate = findPersonIndexByMobileNumber(peopleArray, mobileNumber);

            if (indexToUpdate != -1) {
                JSONObject updatedPersonJson = convertPersonToJson(updatedPerson);

                if (updatedPersonJson != null) {
                    peopleArray.put(indexToUpdate, updatedPersonJson);
                    savePeopleListJson(jsonObject);
                    showToast("Person updated!");
                } else {
                    showToast("Invalid person data");
                }
            } else {
                showToast("Person not found");
            }

        } catch (JSONException e) {
            e.printStackTrace();
            showToast("Update failed");
        }
    }

    private JSONArray getPeopleArray(JSONObject jsonData) throws JSONException {
        return jsonData.optJSONArray("people");
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
    private String  readPeopleListJson() {
        return JsonConfigUtil.readConfig(this, "peoplelist.json");
    }
    private void savePeopleListJson(JSONObject jsonData) {
         JsonConfigUtil.saveConfig(this, jsonData.toString(), "peoplelist.json");
    }


    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
    private JSONObject convertPersonToJson(Person person) {
        JSONObject personJson = new JSONObject();
        try {
            personJson.put("first_name", person.getFirstName());
            personJson.put("last_name", person.getLastName());
            personJson.put("email", person.getEmail());
            personJson.put("mobile", person.getMobile());
            personJson.put("address", person.getAddress());
            personJson.put("age", person.getAge());
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
        return personJson;
    }

}
