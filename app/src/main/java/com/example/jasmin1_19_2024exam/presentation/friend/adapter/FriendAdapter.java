package com.example.jasmin1_19_2024exam.presentation.friend.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jasmin1_19_2024exam.R;
import com.example.jasmin1_19_2024exam.presentation.friend.FriendDetailsActivity;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;

import java.util.List;

public class FriendAdapter extends RecyclerView.Adapter<FriendAdapter.FriendViewHolder> {

    private List<Person> friends;

    public FriendAdapter(List<Person> friends) {
        this.friends = friends;
    }

    @NonNull
    @Override
    public FriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend, parent, false);
        return new FriendViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FriendViewHolder holder, int position) {
        Person friend = friends.get(position);
        String name = friend.getFirstName() + " " + friend.getLastName();
        String email = friend.getEmail();
        String mobileNumber = friend.getMobile();
        String address = friend.getAddress();
        holder.textName.setText("Name: " + name);
        holder.textEmail.setText("Email: " + email);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), FriendDetailsActivity.class);
            intent.putExtra("name", name);
            intent.putExtra("email", email);
            v.getContext().startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return friends.size();
    }

    public static class FriendViewHolder extends RecyclerView.ViewHolder {

        TextView textName;
        TextView textEmail;

        public FriendViewHolder(@NonNull View itemView) {
            super(itemView);
            textName = itemView.findViewById(R.id.textName);
            textEmail = itemView.findViewById(R.id.textEmail);
        }
    }
}

