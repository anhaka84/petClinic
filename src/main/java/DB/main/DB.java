package DB.main;

import DB.common.DBCommon;
import DB.dao.JDBCConnect;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DB<T> {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet rs = null;

    public DB() {
    }

    private void setPreparedStatement(List list)
            throws SQLException {
        int index = 1;
        for (Object obj : list) {
            preparedStatement.setObject(index, obj);
            index++;
        }
    }

    public <T extends DBCommon<T>>
            T getOne(String query, List condition, T classObject) {
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(query);
            setPreparedStatement(condition);
            rs = preparedStatement.executeQuery();
            if (rs.next()) {
                return classObject.setResultSetValue(classObject, rs);
            }
        } catch (SQLException ex) {
            System.out.println("getOne Fail !");
        } finally {
            JDBCConnect.closeJDBCConnection(rs, preparedStatement, connection);
        }
        return null;
    }

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
                arrayList.add(obj.setResultSetValue(obj, rs));
            }
            return arrayList;
        } catch (SQLException ex) {
            System.out.println("sql error !");
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFound");
        } catch (NoSuchMethodException | SecurityException | IllegalArgumentException
                | InvocationTargetException | InstantiationException | IllegalAccessException ex) {
            System.out.println(ex);
        } finally {
            JDBCConnect.closeJDBCConnection(rs, preparedStatement, connection);
        }
        return null;
    }

    public <T extends DBCommon<T>>
            boolean setSqlDataRow(String query, List condition, T classObject) {
        try {
            connection = JDBCConnect.getJDBCConnection();
            preparedStatement = connection.prepareStatement(query);
            setPreparedStatement(condition);
            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("failed sql error");
        } finally {
            JDBCConnect.closeJDBCConnection(rs, preparedStatement, connection);
        }
        return false;
    }
}
