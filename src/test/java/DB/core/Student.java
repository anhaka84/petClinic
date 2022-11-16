package DB.core;

import DB.common.DBCommon;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Student extends DBCommon<Student> {

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
    public Student setValue(Student classObj, ResultSet rs)
            throws SQLException {
        classObj.setRollNumber(rs.getInt("rollNumber"));
        classObj.setName(rs.getString("name"));
        classObj.setGender(rs.getInt("gender"));
        classObj.setDob(rs.getString("dob"));
        classObj.setEmail(rs.getString("email"));
        classObj.setMobile(rs.getString("mobile"));
        classObj.setAddress(rs.getString("address"));
        return classObj;
    }

    @Override
    public Student setvalue(Student object, PreparedStatement preparedStatement)
            throws SQLException {
        preparedStatement.setInt(1, object.getRollNumber());
        preparedStatement.setString(2, object.getName());
        preparedStatement.setInt(3, object.getGender());
        preparedStatement.setString(4, object.getDob());
        preparedStatement.setString(5, object.getEmail());
        preparedStatement.setString(6, object.getMobile());
        preparedStatement.setString(7, object.getAddress());
        preparedStatement.setString(8, "0");
        return object;
    }

    @Override
    public List setvalue(Student object) {
        List condition = Arrays.asList(
                object.getRollNumber(),
                object.getName(),
                object.getGender(),
                object.getDob(),
                object.getEmail(),
                object.getMobile(),
                object.getAddress(),
                "0"
        );
        return condition;
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

//    public static void main(String[] args) {
//        StudentModel sm = new StudentModel();
//        sm.getAll().forEach(s -> System.out.println(s));
//        System.out.println(sm.getOne(3));
//
//        Student s1 = new Student(1, "name1", 0, "11/11/1111", "name1@name1.com", "9999999999", "address");
//        System.out.println(sm.delete(4));
//    }
}
