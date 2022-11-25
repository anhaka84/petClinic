package Entities;

import DB.common.DBCommon;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Role extends DBCommon<Role> {

    private int roleId;
    private String roleName;

    public Role() {
    }

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{" + "roleId=" + roleId + ", roleName=" + roleName + '}';
    }

    @Override
    public Role setResultSetValue(Role object, ResultSet rs)
            throws SQLException {
        object.setRoleId(rs.getInt("role_id"));
        object.setRoleName(rs.getString("role_name"));
        return object;
    }

}
