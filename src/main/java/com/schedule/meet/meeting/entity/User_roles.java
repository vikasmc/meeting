package com.schedule.meet.meeting.entity;

import javax.management.relation.RoleList;
import javax.persistence.*;

//@Entity
//@Table(name = "user_roles", schema = "public")
public class User_roles {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_id_generator")
    @SequenceGenerator(name = "user_role_id_generator", sequenceName = "userrolesequence", allocationSize = 1)
    @Column(name="user_role_id", nullable=false)
    private Integer userRoleId;
    @Column(name="role_id", nullable=false)
    private RoleList roleList;
    @Column(name="user_id", nullable=false)
    private User user;


    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public RoleList getRoleList() {
        return roleList;
    }

    public void setRoleList(RoleList roleList) {
        this.roleList = roleList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
