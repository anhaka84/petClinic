package Entities;

import DB.common.DBCommon;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account extends DBCommon<Account> {

    private String username;
    private String password;

    public Account() {
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
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

    @Override
    public String toString() {
        return "Account{" + "username=" + username + ", password=" + password + '}';
    }

    @Override
    public Account setResultSetValue(Account object, ResultSet rs)
            throws SQLException {
        object.setUsername(rs.getString("username"));
        object.setPassword(rs.getString("password"));
        return object;
    }

}
