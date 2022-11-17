package DB.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @param <T>
 */
public abstract class DBCommon<T> {

    public T setResultSetValue(T object, ResultSet rs)
            throws SQLException {
        return null;
    }

    public T setPreparedStatementValue(T object, PreparedStatement preparedStatement)
            throws SQLException {
        return null;
    }

    public List setPreparedStatementValue(T object) {
        return null;
    }

}
