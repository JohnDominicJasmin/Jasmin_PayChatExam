package com.example.jasmin1_19_2024exam;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jasmin1_19_2024exam.databinding.ActivityMainBinding;
import com.example.jasmin1_19_2024exam.presentation.friend.FriendsActivity;
import com.example.jasmin1_19_2024exam.presentation.person.PersonListManager;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;
import com.example.jasmin1_19_2024exam.presentation.person.adapter.PersonAdapter;
import com.example.jasmin1_19_2024exam.presentation.friend.AddFriendActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    private RecyclerView recyclerView;

    private ActivityMainBinding binding;
    private PersonListManager personListManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        personListManager = new PersonListManager();
        Toolbar toolbar = binding.personDetailsToolBar;
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);

        recyclerView = binding.recyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);



    }

    private void showPeopleList(){

        personListManager.clearPersons();
        personListManager.loadPeopleList(this);
        PersonAdapter personAdapter = new PersonAdapter((ArrayList<Person>) personListManager.getPersons());
        recyclerView.setAdapter(personAdapter);
    }



    @Override
    protected void onResume() {
        super.onResume();
        showPeopleList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.example_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        CharSequence title = item.getTitle();
        if (title.equals("Add friends")) {
            Intent intent = new Intent(this, AddFriendActivity.class);
            startActivity(intent);
            return true;
        } else if (title.equals("Friendlist")) {
            Intent intent = new Intent(this, FriendsActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }




}
