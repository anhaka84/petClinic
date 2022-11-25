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

    public DoctorLevel(int doctorLevelId,
            String title, String degree, Date updateDate) {
        this.doctorLevelId = doctorLevelId;
        this.title = title;
        this.degree = degree;
        this.updateDate = updateDate;
    }

    public DoctorLevel(String title, String degree, Date updateDate) {
        this.title = title;
        this.degree = degree;
        this.updateDate = updateDate;
    }

    public DoctorLevel(User user, String title, String degree, Date updateDate) {
        super(user.getFullName(),
                user.getGender(),
                user.getDob(),
                user.getEmail(),
                user.getPhoneNumber(),
                user.getAddress(),
                user.getAccount());
        this.title = title;
        this.degree = degree;
        this.updateDate = updateDate;
    }

    public int getDoctorLevelId() {
        return doctorLevelId;
    }

    public void setDoctorLevelId(int doctorLevelId) {
        this.doctorLevelId = doctorLevelId;
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

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
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
        this.setDoctorLevelId(rs.getInt("doctor_level_id"));
        this.setTitle(rs.getString("title"));
        this.setDegree(rs.getString("degree"));
        this.setUpdateDate(rs.getDate("update_date"));
        return user;
    }

}
