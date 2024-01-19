package com.example.jasmin1_19_2024exam.presentation.friend;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.example.jasmin1_19_2024exam.JsonConfigUtil;
import com.example.jasmin1_19_2024exam.R;
import com.example.jasmin1_19_2024exam.databinding.UpdateFriendBinding;
import com.example.jasmin1_19_2024exam.presentation.FriendViewModel;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateFriendActivity extends AppCompatActivity {
    private UpdateFriendBinding binding;

    private FriendViewModel friendViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = UpdateFriendBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Toolbar toolbar = binding.updatePersonToolBar;
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Update Friend Details");

        friendViewModel = new ViewModelProvider(this).get(FriendViewModel.class);
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
            friendViewModel.saveApplicationDetails(new Person(firstName, lastName, "Cabal", email, phoneNumber, "63", "“09/24/2001”"));
            finish();
        });
    }


}
