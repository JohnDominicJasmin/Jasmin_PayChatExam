package com.example.jasmin1_19_2024exam.presentation.person;

import android.content.Context;

import com.example.jasmin1_19_2024exam.JsonConfigUtil;
import com.example.jasmin1_19_2024exam.presentation.person.model.Person;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class PersonListManager {

    private List<Person> persons;

    public PersonListManager() {
        persons = new ArrayList<>();
    }

    public List<Person> getPersons() {
        return persons;
    }
    public void clearPersons(){
        persons.clear();
    }



    public void loadPeopleList(Context context) {
        try {
            String jsonData = JsonConfigUtil.readConfig(context, "peoplelist.json");
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONArray jsonArray = jsonObject.getJSONArray("people");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObjectPerson = jsonArray.getJSONObject(i);
                String firstName = jsonObjectPerson.getString("first_name");
                String lastName = jsonObjectPerson.getString("last_name");
                String personEmail = jsonObjectPerson.getString("email");
                String personNumber = jsonObjectPerson.getString("mobile");
                String personAddress = jsonObjectPerson.getString("address");
                Person person = new Person(firstName, lastName, personEmail, personNumber, personAddress);
                if (!personExists(person)) {
                    persons.add(person);
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private boolean personExists(Person person) {
        for (Person existingPerson : persons) {
            if (existingPerson.matches(person)) {
                return true;
            }
        }
        return false;
    }
}
