package Entities;

import Models.*;
import DB.main.DB;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DoctorEntity {

    private final DB<DoctorLevelModel> db = new DB<>();
    private final UserEntity userEntity = new UserEntity();

    private String query;
    private List condition;
    private final String columns = "("
            + "user_id, "
            + "title, "
            + "degree, "
            + "update_date"
            + ")";
    private final String dsColumns = "(user_id, "
            + "doctor_schedual_date, "
            + "doctor_schedual_time"
            + ")";

    public UserModel getOneDoctorUid(int userId) {
        query = "SELECT u.*, dl.*"
                + " FROM pet_clinic.User AS u"
                + " INNER JOIN pet_clinic.DoctorLevel AS dl"
                + " ON u.user_id = dl.user_id"
                + " WHERE u.user_id = ?";
        condition = Arrays.asList(userId);
        return db.getOne(query, condition, new DoctorLevelModel());
    }

    public UserModel getOneDoctorDid(int doctorId) {
        query = "SELECT u.*, dl.*"
                + " FROM pet_clinic.User AS u"
                + " INNER JOIN pet_clinic.DoctorLevel AS dl"
                + " ON u.user_id = dl.user_id"
                + " WHERE dl.doctor_level_id = ?"
                + " AND u.role_id = 2";
        condition = Arrays.asList(doctorId);
        return db.getOne(query, condition, new DoctorLevelModel());
    }

    public ArrayList<UserModel> getAllDoctor() {
        query = "SELECT u.*, dl.*"
                + " FROM pet_clinic.User AS u"
                + " INNER JOIN pet_clinic.DoctorLevel AS dl"
                + " ON u.user_id = dl.user_id";
        return db.getAll(query, new DoctorLevelModel());
    }

    public boolean addDoctor(DoctorLevelModel doctor) {
        doctor.setRole(2);
        if (userEntity.addUser(doctor)) {
            int id = userEntity.getUserId(doctor.getEmail(), doctor.getAccount().getUsername());
            doctor.setUserId(id);
        }
        return addDoctorLevel(doctor);
    }

    private boolean addDoctorLevel(DoctorLevelModel doctor) {
        query = "INSERT INTO DoctorLevel " + columns + " VALUES (?,?,?,?)";
        condition = Arrays.asList(
                doctor.getUserId(),
                doctor.getTitle(),
                doctor.getDegree(),
                doctor.getUpdateDate()
        );
        return db.setSqlDataRow(query, condition, doctor);
    }

    public UserModel getOneSchedual(int doctorSdId) {
        query = "SELECT * FROM DoctorSchedual"
                + " WHERE doctor_schedual_id = ?";
        condition = Arrays.asList(doctorSdId);
        return db.getOne(query, condition, new DoctorSchedualModel());
    }

    public List<UserModel> getAllSchedual() {
        query = "SELECT * FROM DoctorSchedual";
        return db.getAll(query, new DoctorSchedualModel());
    }

    public List<UserModel> getAllSchedualOf(int userId) {
        query = "SELECT * FROM DoctorSchedual"
                + " WHERE user_id = ?";
        condition = Arrays.asList(userId);
        return db.getAll(query, condition, new DoctorSchedualModel());
    }

    public boolean addSchedual(DoctorSchedualModel ds) {
        query = "INSERT INTO DoctorSchedual " + dsColumns
                + "VALUES (?,?,?)";
        condition = Arrays.asList(
                ds.getUserId(),
                ds.getDoctorSchedualDate(),
                ds.getDoctorSchedualTime()
        );
        return db.setSqlDataRow(query, condition, new DoctorSchedualModel());
    }

    public boolean deleteSchedual(int schedualId) {
        query = "DELETE FROM DoctorSchedual"
                + " WHERE doctor_schedual_id = ?";
        condition = Arrays.asList(schedualId);
        return db.setSqlDataRow(query, condition, new DoctorSchedualModel());
    }

}
