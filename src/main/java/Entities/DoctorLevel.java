package Entities;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorLevel extends User {

    private int doctorLevelId;
    private String title;
    private String degree;
    private Date updateDate;

    public DoctorLevel() {
    }

    public DoctorLevel(int doctor_level_id,
            String title, String degree, Date update_date) {
        this.doctorLevelId = doctor_level_id;
        this.title = title;
        this.degree = degree;
        this.updateDate = update_date;
    }

    public int getDoctor_level_id() {
        return doctorLevelId;
    }

    public void setDoctor_level_id(int doctor_level_id) {
        this.doctorLevelId = doctor_level_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date update_date) {
        this.updateDate = update_date;
    }

    @Override
    public String toString() {
        return "Doctor{"
                + "doctorLevelId=" + doctorLevelId
                + ", " + super.toString()
                + ", title=" + title
                + ", degree=" + degree
                + ", updateDate=" + updateDate
                + '}';
    }

    @Override
    public User setResultSetValue(User user, ResultSet rs)
            throws SQLException {
        super.setResultSetValue(user, rs);
        this.setDoctor_level_id(rs.getInt("doctor_level_id"));
        this.setTitle(rs.getString("title"));
        this.setDegree(rs.getString("degree"));
        this.setUpdateDate(rs.getDate("update_date"));
        return user;
    }

}
