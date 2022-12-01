package Entities;

import Models.UserModel;
import Session.SessionWriter;
import java.util.Arrays;
import java.util.List;

public class SignEntity {

    AccountEntity accModel = new AccountEntity();
    UserEntity userModel = new UserEntity();
    SessionWriter sessionWr = new SessionWriter();

    private List<String> lineSession;

    public SignEntity() {
    }

    public boolean signUp(UserModel user) {
        return accModel.activeAccount(user);
    }

    public boolean signIn(String username, String password, boolean remember) {
        if (checkSignIn(username, password)) {
            int userId = accModel.getAccountId(username);
            UserModel user = userModel.getOneUser(userId);
            if (accModel.getOneAccount(username).getStatus() == 0) {
                return false;
            }
            if (remember == true) {
                lineSession = Arrays.asList(
                        "userId=" + user.getUserId(),
                        "remember=" + remember,
                        "username=" + username,
                        "password=" + password
                );
            } else {
                lineSession = Arrays.asList("userId=" + user.getUserId());
            }
            if (sessionWr.setSession(lineSession)) {
                return true;
            }
        }
        return false;
    }

    public boolean signOut() {
        boolean remember = false;
        lineSession = Arrays.asList("remember=false");
        if (sessionWr.getLineStartWith("remember=") != null) {
            remember = true;
        }
        if (remember == true) {
            lineSession = Arrays.asList(
                    sessionWr.getLineStartWith("remember="),
                    sessionWr.getLineStartWith("username="),
                    sessionWr.getLineStartWith("password=")
            );
        }
        return sessionWr.setSession(lineSession);
    }

    private boolean checkSignIn(String username, String password) {
        String checkPass = null;
        if (accModel.isExistAccount(username)) {
            checkPass = accModel.getOneAccount(username).getPassword();
        }
        return password.equals(checkPass);
    }

}
