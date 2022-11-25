package Models;

import DB.main.DB;
import Entities.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoctorModel {

    DB<DoctorLevel> db = new DB<>();
    UserModel userM = new UserModel();

    String query;
    List condition;
    String columns = "("
            + "user_id, "
            + "title, "
            + "degree, "
            + "update_date"
            + ")";
    String dsColumns = "(user_id, "
            + "doctor_schedual_date, "
            + "doctor_schedual_time"
            + ")";

    public DoctorModel() {
    }

    /**
     * doctor level
     */
    /**
     *
     * @param userId
     * @return
     */
    public User getOneDoctorUid(int userId) {
        query = "SELECT u.*, dl.*"
                + " FROM pet_clinic.User AS u"
                + " INNER JOIN pet_clinic.DoctorLevel AS dl"
                + " ON u.user_id = dl.user_id"
                + " WHERE u.user_id = ?";
        condition = Arrays.asList(userId);
        return db.getOne(query, condition, new DoctorLevel());
    }

    public User getOneDoctorDid(int doctorId) {
        query = "SELECT u.*, dl.*"
                + " FROM pet_clinic.User AS u"
                + " INNER JOIN pet_clinic.DoctorLevel AS dl"
                + " ON u.user_id = dl.user_id"
                + " WHERE dl.doctor_level_id = ?"
                + " AND u.role_id = 2";
        condition = Arrays.asList(doctorId);
        return db.getOne(query, condition, new DoctorLevel());
    }

    public ArrayList<User> getAllDoctor() {
        query = "SELECT u.*, dl.*"
                + " FROM pet_clinic.User AS u"
                + " INNER JOIN pet_clinic.DoctorLevel AS dl"
                + " ON u.user_id = dl.user_id";
        return db.getAll(query, new DoctorLevel());
    }

    public boolean addDoctor(DoctorLevel doctor) {
        doctor.setRole(2);
        if (userM.addUser(doctor)) {
            int id = userM.getUserId(doctor.getEmail(), doctor.getAccount().getUsername());
            doctor.setUserId(id);
        }
        return addDoctorLevel(doctor);
    }

    private boolean addDoctorLevel(DoctorLevel doctor) {
        query = "INSERT INTO DoctorLevel " + columns + " VALUES (?,?,?,?)";
        condition = Arrays.asList(
                doctor.getUserId(),
                doctor.getTitle(),
                doctor.getDegree(),
                doctor.getUpdateDate()
        );
        return db.setSqlDataRow(query, condition, doctor);
    }

    /**
     * doctor schedual
     */
    /**
     *
     * @param doctorSdId
     * @return
     */
    public User getOneSchedual(int doctorSdId) {
        query = "SELECT * FROM DoctorSchedual"
                + " WHERE doctor_schedual_id = ?";
        condition = Arrays.asList(doctorSdId);
        return db.getOne(query, condition, new DoctorSchedual());
    }

    public List<User> getAllSchedual() {
        query = "SELECT * FROM DoctorSchedual";
        return db.getAll(query, new DoctorSchedual());
    }

    public List<User> getAllSchedualOf(int userId) {
        query = "SELECT * FROM DoctorSchedual"
                + " WHERE user_id = ?";
        condition = Arrays.asList(userId);
        return db.getAll(query, condition, new DoctorSchedual());
    }

    public boolean addSchedual(DoctorSchedual ds) {
        query = "INSERT INTO DoctorSchedual " + dsColumns
                + "VALUES (?,?,?)";
        condition = Arrays.asList(
                ds.getUserId(),
                ds.getDoctorSchedualDate(),
                ds.getDoctorSchedualTime()
        );
        return db.setSqlDataRow(query, condition, new DoctorSchedual());
    }
}
