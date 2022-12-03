package Controller;

import com.aptech.mavenproject2.petclinic.App;
import java.io.IOException;

public class Router {

    public static final String SIGNINPAGE = "SignIn";
    public static final String SIGNUPPAGE = "SignUp";
    public static final String ADMINHOMEPAGE = "test_MainPage";
    public static final String DOCTORHOMEPAGE = "";
    public static final String CLIENTHOMEPAGE = "Customer_Homepage";

    public static void switchToSignInPage() {
        try {
            App.setRoot(SIGNINPAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void switchToSignUpPage() {
        try {
            App.setRoot(SIGNUPPAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void switchToAdminHomePage() {
        try {
            App.setRoot(ADMINHOMEPAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void switchToDoctorHomePage() {
        try {
            App.setRoot(DOCTORHOMEPAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void switchToClientHomePage() {
        try {
            App.setRoot(CLIENTHOMEPAGE);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
