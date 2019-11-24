package com.schedule.meet.meeting.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_roles", schema = "public")
public class User_roles {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_role_id_generator")
    @SequenceGenerator(name = "user_role_id_generator", sequenceName = "userrolesequence", allocationSize = 1)
    @Column(name="user_role_id", nullable=false)
    private Integer userRoleId;
    @Column(name="role_id", nullable=false)
    private Long role_id;
    @Column(name="userId", nullable=false)
    private Integer userId;


    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer user) {
        this.userId = user;
    }
}
