package Entities;

import DB.common.DBCommon;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class User extends DBCommon<User> {

    private int user_id;
    private String full_name;
    private int gender;//0-male 1-female 2-other
    private Date dob;
    private String email;
    private String address;
    private String phone_number;
    private int role;//1-admin 2-doctor 3-client
    private Account account;
    private int status;//0-inactive 1-active

    public User() {
    }

    public User(int user_id,
            String full_name, int gender, Date dob,
            String email, String address, String phone_number,
            int role, Account account, int status) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.role = role;
        this.account = account;
        this.status = status;
    }

    public User(int user_id,
            String full_name, int gender, Date dob,
            String email, String address, String phone_number,
            int role, String username, String passowrd, int status) {
        this.user_id = user_id;
        this.full_name = full_name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.address = address;
        this.phone_number = phone_number;
        this.role = role;
        this.account = new Account(username, passowrd);
        this.status = status;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" + "user_id=" + user_id
                + ", full_name=" + full_name
                + ", gender=" + gender
                + ", dob=" + dob
                + ", email=" + email
                + ", address=" + address
                + ", phone_number=" + phone_number
                + ", role=" + role
                + ", account=" + account
                + ", status=" + status
                + '}';
    }

    @Override
    public User setResultSetValue(User user, ResultSet rs)
            throws SQLException {
        user.setUser_id(rs.getInt("user_id"));
        user.setFull_name(rs.getString("full_name"));
        user.setGender(rs.getInt("gender"));
        user.setDob(rs.getDate("dob"));
        user.setEmail(rs.getString("email"));
        user.setAddress(rs.getString("address"));
        user.setPhone_number(rs.getString("phone_number"));
        user.setRole(rs.getInt("role_id"));
        user.setAccount(new Account(rs.getString("username"), rs.getString("password")));
        user.setStatus(rs.getInt("status"));
        return user;
    }
}
