package Models;

import DB.main.DB;
import Entities.Account;
import Entities.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountModel {

    DB<User> db = new DB<>();
    UserModel userModel = new UserModel();
    String query;
    List condition = new ArrayList();

    public AccountModel() {
    }

    /**
     * crud
     */
    /**
     *
     * @param username
     * @return
     */
    public Account getOneAccount(String username) {
        query = "SELECT username, password, status"
                + " FROM User WHERE username = ?";
        condition = Arrays.asList(username);
        return db.getOne(query, condition, new Account());
    }

    public Account getOneAccount(int userId) {
        return userModel.getOneUser(userId).getAccount();
    }

    public int getAccountId(String username) {
        query = "SELECT *"
                + " FROM User WHERE username = ?";
        condition = Arrays.asList(username);
        return db.getOne(query, condition, new User()).getUserId();
    }

    public ArrayList<Account> getAllAccount() {
        query = "SELECT username, password, status"
                + " FROM User";
        return db.getAll(query, new Account());
    }

    public boolean updateAccount(String username, String password) {
        int userId = userModel.getSessionUser().getUserId();
        query = "UPDATE User"
                + " SET username = ?, password = ?"
                + " WHERE user_id = ?";
        condition = Arrays.asList(username, password, userId);
        return db.setSqlDataRow(query, condition, new User());
    }

    public boolean updateAccount(String username, String password, int status, int userId) {
        query = "UPDATE User"
                + " SET username = ?, password = ?, status = ?"
                + " WHERE user_id = ?";
        condition = Arrays.asList(username, password, status, userId);
        return db.setSqlDataRow(query, condition, new User());
    }

    public boolean deleteAccount(int userId) {
        query = "UPDATE User SET status = 0 WHERE user_id = ?";
        condition = Arrays.asList(userId);
        return db.setSqlDataRow(query, condition, new User());
    }

    /**
     * other
     */
    /**
     *
     * @param username
     * @return
     */
    public boolean isExistAccount(String username) {
        return getOneAccount(username) != null;
    }

    public boolean isUniqueAccount(String username) {
        return getOneAccount(username) == null;
    }

    public boolean activeAccount(User user) {
        if (isExistAccount(user.getAccount().getUsername())) {
            int id = getAccountId(user.getAccount().getUsername());
            return updateAccount(user.getAccount().getUsername(), user.getAccount().getPassword(), 1, id);
        }
        return userModel.addUser(user);
    }
}
