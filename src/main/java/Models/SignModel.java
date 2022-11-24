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

    public SignModel() {
    }

    public boolean signUp(User user) {
        return accModel.activeAccount(user);
    }

    public boolean signIn(String username, String password, boolean remember) {
        if (checkSignIn(username, password)) {
            int userId = accModel.getAccountId(username);
            User user = userModel.getOneUser(userId);
            if (user.getAccount().getStatus() == 0) {
                return false;
            }
            if (remember) {
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
        List<String> newLines = sessionWr.getSession();
        String remember = "";
        boolean isTrue = false;
        if (newLines.size() > 1) {
            remember = newLines.get(1);
        }
        if (newLines.size() > 2 && remember.split("=").length == 2) {
            isTrue = Boolean.parseBoolean(remember.split("=")[1]);
        }
        if (isTrue) {
            lineSession = Arrays.asList(
                    newLines.get(2),
                    newLines.get(3)
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
