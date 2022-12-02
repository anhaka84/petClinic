package Controller;

import com.aptech.mavenproject2.petclinic.App;
import java.io.IOException;

public class Router {

    public static final String SIGNINPAGE = "SignIn";
    public static final String SIGNUPPAGE = "SignUp";
    public static final String ADMINHOMEPAGE = "Admin_Homepage";
    public static final String DOCTORHOMEPAGE = "";
    public static final String CLIENTHOMEPAGE = "";

    public static void switchToSignInPage() {
        try {
            App.setRoot(SIGNINPAGE);
        } catch (IOException ex) {
        }
    }

    public static void switchToSignUpPage() {
        try {
            App.setRoot(SIGNUPPAGE);
        } catch (IOException ex) {
        }
    }

    public static void switchToAdminHomePage() {
        try {
            App.setRoot(ADMINHOMEPAGE);
        } catch (IOException ex) {
        }
    }

    public static void switchToDoctorHomePage() {
        try {
            App.setRoot(DOCTORHOMEPAGE);
        } catch (IOException ex) {
        }
    }

    public static void switchToClientHomePage() {
        try {
            App.setRoot(CLIENTHOMEPAGE);
        } catch (IOException ex) {
        }
    }
}
