package com.example.jasmin1_19_2024exam.presentation.friend;

// PersonDetailsActivity.java

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jasmin1_19_2024exam.JsonConfigUtil;
import com.example.jasmin1_19_2024exam.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AddFriendActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_friend);

        Toolbar toolbar = findViewById(R.id.updatePersonToolBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Add Friend");


        findViewById(R.id.saveFriendButton).setOnClickListener(v -> {
            saveFriend();
        });



    }

    private void saveFriend() {
        EditText firstName = findViewById(R.id.firstName_edit_text);
        EditText lastName = findViewById(R.id.lastName_edit_text);
        EditText email = findViewById(R.id.email_edit_text);
        EditText phoneNumber = findViewById(R.id.mobile_number_edit_text);
        EditText address = findViewById(R.id.address_edit_text);
        EditText age = findViewById(R.id.age_edit_text);

        try {
            String jsonDataString = JsonConfigUtil.readConfig(this, "peoplelist.json");
            JSONObject jsonData = new JSONObject(jsonDataString);

            if (!jsonData.has("people")) {
                jsonData.put("people", new JSONArray());
            }

            JSONArray friendsArray = jsonData.getJSONArray("people");

            JSONObject newFriend = new JSONObject();
            newFriend.put("first_name", firstName.getText());
            newFriend.put("last_name", lastName.getText());
            newFriend.put("email", email.getText());
            newFriend.put("mobile", phoneNumber.getText());
            newFriend.put("address", address.getText());
            newFriend.put("age", age.getText());

            friendsArray.put(newFriend);

            JsonConfigUtil.saveConfig(this, jsonData.toString(), "peoplelist.json");
            Toast.makeText(this, "Friend added!", Toast.LENGTH_SHORT).show();
            finish();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Saving failed", Toast.LENGTH_SHORT).show();
        }
    }






}
