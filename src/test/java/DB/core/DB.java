package DB.core;

import DB.common.DBCommon;
import DB.dao.JDBCConnect;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DB<T> {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public DB() {
    }

    private void setPreparedStatement(List list) throws SQLException {
        int index = 1;
        for (Object obj : list) {
            if ("Integer".equals(obj.getClass().getSimpleName())) {
                preparedStatement.setInt(index, (int) obj);
            }
            if ("String".equals(obj.getClass().getSimpleName())) {
                preparedStatement.setString(index, obj.toString());
            }
            index++;
        }
    }
//getOne

    public <T extends DBCommon<T>>
            T getOne(String query, List condition, T classObject) {
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(query);
            setPreparedStatement(condition);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return classObject.setValue(classObject, rs);
            }
        } catch (SQLException ex) {
            System.out.println("getOne Fail !");
        } finally {
            JDBCConnect.closeJDBCConnection(rs, preparedStatement, connection);
        }
        return null;
    }
//getAll

    public <T extends DBCommon<T>>
            ArrayList<T> getAll(String query, T classObject) {
        ArrayList<T> arrayList = new ArrayList<>();
        try {
            String className = classObject.getClass().getName();
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(query);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                T obj = (T) Class.forName(className).getDeclaredConstructor().newInstance();
                arrayList.add(obj.setValue(obj, rs));
            }
            return arrayList;
        } catch (SQLException ex) {
            System.out.println("sql error !");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound");
        } catch (NoSuchMethodException | SecurityException
                | IllegalArgumentException | InvocationTargetException
                | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex);
        } finally {
            JDBCConnect.closeJDBCConnection(rs, preparedStatement, connection);
        }
        return null;
    }
//add

    public <T extends DBCommon<T>>
            boolean add(String query, T classObject) {
        boolean isTrue = false;
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(query);
            classObject.setvalue(classObject, preparedStatement);
            if (preparedStatement.executeUpdate() > 0) {
                isTrue = true;
            }
        } catch (SQLException ex) {
            System.out.println("add fail ! sql error");
        } finally {
            JDBCConnect.closeJDBCConnection(rs, preparedStatement, connection);
        }
        return isTrue;
    }

    public <T extends DBCommon<T>>
            boolean add(String query, List condition, T classObject) {
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(query);
            setPreparedStatement(condition);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("add fail ! sql error");
        } finally {
            JDBCConnect.closeJDBCConnection(rs, preparedStatement, connection);
        }
        return false;
    }
//update

    public <T extends DBCommon<T>>
            boolean update() {
                
                
        return false;
    }
//delete

    /**
     * main
     *
     * @param args
     */
    public static void main(String[] args) {

        DB<Student> db = new DB<>();

//getOne
        System.out.println("getOne()");
        Student student = new Student();

        String getOne_sql = "SELECT * FROM student WHERE rollNumber = ?";
        List condition = Arrays.asList(1); // nhap vao rollNumber va nhung dieu kien khac 

        System.out.println(db.getOne(getOne_sql, condition, student));

//getAll
        System.out.println("getAll()");
        String getAll_sql = "SELECT * FROM student";
        for (Student s : db.getAll(getAll_sql, new Student())) {
            System.out.println(s);
        }
//add
//cach 1
        System.out.println("add()");

        String add_sql = "INSERT INTO student VALUES (?,?,?,?,?,?,?,?)";

        Student new_std1
                = new Student(5, "name5", 0, "11-11-2011", "name5@name5.com", "1234567890", "abcxyz");
        System.out.println(db.add(add_sql, new_std1));
//cach 2
        Student new_std2
                = new Student(7, "name7", 0, "11-11-2011", "name7@name7.com", "1234567890", "abcxyz");

        List condition2 = new_std2.setvalue(new_std2);
        System.out.println(db.add(add_sql, condition2, new_std2));
//update
//delete
    }
}
