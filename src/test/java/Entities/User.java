package Entities;

import java.sql.Date;

public class User {

    private int user_id;
    private int role_id;
    private String full_name;
    private int gender;
    private Date dob;
    private String email;
    private String address;
    private String phone_number;
    private String username;
    private String password;

    public User() {
    }

    public User(int user_id, int role_id, String full_name, int gender, Date dob, String email, String address, String phone_number, String username, String password) {
        this.user_id = user_id;
        this.role_id = role_id;
        this.full_name = full_name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.username = username;
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getRole_id() {
        return role_id;
    }

    public void setRole_id(int role_id) {
        this.role_id = role_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
