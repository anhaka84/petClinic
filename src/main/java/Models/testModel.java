package Models;

import DB.main.DB;
import Entities.Account;
import Entities.User;
import Session.SessionWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class testModel {

    public static void main(String[] args) {
//
//        UserModel userModel = new UserModel();
////data test
//        User user0 = new User(1, "admin", 1, Date.valueOf("2003-01-01"),
//                "admin@admin.petclinic.com", "Ha Noi", "0123456789", 1, "admin", "123456", 1);
//
//        User user1 = new User(2, "Nguyen Thu Minh", 1, Date.valueOf("2003-01-01"),
//                "minh.nt.1891@aptechlearning.edu.vn", "Ha Noi", "0368553888", 2, "leaderThuMinh", "123456", 1);
//
//        User user2 = new User(3, "Doan Hoang Anh", 0, Date.valueOf("2003-01-01"),
//                "anh.dh.1876@aptechlearning.edu.vn", "Ha Noi", "0911922941", 2, "memberHoangAnh", "123456", 1);
//
//        User user3 = new User(4, "Vu Tuan Anh", 0, Date.valueOf("2003-01-01"),
//                "anh.vt.1888@aptechlearning.edu.vn", "Ha Noi", "0367899855", 2, "memberTuanAnh", "123456", 1);
//
//        User user4 = new User(5, "Vuong Quang Huy", 0, Date.valueOf("2003-01-01"),
//                "huy.vq.@aptechlearning.edu.vn", "Ha Noi", "0385897664", 3, "memberQuangHuy", "123456", 1);
////add user
//        System.out.println("add user0 success ? " + userModel.addUser(user0));
//        System.out.println("add user1 success ? " + userModel.addUser(user1));
//        System.out.println("add user2 success ? " + userModel.addUser(user2));
//        System.out.println("add user3 success ? " + userModel.addUser(user3));
//        System.out.println("add user4 success ? " + userModel.addUser(user4));
////get all user
//        for (User us : userModel.getAllUser()) {
//            System.out.println(us);
//        }
////get one user
//        System.out.println(userModel.getOneUser(1));
////get user in session
//        System.out.println(userModel.getSessionUser());
//
//        AccountModel accModel = new AccountModel();
////get one account
//        System.out.println(accModel.getOneAccount("admin"));
////get all account
//        for (Account acc : accModel.getAllAccount()) {
//            System.out.println(acc);
//        }
////check account
//        System.out.println(accModel.isUniqueAccount("user1"));
//        System.out.println(accModel.isExistAccount("admin"));
////delete account
//        System.out.println(accModel.deleteAccount(5));
//
        DoctorModel doctorModel = new DoctorModel();

        SignModel signModel = new SignModel();
        SessionWriter sessionWr = new SessionWriter();
        List<String> lineSess = new ArrayList<>();

        //        System.out.println(doctorModel.getOneDoctor(3));
        //
        //        for (User dtr : dtm.getAllDoctor()) {
        //            System.out.println(dtr);
        //        }
        //        System.out.println(signModel.checkSignIn("admin", "123456"));
        //
        //        for (String line : sessionWr.getSession()) {
        //            System.out.println(line);
        //        }
        //        sessionWr.setSession(lineSess);
//                System.out.println(signModel.signIn("admin", "123456", true));
        //        signModel.signOut();
//        for (String line : sessionWr.getSession()) {
//            System.out.println(line);
//        }
//        System.out.println(sessionWr.getSession().get(2));
    }
}
