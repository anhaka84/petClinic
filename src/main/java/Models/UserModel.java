package Models;

import DB.main.DB;
import Entities.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserModel {

    DB<User> db = new DB<>();
    String query;
    List condition = new ArrayList();
    String columns = "(user_id, role_id"
            + ", full_name, gender, dob, email, address, phone_number"
            + ", username, password"
            + ", status)";

    public UserModel() {
    }

    public String changeGender(int gender) {
        switch (gender) {
            case 0:
                return "Male";
            case 1:
                return "Female";
            default:
                return "Other";
        }
    }

    public User getOneUser(int user_id) {
        query = "SELECT * FROM User WHERE user_id = ?";
        condition.add(user_id);
        return db.getOne(query, condition, new User());
    }

    public ArrayList<User> getAllUser() {
        query = "SELECT * FROM User";
        return db.getAll(query, new User());
    }

    public boolean addUser(User user) {
        query = "INSERT INTO User " + columns
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?)";
        condition = Arrays.asList(
                user.getUser_id(),
                user.getRole(),
                user.getFull_name(),
                user.getGender(),
                user.getDob(),
                user.getEmail(),
                user.getAddress(),
                user.getPhone_number(),
                user.getAccount().getUsername(),
                user.getAccount().getPassword(),
                user.getStatus()
        );
        return db.setSqlDataRow(query, condition, user);
    }

    public boolean updateUser(User user) {
        query = "UPDATE User SET "
                + "role_id = ?"
                + ",full_name = ?"
                + ",gender = ?"
                + ",dob = ?"
                + ",email = ?"
                + ",address = ?"
                + ",phone_number = ?"
                + " WHERE user_id = ?";
        condition = Arrays.asList(
                user.getRole(),
                user.getFull_name(),
                user.getGender(),
                user.getDob(),
                user.getEmail(),
                user.getAddress(),
                user.getPhone_number(),
                user.getUser_id()
        );
        return db.setSqlDataRow(query, condition, user);
    }

}