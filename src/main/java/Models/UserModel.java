package Models;

import DB.main.DB;
import Entities.User;
import Session.SessionWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserModel {

    DB<User> db = new DB<>();
    SessionWriter sessionWr = new SessionWriter();

    String query;
    List condition;
    String columns = "("
            + "role_id"
            + ", full_name"
            + ", gender"
            + ", dob"
            + ", email"
            + ", address"
            + ", phone_number"
            + ", username"
            + ", password"
            + ", status"
            + ")";

    public UserModel() {
    }

    /**
     * crud
     * @param userId
     * @return 
     */
    public User getOneUser(int userId) {
        query = "SELECT * FROM User WHERE user_id = ?";
        condition = Arrays.asList(userId);
        return db.getOne(query, condition, new User());
    }

    public ArrayList<User> getAllUser() {
        query = "SELECT * FROM User";
        return db.getAll(query, new User());
    }

    public List<User> getAllUserActive() {
        query = "SELECT * FROM User"
                + " WHERE status = 1";
        return db.getAll(query, new User());
    }

    public boolean addUser(User user) {
        query = "INSERT INTO User " + columns
                + " VALUES (?,?,?,?,?,?,?,?,?,?)";
        condition = Arrays.asList(
                user.getRole(),
                user.getFullName(),
                user.getGender(),
                user.getDob(),
                user.getEmail(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getAccount().getUsername(),
                user.getAccount().getPassword(),
                user.getAccount().getStatus()
        );
        return db.setSqlDataRow(query, condition, new User());
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
                user.getFullName(),
                user.getGender(),
                user.getDob(),
                user.getEmail(),
                user.getAddress(),
                user.getPhoneNumber(),
                user.getUserId()
        );
        return db.setSqlDataRow(query, condition, new User());
    }

    /**
     * other
     * @param user
     * @return 
     */
    public boolean addDefaultUser(User user) {
        user.setRole(3);
        return addUser(user);
    }

    public int getUserId(String email, String username) {
        query = "SELECT * FROM User"
                + " WHERE email = ? AND username = ?";
        condition = Arrays.asList(email, username);
        return db.getOne(query, condition, new User()).getUserId();
    }

    public User getSessionUser() {
        String line0 = sessionWr.getSession().get(0);
        int id = Integer.parseInt(line0.split("=")[1]);
        return getOneUser(id);
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

}
