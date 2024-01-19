package com.example.jasmin1_19_2024exam.presentation.friend;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.jasmin1_19_2024exam.R;
import com.example.jasmin1_19_2024exam.databinding.ItemFriendDetailsBinding;


public class FriendDetailsActivity extends AppCompatActivity {


    private ItemFriendDetailsBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ItemFriendDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.friendDetailsToolBar;
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Friend Details");
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        binding.textName.setText("Name: " + name);
        binding.textEmail.setText("Email: " + email);
        binding.backButton.setOnClickListener(v -> {
            finish();
        });



    }
}
