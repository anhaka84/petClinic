package Models;

import DB.main.DB;
import Entities.Account;
import Entities.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountModel {

    DB<User> db = new DB<>();
    UserModel um = new UserModel();
    String query;
    List condition = new ArrayList();

    public AccountModel() {
    }

    public boolean isUniqueAccount(String username) {
        return getOneAccount(username) == null;
    }

    public Account getOneAccount(int user_id) {
        return um.getOneUser(user_id).getAccount();
    }

    public Account getOneAccount(String username) {
        query = "SELECT username, password "
                + "FROM User WHERE username = ?";
        condition = Arrays.asList(username);
        return db.getOne(query, condition, new Account());
    }

    public ArrayList<Account> getAllAccount() {
        query = "SELECT username, password"
                + " FROM User";
        return db.getAll(query, new Account());
    }

    public boolean activeAccount() {
        return false;
    }

    public boolean deleteAccount(int user_id) {
        query = "UPDATE User SET status = 0 WHERE user_id = ?";
        condition = Arrays.asList(user_id);
        System.out.println(condition);
        return db.setSqlDataRow(query, condition, new User());
    }

}
