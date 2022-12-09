package Controller;

import com.aptech.mavenproject2.petclinic.App;
import com.aptech.mavenproject2.petclinic.SignMainController;
import java.io.IOException;

public class Router {

    //sign page
    private static final String SIGN_PAGE = "test_Sign_MainPage";
    private static final String SIGN_IN = "test_SignIn";
    private static final String SIGN_UP = "test_SignUp";
    //admin
    private static final String ADMIN_PAGE = "test_Admin_MainPage";
    private static final String ADMIN_HOME = "test_Admin_HomePage";
    private static final String ADMIN_BOOKING = "test_Admin_Booking";
    private static final String ADMIN_BILL = "test_Admin_Bill";
    private static final String ADMIN_SERVICES = "test_Admin_Services";
    private static final String ADMIN_MEDICINES = "test_Admin_Medicines";
    private static final String ADMIN_MANAGE_ACCOUNT = "test_Admin_Manage_Account";
    private static final String ADMIN_YOUR_INFO = "test_Admin_Your_Info";
    //doctor
    private static final String DOCTOR_PAGE = "test_Doctor_MainPage";
    private static final String DOCTOR_HOME = "test_Admin_HomePage";
    private static final String DOCTOR_BOOKING = "test_Admin_Booking";
    private static final String DOCTOR_SCHEDULE = "test_Admin_HomePage";
    private static final String DOCTOR_YOUR_INFO = "test_Admin_Your_Info";
    //client
    private static final String CLIENT_PAGE = "test_Customer_MainPage";
    private static final String CLIENT_HOME = "test_Admin_HomePage";
    private static final String CLIENT_OUR_DOCTOR = "test_Admin_HomePage";
    private static final String CLIENT_OUR_SERVICES = "test_Admin_Services";
    private static final String CLIENT_YOUR_PET = "test_Admin_HomePage";
    private static final String CLIENT_BOOKING = "test_Admin_Booking";
    private static final String CLIENT_YOUR_INFO = "test_Admin_Your_Info";

    //get sign page
    public static String getSignPage() {
        return SIGN_PAGE;
    }

    public static String getSignInPage() {
        return SIGN_IN;
    }

    public static String getSignUpPage() {
        return SIGN_UP;
    }

    //get admin page
    public static String getAdminPage() {
        return ADMIN_PAGE;
    }

    public static String getAdminHomepage() {
        return ADMIN_HOME;
    }

    public static String getAdminBooking() {
        return ADMIN_BOOKING;
    }

    public static String getAdminBill() {
        return ADMIN_BILL;
    }

    public static String getAdminServices() {
        return ADMIN_SERVICES;
    }

    public static String getAdminMedicines() {
        return ADMIN_MEDICINES;
    }

    public static String getAdminManageAccount() {
        return ADMIN_MANAGE_ACCOUNT;
    }

    public static String getAdminInfo() {
        return ADMIN_YOUR_INFO;
    }

    //get doctor page
    public static String getDoctorPage() {
        return DOCTOR_PAGE;
    }

    public static String getDoctorHomepage() {
        return DOCTOR_HOME;
    }

    public static String getDoctorBooking() {
        return DOCTOR_BOOKING;
    }

    public static String getDoctorSchedule() {
        return DOCTOR_SCHEDULE;
    }

    public static String getDoctorInfo() {
        return DOCTOR_YOUR_INFO;
    }

    //get client page
    public static String getClientPage() {
        return CLIENT_PAGE;
    }

    public static String getClientHomepage() {
        return CLIENT_HOME;
    }

    public static String getClientDoctorPage() {
        return CLIENT_OUR_DOCTOR;
    }

    public static String getClientServices() {
        return CLIENT_OUR_SERVICES;
    }

    public static String getClientPet() {
        return CLIENT_YOUR_PET;
    }

    public static String getClientBooking() {
        return CLIENT_BOOKING;
    }

    public static String getClientInfo() {
        return CLIENT_YOUR_INFO;
    }

    //switch sign page
    public static void switchToSignInPage() {
        try {
            SignMainController.setIsSwitchSignUpPage(false);
            App.setRoot(getSignPage());
        } catch (IOException ex) {
//            Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void switchToSignUpPage() {
        try {
            SignMainController.setIsSwitchSignUpPage(true);
            App.setRoot(getSignPage());
        } catch (IOException ex) {
//            Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //switch admin page
    public static void switchToAdminPage() {
        try {
            App.setRoot(getAdminPage());
        } catch (IOException ex) {
//            Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //switch doctor page
    public static void switchToDoctorPage() {
        try {
            App.setRoot(getDoctorPage());
        } catch (IOException ex) {
//            Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //switch client page
    public static void switchToClientPage() {
        try {
            App.setRoot(getClientPage());
        } catch (IOException ex) {
//            Logger.getLogger(Router.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
