package Controller;

import com.aptech.mavenproject2.petclinic.App;
import com.aptech.mavenproject2.petclinic.MainSignController;
import java.io.IOException;

public class Router {

    //sign page
    private static final String SIGN_PAGE = "test_Sign_MainPage";
    private static final String SIGN_IN_PAGE = "test_SignIn";
    private static final String SIGN_UP_PAGE = "test_SignUp";
    //admin
    private static final String ADMIN_PAGE = "test_Admin_MainPage";
    private static final String ADMIN_HOMEPAGE = "test_Admin_HomePage";
    private static final String ADMIN_BOOKING = "test_Admin_Booking";
    //doctor
    private static final String DOCTOR_PAGE = "";
    private static final String DOCTOR_HOMEPAGE = "";
    //client
    private static final String CLIENT_PAGE = "Customer_Homepage";
    private static final String CLIENT_HOMEPAGE = "";

    //get sign page
    public static String getSignPage() {
        return SIGN_PAGE;
    }

    public static String getSignInPage() {
        return SIGN_IN_PAGE;
    }

    public static String getSignUpPage() {
        return SIGN_UP_PAGE;
    }

    //get admin page
    public static String getAdminPage() {
        return ADMIN_PAGE;
    }

    public static String getAdminHomepage() {
        return ADMIN_HOMEPAGE;
    }

    public static String getAdminBooking() {
        return ADMIN_BOOKING;
    }

    //get doctor page
    public static String getDoctorPage() {
        return DOCTOR_PAGE;
    }

    public static String getDoctorHomepage() {
        return DOCTOR_HOMEPAGE;
    }

    //get client page
    public static String getClientPage() {
        return CLIENT_PAGE;
    }

    public static String getClientHomepage() {
        return CLIENT_HOMEPAGE;
    }

    //switch sign page
    public static void switchToSignInPage() {
        try {
            MainSignController.setIsSwitchSignUpPage(false);
            App.setRoot(getSignPage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void switchToSignUpPage() {
        try {
            MainSignController.setIsSwitchSignUpPage(true);
            App.setRoot(getSignPage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //switch admin page
    public static void switchToAdminPage() {
        try {
            App.setRoot(getAdminPage());
        } catch (IOException ex) {
//            Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.getMessage());
        }
    }

    //switch doctor page
    public static void switchToDoctorPage() {
        try {
            App.setRoot(getDoctorPage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    //switch client page
    public static void switchToClientPage() {
        try {
            App.setRoot(getClientPage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
