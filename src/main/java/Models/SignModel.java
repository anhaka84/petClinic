package Models;

import Entities.User;
import Session.SessionWriter;
import java.util.Arrays;
import java.util.List;

public class SignModel {

    AccountModel accModel = new AccountModel();
    UserModel userModel = new UserModel();
    SessionWriter sessionWr = new SessionWriter();
    List<String> lineSession;
    private String username;
    private String password;
    private boolean remember;

    public SignModel() {
    }

    public boolean signIn(String username, String password, boolean remember) {
        if (checkSignIn(username, password)) {
            int userId = accModel.getAccountId(username);
            User user = userModel.getOneUser(userId);

            this.username = username;
            this.password = password;
            this.remember = remember;

            lineSession = Arrays.asList(
                    "userId=" + user.getUserId()
            //                    "fullName=" + user.getFullName(),
            //                    "gender=" + user.getGender(),
            //                    "dob=" + user.getDob(),
            //                    "email=" + user.getEmail(),
            //                    "address=" + user.getAddress(),
            //                    "phoneNumber=" + user.getPhoneNumber(),
            //                    "roleId=" + user.getRole(),
            //                    "username=" + user.getAccount().getUsername(),
            //                    "password=" + user.getAccount().getPassword(),
            //                    "status=" + user.getAccount().getStatus(),
            //                    "remember=" + remember
            );
            sessionWr.setSession(lineSession);

            return true;
        }
        return false;
    }

    public boolean checkSignIn(String username, String password) {
        String checkPass = null;
        if (accModel.isExistAccount(username)) {
            checkPass = accModel.getOneAccount(username).getPassword();
        }
        return password.equals(checkPass);
    }

    public boolean signUp(User user) {
        return userModel.addUser(user);
    }

    public void signOut() {
        lineSession = Arrays.asList(
                "remember=" + this.remember,
                "username=" + this.username,
                "password=" + this.password
        );
        sessionWr.setSession(lineSession);
    }
}
