
import Entities.*;
import Models.*;
import Session.SessionWriter;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        RoleModel roleM = new RoleModel();
        UserModel userM = new UserModel();
        DoctorModel doctorM = new DoctorModel();
        AccountModel accountM = new AccountModel();

        List list;
        User user;
        DoctorLevel doctor;
        Account account;
//        /**
//         * test role
//         */
//        list = Arrays.asList(
//                new Role(1, "Admin"),
//                new Role(2, "Doctor"),
//                new Role(3, "Client"),
//                new Role(4, "RoleTest")//update, delete
//        );
//        list.forEach(role -> {
//            System.out.println("Role:add success ? " + roleM.addRole((Role) role));
//        });
//        roleM.getAllRole().forEach(role -> {
//            System.out.println("Role:getAll=" + role);
//        });
//        System.out.println("Role:getOne=" + roleM.getOneRole(1));
//        System.out.println("Role:update success ? " + roleM.updateRole(new Role(4, "Updated")));
//        System.out.println("Role:getOne=" + roleM.getOneRole(4));
//        System.out.println("Role:delete success ? " + roleM.deleteRole(4));
//        System.out.println("Role:getOne=" + roleM.getOneRole(4));
//        /**
//         * test user
//         */
//        user = new User(1,//role
//                "admin", 0, Date.valueOf("2003-01-01"),//user info
//                "admin@admin.petclinic.com", "Ha Noi", "0123456789", //user info
//                new Account("admin", "123456")//account
//        );
//        System.out.println("User:add success ? " + userM.addUser(user));//add any user
//        user = new User(//no user id, no role id
//                "Vuong Quang Huy", 0, Date.valueOf("2003-01-01"),
//                "huy.vq.@aptechlearning.edu.vn", "Ha Noi", "0385897664",
//                new Account("memberQuangHuy", "123456")
//        );
//        System.out.println("User:add success ? " + userM.addDefaultUser(user));//add client (role id = 3)
//        System.out.println(accountM.activeAccount(user));
//        System.out.println(accountM.getOneAccount("admin"));
//        for (Account acc : accountM.getAllAccount()) {
//            System.out.println(acc);
//        }
        System.out.println(accountM.checkInputAccount("abc", "''abc= abc "));
//        /**
//         * test doctor
//         */
//        list = Arrays.asList(
//                new DoctorLevel(
//                        new User(
//                                "Nguyen Thu Minh", 1, Date.valueOf("2003-01-01"),
//                                "minh.nt.1891@aptechlearning.edu.vn", "Ha Noi", "0368553888",
//                                new Account("leaderThuMinh", "123456")
//                        ),
//                        "titile", "degree", Date.valueOf("2003-01-01")
//                ),
//                new DoctorLevel(
//                        new User(
//                                "Doan Hoang Anh", 0, Date.valueOf("2003-01-01"),
//                                "anh.dh.1876@aptechlearning.edu.vn", "Ha Noi", "0911922941",
//                                new Account("memberHoangAnh", "123456")
//                        ),
//                        "titile", "degree", Date.valueOf("2003-01-01")
//                ),
//                new DoctorLevel(
//                        new User(
//                                "Vu Tuan Anh", 0, Date.valueOf("2003-01-01"),
//                                "anh.vt.1888@aptechlearning.edu.vn", "Ha Noi", "0367899855",
//                                new Account("memberTuanAnh", "123456")
//                        ),
//                        "titile", "degree", Date.valueOf("2003-01-01")
//                )
//        );
//        list.forEach(dt -> {
//            System.out.println("Doctor:add success ? " + doctorM.addDoctor((DoctorLevel) dt));//add doctor (role id = 2)
//        });

    }
}
