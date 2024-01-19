package com.example.jasmin1_19_2024exam.presentation.friend;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jasmin1_19_2024exam.JsonConfigUtil;
import com.example.jasmin1_19_2024exam.R;
import com.example.jasmin1_19_2024exam.presentation.friend.adapter.FriendAdapter;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FriendsActivity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private FriendAdapter adapter;
    private ArrayList<Person> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends);
        Toolbar toolbar = findViewById(R.id.friendsToolBar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Friends List");

        String jsonDataString = JsonConfigUtil.readConfig(this, "peoplelist.json");
        try {
            JSONObject jsonData = new JSONObject(jsonDataString);
            JSONArray friendsArray = jsonData.getJSONArray("people");

            Type friendListType = new TypeToken<List<Person>>() {}.getType();
            List<Person> friendsList = new Gson().fromJson(friendsArray.toString(), friendListType);
            friends.addAll(friendsList);

        } catch (JSONException e) {
            throw new RuntimeException(e);
        }

        recyclerView = findViewById(R.id.friendsRecyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new FriendAdapter(friends);
        recyclerView.setAdapter(adapter);

    }


}
