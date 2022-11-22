package Models;

import DB.main.DB;
import Entities.Account;
import Entities.User;
import java.sql.Date;

public class testModel {

    public static void main(String[] args) {
        UserModel um = new UserModel();
        AccountModel acm = new AccountModel();

        User user = new User(1, "admin", 1, Date.valueOf("2003-01-01"),
                "admin@admin.petclinic.com", "Ha Noi", "0123456789", 1, "admin", "123456", 1);

        User user1 = new User(2, "Nguyen Thu Minh", 1, Date.valueOf("2003-01-01"),
                "minh.nt.1891@aptechlearning.edu.vn", "Ha Noi", "0368553888", 2, "leaderThuMinh", "123456", 1);

        User user2 = new User(3, "Doan Hoang Anh", 0, Date.valueOf("2003-01-01"),
                "anh.dh.1876@aptechlearning.edu.vn", "Ha Noi", "0911922941", 2, "memberHoangAnh", "123456", 1);

        User user3 = new User(4, "Vu Tuan Anh", 0, Date.valueOf("2003-01-01"),
                "anh.vt.1888@aptechlearning.edu.vn", "Ha Noi", "0367899855", 2, "memberTuanAnh", "123456", 1);

        User user4 = new User(5, "Vuong Quang Huy", 0, Date.valueOf("2003-01-01"),
                "huy.vq.@aptechlearning.edu.vn", "Ha Noi", "0385897664", 3, "memberQuangHuy", "123456", 1);

//        System.out.println("add user success ? " + um.addUser(user));
//        System.out.println("add user1 success ? " + um.addUser(user1));
//        System.out.println("add user2 success ? " + um.addUser(user2));
//        System.out.println("add user3 success ? " + um.addUser(user3));
//        System.out.println("add user4 success ? " + um.addUser(user4));
//        for (Account us : acm.getAllAccount()) {
//            System.out.println(us);
//        }
//        System.out.println(acm.isUniqueAccount("user1"));

        System.out.println(acm.getOneAccount("admin"));
        System.out.println(acm.deleteAccount(5));
    }
}
