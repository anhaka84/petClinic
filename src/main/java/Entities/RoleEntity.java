package Entities;

import DB.main.DB;
import Models.Role;
import java.util.Arrays;
import java.util.List;

public class RoleEntity {

    DB<Role> db = new DB<>();

    String query;
    List condition;

    public RoleEntity() {
    }

    public boolean addRole(Role role) {
        query = "INSERT INTO Role VALUES (?,?)";
        condition = Arrays.asList(role.getRoleId(), role.getRoleName());
        return db.setSqlDataRow(query, condition, role);
    }

    public List<Role> getAllRole() {
        query = "SELECT * FROM Role";
        return db.getAll(query, new Role());
    }

    public Role getOneRole(int roleId) {
        query = "SELECT * FROM Role WHERE role_id = ?";
        condition = Arrays.asList(roleId);
        return db.getOne(query, condition, new Role());
    }

    public boolean updateRole(Role role) {
        query = "UPDATE Role SET role_name = ? WHERE role_id = ?";
        condition = Arrays.asList(role.getRoleName(), role.getRoleId());
        return db.setSqlDataRow(query, condition, role);
    }

    public boolean deleteRole(int roleId) {
        query = "DELETE FROM Role WHERE role_id = ?";
        condition = Arrays.asList(roleId);
        return db.setSqlDataRow(query, condition, new Role());
    }
}
