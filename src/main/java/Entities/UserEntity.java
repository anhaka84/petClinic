package Entities;

import Models.UserModel;
import DB.main.DB;
import Session.SessionWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserEntity {

    DB<UserModel> db = new DB<>();
    SessionWriter sessionWr = new SessionWriter();

    String query;
    List condition;
    String columns = "("
            + "role_id, "
            + "full_name, "
            + "gender, "
            + "dob, "
            + "email, "
            + "address, "
            + "phone_number, "
            + "username, "
            + "password, "
            + "status"
            + ")";

    public UserEntity() {
    }

    public boolean addUser(UserModel user) {
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
        return db.setSqlDataRow(query, condition, user);
    }

    public boolean addClientUser(UserModel user) {
        user.setRole(3);
        return addUser(user);
    }

    public UserModel getOneUser(int userId) {
        query = "SELECT * FROM User WHERE user_id = ?";
        condition = Arrays.asList(userId);
        return db.getOne(query, condition, new UserModel());
    }

    public ArrayList<UserModel> getAllUser() {
        query = "SELECT * FROM User";
        return db.getAll(query, new UserModel());
    }

    public List<UserModel> getAllUserActive() {
        query = "SELECT * FROM User"
                + " WHERE status = 1";
        return db.getAll(query, new UserModel());
    }

    public boolean updateUser(UserModel user) {
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
        return db.setSqlDataRow(query, condition, user);
    }

    public int getUserId(String email, String username) {
        query = "SELECT * FROM User"
                + " WHERE email = ? AND username = ?";
        condition = Arrays.asList(email, username);
        return db.getOne(query, condition, new UserModel()).getUserId();
    }

    public UserModel getSessionUser() {
        String startW = "userId=";
        String line = sessionWr.getLineStartWith(startW);
        int id = -1;
        if (line != null) {
            id = Integer.parseInt(line.substring(startW.length()));
        }
        return getOneUser(id);
    }

//    public boolean checkPhoneNumber(String phoneNumber) {
//        if (phoneNumber.matches("\\d+")) {
//            return true;
//        }
//        return false;
//    }
//    public String changeGender(int gender) {
//        switch (gender) {
//            case 0:
//                return "Male";
//            case 1:
//                return "Female";
//            default:
//                return "Other";
//        }
//    }
    public boolean isOldUser(String email) {
        query = "SELECT * FROM User"
                + " WHERE email = ? AND status = 0";
        condition = Arrays.asList(email);
        if (db.getOne(query, condition, new UserModel()) != null) {
            return true;
        }
        return false;
    }
}
