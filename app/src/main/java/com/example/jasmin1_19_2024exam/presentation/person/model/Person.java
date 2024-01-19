package com.example.jasmin1_19_2024exam.presentation.person.model;

public class Person {

    private int personId;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String mobile;
    private int age;
    private String address;
    private String email;
    private String birthdate;
    private String mobile_country_code;

    public Person(String first_name, String last_name, String email, String mobile, String address, int age){
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.age = age;
    }

    public Person(String first_name, String last_name, String middle_name, String email, String mobile, String mobile_country_code, String birthdate){
        this.first_name = first_name;
        this.last_name = last_name;
        this.middle_name = middle_name;
        this.email = email;
        this.mobile = mobile;
        this.mobile_country_code = mobile_country_code;
        this.birthdate = birthdate;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public String getMobile_country_code() {
        return mobile_country_code;
    }

    public void setMobile_country_code(String mobile_country_code) {
        this.mobile_country_code = mobile_country_code;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setMiddle_name(String middle_name) {
        this.middle_name = middle_name;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getMiddleName() {
        return middle_name;
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
