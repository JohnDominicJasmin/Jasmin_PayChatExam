package com.example.jasmin1_19_2024exam.presentation.person.adapter;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jasmin1_19_2024exam.R;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;
import com.example.jasmin1_19_2024exam.presentation.person.activity.PersonDetailsActivity;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonView> {


    private ArrayList<Person> persons = new ArrayList<>();



    public PersonAdapter(ArrayList<Person> persons) {
        this.persons = persons;

    }


    @NonNull
    @Override
    public PersonView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_item, parent, false);
        return new PersonView(view);
    }
    @Override
    public void onBindViewHolder(@NonNull PersonView holder, int position) {

        Person person = persons.get(position);
        String firstName = person.getFirstName();
        String lastName = person.getLastName();
        String name = firstName + " " + lastName;
        String email = persons.get(position).getEmail();
        String mobileNumber = persons.get(position).getMobile();
        String address = persons.get(position).getAddress();
        int age = persons.get(position).getAge();


        holder.name.setText(name);
        holder.email.setText(email);

        holder.itemView.setOnClickListener(v -> {

            Intent intent = new Intent(v.getContext(), PersonDetailsActivity.class);
            intent.putExtra("firstName", firstName);
            intent.putExtra("lastName", lastName);
            intent.putExtra("email", email);
            intent.putExtra("number", mobileNumber);
            intent.putExtra("address", address);
            intent.putExtra("age", age);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class PersonView extends RecyclerView.ViewHolder{

        TextView name;
        TextView email;
        public PersonView(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            email = itemView.findViewById(R.id.email);
        }
    }
}
