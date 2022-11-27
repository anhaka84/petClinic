
import Entities.*;
import Models.*;
import Session.SessionWriter;
import java.sql.Date;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        RoleEntity roleM = new RoleEntity();
        UserEntity userM = new UserEntity();
        DoctorEntity doctorM = new DoctorEntity();
        AccountEntity accountM = new AccountEntity();
        SessionWriter sessionWriter = new SessionWriter();
        SignEntity signEntity = new SignEntity();

        List list;
        UserModel user;
        DoctorLevelModel doctor;
        AccountModel account;
        /**
         * test role
         */
        list = Arrays.asList(
                new Role(1, "Admin"),
                new Role(2, "Doctor"),
                new Role(3, "Client"),
                new Role(4, "RoleTest")//update, delete
        );
        list.forEach(role -> {
            System.out.println("Role:add success ? " + roleM.addRole((Role) role));
        });
        roleM.getAllRole().forEach(role -> {
            System.out.println("Role:getAll=" + role);
        });
        System.out.println("Role:getOne=" + roleM.getOneRole(1));
        System.out.println("Role:update success ? " + roleM.updateRole(new Role(4, "Updated")));
        System.out.println("Role:getOne=" + roleM.getOneRole(4));
        System.out.println("Role:delete success ? " + roleM.deleteRole(4));
        System.out.println("Role:getOne=" + roleM.getOneRole(4));
        /**
         * test user
         */
        user = new UserModel(1,//role
                "admin", 0, Date.valueOf("2003-01-01"),//user info
                "admin@admin.petclinic.com", "Ha Noi", "0123456789", //user info
                new AccountModel("admin", "123456")//account
        );
        System.out.println("User:add success ? " + userM.addUser(user));//add any user
        user = new UserModel(//no user id, no role id
                "Vuong Quang Huy", 0, Date.valueOf("2003-01-01"),
                "huy.vq.@aptechlearning.edu.vn", "Ha Noi", "0385897664",
                new AccountModel("memberQuangHuy", "123456")
        );
        System.out.println("User:add success ? " + userM.addClientUser(user));//add client (role id = 3)
        System.out.println(accountM.activeAccount(user));
        System.out.println(accountM.getOneAccount("admin"));
        for (AccountModel acc : accountM.getAllAccount()) {
            System.out.println(acc);
        }
        System.out.println(accountM.checkInputAccount("abc", "abc"));
        /**
         * test doctor
         */
        list = Arrays.asList(
                new DoctorLevelModel(
                        new UserModel(
                                "Nguyen Thu Minh", 1, Date.valueOf("2003-01-01"),
                                "minh.nt.1891@aptechlearning.edu.vn", "Ha Noi", "0368553888",
                                new AccountModel("leaderThuMinh", "123456")
                        ),
                        "titile", "degree", Date.valueOf("2003-01-01")
                ),
                new DoctorLevelModel(
                        new UserModel(
                                "Doan Hoang Anh", 0, Date.valueOf("2003-01-01"),
                                "anh.dh.1876@aptechlearning.edu.vn", "Ha Noi", "0911922941",
                                new AccountModel("memberHoangAnh", "123456")
                        ),
                        "titile", "degree", Date.valueOf("2003-01-01")
                ),
                new DoctorLevelModel(
                        new UserModel(
                                "Vu Tuan Anh", 0, Date.valueOf("2003-01-01"),
                                "anh.vt.1888@aptechlearning.edu.vn", "Ha Noi", "0367899855",
                                new AccountModel("memberTuanAnh", "123456")
                        ),
                        "titile", "degree", Date.valueOf("2003-01-01")
                )
        );
        list.forEach(dt -> {
            System.out.println("Doctor:add success ? " + doctorM.addDoctor((DoctorLevelModel) dt));//add doctor (role id = 2)
        });
        int index = 0;
        for (String line : sessionWriter.getSession()) {
            if (line.startsWith("username=")) {
                System.out.println(line.split("=")[1]);
            }
            index++;
        }
        System.out.println(signEntity.signIn("admin", "123456", false));
        System.out.println(signEntity.signOut());
        System.out.println(userM.checkPhoneNumber("012345678a"));
    }
}
