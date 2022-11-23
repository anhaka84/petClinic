package Models;

import DB.main.DB;
import Entities.DoctorLevel;
import Entities.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoctorModel {

    /**
     * SELECT u.*, dl.*, ds.* FROM pet_clinic.User AS u INNER JOIN
     * pet_clinic.DoctorLevel AS dl ON u.user_id = dl.user_id INNER JOIN
     * pet_clinic.doctorschedual AS ds ON u.user_id = ds.user_id WHERE u.user_id
     * = 2;
     */
    DB<DoctorLevel> db = new DB<>();
    String query;
    List condition;

    public DoctorModel() {
    }

    public User getOneDoctor(int user_id) {
        query = "SELECT u.*, dl.*"
                + " FROM pet_clinic.User AS u"
                + " INNER JOIN pet_clinic.DoctorLevel AS dl"
                + " ON u.user_id = dl.user_id"
                + " WHERE u.user_id = ?"
                + " AND u.role_id = 2";
        condition = Arrays.asList(user_id);
        return db.getOne(query, condition, new DoctorLevel());
    }

    public ArrayList<User> getAllDoctor() {
        query = "SELECT u.*, dl.*"
                + " FROM pet_clinic.User AS u"
                + " INNER JOIN pet_clinic.DoctorLevel AS dl"
                + " ON u.user_id = dl.user_id";
        return db.getAll(query, new DoctorLevel());
    }

}
