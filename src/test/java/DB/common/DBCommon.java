package DB.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @param <T>
 */
public abstract class DBCommon<T> {

    public abstract T setValue(T object, ResultSet rs) throws SQLException;

    public abstract T setvalue(T object, PreparedStatement preparedStatement) throws SQLException;

    public abstract List setvalue(T object);
}
