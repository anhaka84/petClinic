package Entities;

import java.sql.Date;

public class Doctor {

    private int doctor_id;
    private String title;
    private String degree;
    private Date update_date;
    private Date schedual_date;
    private String schedual_time;

    public Doctor() {
    }

    public Doctor(int doctor_id, String title, String degree, Date update_date,
            Date schedual_date, String schedual_time) {
        this.doctor_id = doctor_id;
        this.title = title;
        this.degree = degree;
        this.update_date = update_date;
        this.schedual_date = schedual_date;
        this.schedual_time = schedual_time;
    }

    public Doctor(int doctor_id, String title, String degree, Date update_date,
            Date schedual_date, String schedual_time, int user_id, int role_id,
            String full_name, int gender, Date dob, String email, String address,
            String phone_number, String username, String password) {
//        super(user_id, role_id, full_name, gender, dob, email, address, phone_number, username, password);
        this.doctor_id = doctor_id;
        this.title = title;
        this.degree = degree;
        this.update_date = update_date;
        this.schedual_date = schedual_date;
        this.schedual_time = schedual_time;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
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

    public Date getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(Date update_date) {
        this.update_date = update_date;
    }

    public Date getSchedual_date() {
        return schedual_date;
    }

    public void setSchedual_date(Date schedual_date) {
        this.schedual_date = schedual_date;
    }

    public String getSchedual_time() {
        return schedual_time;
    }

    public void setSchedual_time(String schedual_time) {
        this.schedual_time = schedual_time;
    }

    @Override
    public String toString() {
        return "Doctor{" + "doctor_id=" + doctor_id + ", title=" + title + ", degree=" + degree + ", update_date=" + update_date + ", schedual_date=" + schedual_date + ", schedual_time=" + schedual_time + '}';
    }

}
