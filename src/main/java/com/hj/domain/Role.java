package com.hj.domain;

import java.io.Serializable;
import java.util.List;

/**
 * @author Love-hj
 * @date 2020/3/26 - 15:50
 */
public class Role implements Serializable {

    private Integer roleId;
    private String roleName;
    private String roleSex;
    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleSex() {
        return roleSex;
    }

    public void setRoleSex(String roleSex) {
        this.roleSex = roleSex;
    }

    @Override
    public String toString() {
        return "Role{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleSex='" + roleSex + '\'' +
                '}';
    }
}
