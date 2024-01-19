package com.example.jasmin1_19_2024exam.presentation.person.model;

public class Person {

    private int personId;
    private String first_name;
    private String last_name;
    private String mobile;
    private int age;
    private String address;
    private String email;

    public Person(String first_name, String last_name, String email, String mobile, String address){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }


    public boolean matches(Person person) {
        return this.first_name.equals(person.first_name)
                && this.last_name.equals(person.last_name)
                && this.email.equals(person.email)
                && this.mobile.equals(person.mobile)
                && this.address.equals(person.address);
    }
    public int getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return first_name;
    }

    public String getLastName() {
        return last_name;
    }

    public String getMobile() {
        return mobile;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
