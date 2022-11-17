package DB.core;

import DB.common.DBCommon;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Student
        extends DBCommon<Student> {

    private int rollNumber;
    private String name;
    private int gender;
    private String dob;
    private String email;
    private String mobile;
    private String address;

    public Student() {
    }

    public Student(int rollNumber, String name, int gender, String dob, String email, String mobile, String address) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + "rollNumber=" + rollNumber
                + ", name=" + name
                + ", gender=" + gender
                + ", dob=" + dob
                + ", email=" + email
                + ", mobile=" + mobile
                + ", address=" + address
                + '}';
    }

    @Override
    public Student setResultSetValue(Student classObj, ResultSet rs)
            throws SQLException {
        classObj.setRollNumber((int) rs.getObject("rollNumber"));
        classObj.setName(rs.getString("name"));
        classObj.setGender(rs.getInt("gender"));
        classObj.setDob(rs.getString("dob"));
        classObj.setEmail(rs.getString("email"));
        classObj.setMobile(rs.getString("mobile"));
        classObj.setAddress(rs.getString("address"));
        return classObj;
    }
}
